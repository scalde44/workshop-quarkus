package co.com.api.compras.infraestructure.config;

import co.com.api.compras.domain.model.ports.SolicitudRepository;
import co.com.api.compras.domain.usecase.CrearSolicitudUseCase;
import co.com.api.compras.domain.usecase.DeleteSolicitudUseCase;
import co.com.api.compras.domain.usecase.UpdateSolicitudUseCase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class UseCasesConfig {
    @Produces
    @ApplicationScoped
    public CrearSolicitudUseCase crearSolicitudUseCase(SolicitudRepository solicitudRepository) {
        return new CrearSolicitudUseCase(solicitudRepository);
    }

    @Produces
    @ApplicationScoped
    public DeleteSolicitudUseCase deleteSolicitudUseCase(SolicitudRepository solicitudRepository) {
        return new DeleteSolicitudUseCase(solicitudRepository);
    }

    @Produces
    @ApplicationScoped
    public UpdateSolicitudUseCase updateSolicitudUseCase(SolicitudRepository solicitudRepository) {
        return new UpdateSolicitudUseCase(solicitudRepository);
    }
}
