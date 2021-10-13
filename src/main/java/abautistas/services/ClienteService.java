package abautistas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import abautistas.models.Cliente;
import abautistas.repositories.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente save(Cliente cliente) {
        Cliente nuevoCliente = new Cliente(cliente.getNombre(), cliente.getTelefono());
        return repository.save(nuevoCliente);
    }

    public Optional<Cliente> findById(Integer id) {
        return repository.findById(id);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }
}
