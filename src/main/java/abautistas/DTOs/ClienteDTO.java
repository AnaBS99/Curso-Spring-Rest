package abautistas.DTOs;

import lombok.Data;
import abautistas.models.Cliente;

@Data
public class ClienteDTO {
    
    private Boolean errors;
    private Cliente cliente;
    private String message;

    public ClienteDTO(Boolean b, Cliente cliente, String message){
        this.errors = b;
        this.cliente = cliente;
        this.message = message;
    }
}
