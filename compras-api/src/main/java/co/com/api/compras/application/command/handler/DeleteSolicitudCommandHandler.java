package co.com.api.compras.application.command.handler;

import co.com.api.compras.domain.usecase.DeleteSolicitudUseCase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
@ApplicationScoped
public class DeleteSolicitudCommandHandler implements Function<String, Uni<Void>> {
    private final DeleteSolicitudUseCase deleteSolicitudUseCase;

    @Override
    public Uni<Void> apply(String id) {
        return this.deleteSolicitudUseCase.apply(id);
    }
}
