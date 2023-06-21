package co.com.api.compras.application.command.handler;

import co.com.api.compras.application.command.CreateSolicitudCommand;
import co.com.api.compras.application.command.factory.SolicitudFactory;
import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.domain.usecase.CrearSolicitudUseCase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
@ApplicationScoped
public class CreateSolicitudCommandHandler implements Function<CreateSolicitudCommand, Uni<Solicitud>> {
    private final SolicitudFactory solicitudFactory;
    private final CrearSolicitudUseCase crearSolicitudUseCase;

    @Override
    public Uni<Solicitud> apply(CreateSolicitudCommand createSolicitudCommand) {
        return Uni.createFrom()
                .item(createSolicitudCommand)
                .map(this.solicitudFactory::create)
                .flatMap(this.crearSolicitudUseCase::apply);
    }
}
