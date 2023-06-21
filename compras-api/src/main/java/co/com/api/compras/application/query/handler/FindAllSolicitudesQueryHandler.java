package co.com.api.compras.application.query.handler;

import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.model.ports.SolicitudRepository;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.function.Supplier;

@ApplicationScoped
public class FindAllSolicitudesQueryHandler implements Supplier<Multi<Solicitud>> {
    private final SolicitudRepository solicitudRepository;

    @Inject
    public FindAllSolicitudesQueryHandler(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @Override
    public Multi<Solicitud> get() {
        return this.solicitudRepository.findAll();
    }
}
