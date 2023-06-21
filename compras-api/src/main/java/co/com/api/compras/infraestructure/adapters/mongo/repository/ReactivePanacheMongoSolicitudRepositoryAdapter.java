package co.com.api.compras.infraestructure.adapters.mongo.repository;

import co.com.api.compras.domain.excepcion.SolicitudNoEliminadaException;
import co.com.api.compras.domain.excepcion.SolicitudNoEncontradaException;
import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.model.ports.SolicitudRepository;
import co.com.api.compras.infraestructure.adapters.mongo.mapper.SolicitudMongoMapper;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

@ApplicationScoped
public class ReactivePanacheMongoSolicitudRepositoryAdapter implements SolicitudRepository {
    private final ReactivePanacheMongoSolicitudRepository reactiveSolicitudRepository;
    private final SolicitudMongoMapper solicitudMongoMapper;

    @Inject
    public ReactivePanacheMongoSolicitudRepositoryAdapter(ReactivePanacheMongoSolicitudRepository reactiveSolicitudRepository,
                                                          SolicitudMongoMapper solicitudMongoMapper) {
        this.reactiveSolicitudRepository = reactiveSolicitudRepository;
        this.solicitudMongoMapper = solicitudMongoMapper;
    }

    @Override
    public Uni<Solicitud> save(Solicitud solicitud) {
        return Uni.createFrom()
                .item(solicitud)
                .onItem()
                .transform(this.solicitudMongoMapper::toEntity)
                .call(this.reactiveSolicitudRepository::persist)
                .map(this.solicitudMongoMapper::toModel);
    }

    @Override
    public Uni<Solicitud> update(Solicitud solicitud) {
        return Uni.createFrom()
                .item(solicitud)
                .onItem()
                .transform(this.solicitudMongoMapper::toEntity)
                .call(this.reactiveSolicitudRepository::update)
                .map(this.solicitudMongoMapper::toModel);
    }

    @Override
    public Multi<Solicitud> findAll() {
        return this.reactiveSolicitudRepository.findAll()
                .stream()
                .map(this.solicitudMongoMapper::toModel);
    }

    @Override
    public Uni<Solicitud> findById(String id) {
        return this.reactiveSolicitudRepository.findById(new ObjectId(id))
                .onItem()
                .ifNull()
                .failWith(() -> new SolicitudNoEncontradaException(id))
                .map(this.solicitudMongoMapper::toModel);
    }

    @Override
    public Uni<Void> deleteById(String id) {
        return this.reactiveSolicitudRepository.deleteById(new ObjectId(id))
                .flatMap(removed -> Boolean.TRUE.equals((removed)) ?
                        Uni.createFrom().voidItem() :
                        Uni.createFrom().failure(new SolicitudNoEliminadaException(id)));
    }

    @Override
    public Uni<Boolean> existsById(String id) {
        return this.reactiveSolicitudRepository.existsById(new ObjectId(id));
    }
}
