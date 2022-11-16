package ec3.kevinramirez.cita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec3.kevinramirez.cita.model.Cliente;



@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
