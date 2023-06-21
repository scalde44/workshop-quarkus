package co.com.api.compras.infraestructure.adapters.mongo.repository;

import co.com.api.compras.infraestructure.adapters.mongo.entity.SolicitudEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

import java.util.Objects;

@ApplicationScoped
public class ReactivePanacheMongoSolicitudRepository implements ReactivePanacheMongoRepositoryBase<SolicitudEntity, ObjectId> {
    public Uni<Boolean> existsById(ObjectId id) {
        return findById(id)
                .onItem()
                .transform(Objects::nonNull);
    }
}
