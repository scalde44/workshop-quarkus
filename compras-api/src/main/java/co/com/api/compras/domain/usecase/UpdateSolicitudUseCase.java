package co.com.api.compras.domain.usecase;

import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.model.ports.SolicitudRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class UpdateSolicitudUseCase implements BiFunction<Solicitud, String, Uni<Solicitud>> {
    private final SolicitudRepository solicitudRepository;

    @Override
    public Uni<Solicitud> apply(Solicitud solicitud, String id) {
        return this.solicitudRepository.findById(id)
                .onItem()
                .transform(item -> solicitud
                        .toBuilder()
                        .id(item.getId())
                        .usuario(item.getUsuario())
                        .fechaCreacion(item.getFechaCreacion())
                        .build())
                .call(this.solicitudRepository::update);
    }
}
