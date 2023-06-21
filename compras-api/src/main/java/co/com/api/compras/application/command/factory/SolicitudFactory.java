package co.com.api.compras.application.command.factory;

import co.com.api.compras.application.command.CreateSolicitudCommand;
import co.com.api.compras.application.command.UpdateSolicitudCommand;
import co.com.api.compras.domain.model.Solicitud;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SolicitudFactory {
    public Solicitud create(CreateSolicitudCommand createSolicitudCommand) {
        return new Solicitud(
                createSolicitudCommand.getUsuario(),
                createSolicitudCommand.getMedioPago(),
                createSolicitudCommand.getProductos()
        );
    }

    public Solicitud create(UpdateSolicitudCommand updateSolicitudCommand) {
        return new Solicitud(
                updateSolicitudCommand.getMedioPago(),
                updateSolicitudCommand.getProductos()
        );
    }
}
