package co.com.api.compras.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Producto {
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
    public BigDecimal total() {
        return this.precio.multiply(BigDecimal.valueOf(this.cantidad));
    }
}
