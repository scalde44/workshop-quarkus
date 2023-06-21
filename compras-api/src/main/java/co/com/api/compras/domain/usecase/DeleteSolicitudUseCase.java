package co.com.api.compras.domain.usecase;

import co.com.api.compras.domain.excepcion.SolicitudNoEncontradaException;
import co.com.api.compras.domain.model.ports.SolicitudRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class DeleteSolicitudUseCase implements Function<String, Uni<Void>> {
    private final SolicitudRepository solicitudRepository;

    @Override
    public Uni<Void> apply(String id) {
        return this.solicitudRepository.existsById(id)
                .flatMap(exists -> exists ?
                        this.solicitudRepository.deleteById(id) :
                        Uni.createFrom().failure(new SolicitudNoEncontradaException(id)));
    }
}
