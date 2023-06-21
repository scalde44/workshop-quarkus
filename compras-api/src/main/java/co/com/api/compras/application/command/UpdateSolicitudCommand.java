package co.com.api.compras.application.command;

import co.com.api.compras.domain.model.Producto;
import co.com.api.compras.domain.model.Tarjeta;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateSolicitudCommand {
    private Tarjeta medioPago;
    private List<Producto> productos;
}
