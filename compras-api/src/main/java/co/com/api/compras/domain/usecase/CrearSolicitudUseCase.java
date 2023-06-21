package co.com.api.compras.domain.usecase;

import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.model.ports.SolicitudRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class CrearSolicitudUseCase implements Function<Solicitud, Uni<Solicitud>> {
    private final SolicitudRepository solicitudRepository;

    @Override
    public Uni<Solicitud> apply(Solicitud solicitud) {
        return this.solicitudRepository.save(solicitud);
    }
}
