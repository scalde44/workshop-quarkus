package co.com.api.compras.domain.excepcion;

public class SolicitudNoEncontradaException extends RuntimeException {
    private static final String SOLICITUD_NO_ENCONTRADA = "La solicitud con el id %s no existe";

    public SolicitudNoEncontradaException(String id) {
        super(String.format(SOLICITUD_NO_ENCONTRADA, id));
    }

    public SolicitudNoEncontradaException(String message, Throwable e) {
        super(message, e);
    }
}
