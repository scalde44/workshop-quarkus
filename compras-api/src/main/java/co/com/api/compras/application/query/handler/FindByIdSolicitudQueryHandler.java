package co.com.api.compras.application.query.handler;

import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.model.ports.SolicitudRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.function.Function;

@ApplicationScoped
public class FindByIdSolicitudQueryHandler implements Function<String, Uni<Solicitud>> {
    private final SolicitudRepository solicitudRepository;

    @Inject
    public FindByIdSolicitudQueryHandler(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public Uni<Solicitud> apply(String id) {
        return this.solicitudRepository.findById(id);
    }
}
