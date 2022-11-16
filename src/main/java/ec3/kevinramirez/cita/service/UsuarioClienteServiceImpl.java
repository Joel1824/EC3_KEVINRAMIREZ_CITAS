package ec3.kevinramirez.cita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec3.kevinramirez.cita.model.UsuarioCliente;

import ec3.kevinramirez.cita.repository.UsuarioClienteRepository;

@Service
public class UsuarioClienteServiceImpl implements UsuarioClienteService {

	@Autowired
	private UsuarioClienteRepository repositorio;
	
	@Override
	public void guardar(UsuarioCliente usucliente) {
		repositorio.save(usucliente);

	}

	@Override
	public void actualizar(UsuarioCliente usucliente) {
		repositorio.saveAndFlush(usucliente);

	}

	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);

	}

	@Override
	public List<UsuarioCliente> listar() {
		return repositorio.findAll();
		
	}

	@Override
	public UsuarioCliente obtener(Integer id) {
		return repositorio.findById(id).orElse(null);
		
	}

}
