package co.com.api.compras.domain.model.ports;

import co.com.api.compras.domain.model.Solicitud;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public interface SolicitudRepository {
    Uni<Solicitud> save(Solicitud solicitud);

    Uni<Solicitud> update(Solicitud solicitud);

    Multi<Solicitud> findAll();

    Uni<Solicitud> findById(String id);

    Uni<Void> deleteById(String id);

    Uni<Boolean> existsById(String id);
}
