package abautistas.repositories;

import org.springframework.stereotype.Repository;
import abautistas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
