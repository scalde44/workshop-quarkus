package co.com.api.compras.application.command.handler;

import co.com.api.compras.application.command.UpdateSolicitudCommand;
import co.com.api.compras.application.command.factory.SolicitudFactory;
import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.usecase.UpdateSolicitudUseCase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@RequiredArgsConstructor
@ApplicationScoped
public class UpdateSolicitudCommandHandler implements BiFunction<UpdateSolicitudCommand, String, Uni<Solicitud>> {
    private final SolicitudFactory solicitudFactory;
    private final UpdateSolicitudUseCase updateSolicitudUseCase;

    @Override
    public Uni<Solicitud> apply(UpdateSolicitudCommand updateSolicitudCommand, String id) {
        return Uni.createFrom()
                .item(updateSolicitudCommand)
                .map(this.solicitudFactory::create)
                .flatMap(solicitud -> this.updateSolicitudUseCase.apply(solicitud, id));
    }
}
