package co.com.api.compras.infraestructure.error;

import co.com.api.compras.domain.excepcion.SolicitudNoEncontradaException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Provider
public class GlobalExcepcionHandler implements ExceptionMapper<Exception> {
    private static final String
            OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error favor contactar al administrador";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public GlobalExcepcionHandler() {
        CODIGOS_ESTADO.put(SolicitudNoEncontradaException.class.getSimpleName(), RestResponse.StatusCode.NOT_FOUND);
    }

    @Override
    public Response toResponse(Exception exception) {
        String nameException = exception.getClass().getSimpleName();
        ErrorResponse errorResponse = Optional.ofNullable(CODIGOS_ESTADO.get(nameException))
                .map(status -> new ErrorResponse(nameException, exception.getMessage(), status))
                .orElse(new ErrorResponse(nameException, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR,
                        RestResponse.StatusCode.INTERNAL_SERVER_ERROR));
        return Response.status(errorResponse.getStatus())
                .entity(errorResponse)
                .build();
    }
}