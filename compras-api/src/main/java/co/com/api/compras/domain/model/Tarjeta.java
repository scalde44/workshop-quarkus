package co.com.api.compras.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tarjeta {
    private String numero;
    private Integer mesCaducidad;
    private Integer anioCaducidad;
    private String cvv;
    private String propietario;
}
