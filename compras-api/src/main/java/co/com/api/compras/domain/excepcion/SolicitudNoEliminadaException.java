package co.com.api.compras.domain.excepcion;

public class SolicitudNoEliminadaException extends RuntimeException {
    private static final String SOLICITUD_NO_ELIMINADA = "La solicitud con el id %s no pudo ser eliminada";

    public SolicitudNoEliminadaException(String id) {
        super(String.format(SOLICITUD_NO_ELIMINADA, id));
    }
}
