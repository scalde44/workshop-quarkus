package co.com.api.compras.application.command;

import co.com.api.compras.domain.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSolicitudCommand extends UpdateSolicitudCommand {
    private Usuario usuario;
}
