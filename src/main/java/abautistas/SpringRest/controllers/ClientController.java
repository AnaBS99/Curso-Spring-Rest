package abautistas.SpringRest.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import abautistas.DTOs.ClienteDTO;
import abautistas.DTOs.ClienteListDTO;
import abautistas.models.Cliente;
import abautistas.services.ClienteService;

@RestController
public class ClientController {
    
    @Autowired
    private ClienteService service;

    @GetMapping("/api/clientes")
    public ClienteListDTO getAll(){
        List<Cliente> clientes = service.findAll();
        if (clientes == null){
            return new ClienteListDTO(true, null, "Ha habido un problema con la Base de datos");
        }
        return new ClienteListDTO(false, clientes, "");
    }
    @PostMapping("/api/clientes")
    public ClienteDTO postDato(@Valid @RequestBody Cliente cliente){
        Cliente nuevoCliente = service.save(cliente);
        if (nuevoCliente == null){
            return new ClienteDTO(true, null, "Problema al añadir el cliente");
        }
        return new ClienteDTO(false, nuevoCliente, "");
    }
    @GetMapping("/api/clientes/{id}")
    public ClienteDTO getByID(@PathVariable Integer id){
        try {
            Cliente ret= service.findById(id).get();
            return new ClienteDTO(false,ret, "");
        }catch (NoSuchElementException e){
            return new ClienteDTO(true, null, "Cliente no encontrado");
        }
    }

    @PutMapping("/api/clientes/{id}")
    public ClienteDTO updateById(@PathVariable Integer id, @Valid @RequestBody Cliente clienteModificado){
        try {
            Cliente cliente= service.findById(id).get();
            cliente.setNombre(clienteModificado.getNombre());
            cliente.setTelefono(clienteModificado.getTelefono());
            service.update(cliente);
            return new ClienteDTO(false,cliente, "");
        }catch (NoSuchElementException e){
            return new ClienteDTO(true, null, "Cliente no encontrado");
        }
    }
    @DeleteMapping("/api/clientes/{id}")
    public ClienteDTO deleteByID(@PathVariable Integer id){
        try {
            Cliente clienteDTO= service.findById(id).get();
            service.deleteById(id);
            return new ClienteDTO(false,clienteDTO, "");
        }catch (NoSuchElementException e){
            return new ClienteDTO(true, null, "Cliente no encontrado");
        }
    }
}
