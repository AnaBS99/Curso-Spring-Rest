package abautistas.DTOs;

import lombok.Data;
import java.util.List;
import abautistas.models.Cliente;

@Data
public class ClienteListDTO {
    
    private Boolean errors;
    private List<Cliente> clientes;
    private String message;

    public ClienteListDTO(Boolean b, List<Cliente> clientes, String message){
        this.errors = b;
        this.clientes = clientes;
        this.message = message;
    }
}
