package ec3.kevinramirez.cita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import ec3.kevinramirez.cita.model.UsuarioCliente;



@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer>{
	
	UsuarioCliente findByUsuario(String usuario);

}
