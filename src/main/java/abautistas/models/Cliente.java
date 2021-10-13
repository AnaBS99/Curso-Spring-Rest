package abautistas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NonNull
    private String nombre;

    @Size(max = 9, min = 9)
    private String telefono;

    public Cliente(){
        this.nombre = "";
        this.telefono = "";
    }

    public Cliente(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
