package co.com.api.compras.infraestructure.adapters.mongo.mapper;

import co.com.api.compras.domain.model.Solicitud;
import co.com.api.compras.infraestructure.adapters.mongo.entity.SolicitudEntity;
import jakarta.inject.Singleton;

@Singleton
public class SolicitudMongoMapper {
    public Solicitud toModel(SolicitudEntity entity) {
        return new Solicitud(
                entity.getId().toString(),
                entity.getUsuario(),
                entity.getTotal(),
                entity.getMedioPago(),
                entity.getProductos(),
                entity.getFechaCreacion()
        );
    }

    public SolicitudEntity toEntity(Solicitud model) {
        return new SolicitudEntity(
                model.getId(),
                model.getUsuario(),
                model.getTotal(),
                model.getMedioPago(),
                model.getProductos(),
                model.getFechaCreacion()
        );
    }
}
