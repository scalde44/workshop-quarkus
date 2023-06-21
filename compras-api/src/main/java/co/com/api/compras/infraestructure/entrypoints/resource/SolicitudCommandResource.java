package co.com.api.compras.infraestructure.entrypoints.resource;

import co.com.api.compras.application.command.CreateSolicitudCommand;
import co.com.api.compras.application.command.UpdateSolicitudCommand;
import co.com.api.compras.application.command.handler.CreateSolicitudCommandHandler;
import co.com.api.compras.application.command.handler.DeleteSolicitudCommandHandler;
import co.com.api.compras.application.command.handler.UpdateSolicitudCommandHandler;
import co.com.api.compras.domain.model.Solicitud;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestResponse;

@Path("/solicitudes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class SolicitudCommandResource {
    private final CreateSolicitudCommandHandler createSolicitudCommandHandler;
    private final DeleteSolicitudCommandHandler deleteSolicitudCommandHandler;
    private final UpdateSolicitudCommandHandler updateSolicitudCommandHandler;


    @POST
    @ResponseStatus(value = RestResponse.StatusCode.CREATED)
    public Uni<Solicitud> crear(CreateSolicitudCommand command) {
        return this.createSolicitudCommandHandler.apply(command);
    }


    @DELETE
    @Path("/{id}")
    @ResponseStatus(value = RestResponse.StatusCode.NO_CONTENT)
    public Uni<Void> eliminar(@PathParam("id") String id) {
        return this.deleteSolicitudCommandHandler.apply(id);
    }

    @PUT
    @Path("/{id}")
    public Uni<Solicitud> actualizar(@PathParam("id") String id, UpdateSolicitudCommand command) {
        return this.updateSolicitudCommandHandler.apply(command, id);
    }

}
