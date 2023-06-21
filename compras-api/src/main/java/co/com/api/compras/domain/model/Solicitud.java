package co.com.api.compras.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Solicitud {
    private String id;
    private Usuario usuario;
    private BigDecimal total;
    private Tarjeta medioPago;
    private List<Producto> productos;
    private LocalDateTime fechaCreacion;

    public Solicitud(Usuario usuario, Tarjeta medioPago, List<Producto> productos) {
        this.usuario = usuario;
        this.medioPago = medioPago;
        this.productos = productos;
        this.total = calcularTotal(productos);
        this.fechaCreacion = LocalDateTime.now();
    }

    public Solicitud(Tarjeta medioPago, List<Producto> productos) {
        this.medioPago = medioPago;
        this.productos = productos;
        this.total = calcularTotal(productos);
    }

    private static BigDecimal calcularTotal(List<Producto> productos) {
        return productos.stream()
                .map(Producto::total)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
