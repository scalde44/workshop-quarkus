package co.com.api.compras.infraestructure.entrypoints.resource;

import co.com.api.compras.application.query.handler.FindAllSolicitudesQueryHandler;
import co.com.api.compras.application.query.handler.FindByIdSolicitudQueryHandler;
import co.com.api.compras.domain.model.Solicitud;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;

@Path("/solicitudes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class SolicitudQueryResource {
    private final FindAllSolicitudesQueryHandler findAllSolicitudesQueryHandler;
    private final FindByIdSolicitudQueryHandler findByIdSolicitudQueryHandler;


    @GET
    public Multi<Solicitud> obtenerTodos() {
        return this.findAllSolicitudesQueryHandler.get();
    }

    @GET
    @Path("/{id}")
    public Uni<Solicitud> obtenerPorId(@PathParam("id") String id) {
        return this.findByIdSolicitudQueryHandler.apply(id);
    }

}
