package co.com.api.compras.infraestructure.adapters.mongo.entity;

import co.com.api.compras.domain.model.Producto;
import co.com.api.compras.domain.model.Tarjeta;
import co.com.api.compras.domain.model.Usuario;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@MongoEntity(collection = "solicitudes")
public class SolicitudEntity {
    private ObjectId id;
    private Usuario usuario;
    private BigDecimal total;
    private Tarjeta medioPago;
    private List<Producto> productos;
    private LocalDateTime fechaCreacion;

    public SolicitudEntity(String id, Usuario usuario, BigDecimal total, Tarjeta medioPago, List<Producto> productos, LocalDateTime fechaCreacion) {
        if (id != null) {
            this.id = new ObjectId(id);
        }
        this.usuario = usuario;
        this.total = total;
        this.medioPago = medioPago;
        this.productos = productos;
        this.fechaCreacion = fechaCreacion;
    }
}
