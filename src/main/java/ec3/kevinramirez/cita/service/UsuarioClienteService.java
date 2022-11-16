package ec3.kevinramirez.cita.service;

import java.util.List;

import ec3.kevinramirez.cita.model.UsuarioCliente;



public interface UsuarioClienteService {

	void guardar(UsuarioCliente usucliente);
	void actualizar(UsuarioCliente usucliente);
	void eliminar(Integer id);
	List<UsuarioCliente> listar();
	UsuarioCliente obtener(Integer id);
}
