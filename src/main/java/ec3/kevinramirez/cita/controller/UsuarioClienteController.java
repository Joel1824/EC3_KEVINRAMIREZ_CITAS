package ec3.kevinramirez.cita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec3.kevinramirez.cita.model.UsuarioCliente;
import ec3.kevinramirez.cita.service.UsuarioClienteService;



@RestController
@RequestMapping("/usucliente/v1")
public class UsuarioClienteController {
	
	@Autowired
	private UsuarioClienteService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioCliente>> listar(){
		return new ResponseEntity<List<UsuarioCliente>>(service.listar(), HttpStatus.OK) ;
	}
	
	@RequestMapping(path="/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UsuarioCliente usucliente ){
		service.guardar(usucliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioCliente> obtenerPorId(@PathVariable Integer id){
		
		UsuarioCliente usucliente = service.obtener(id);
		
		if( usucliente != null) {
			return new ResponseEntity<UsuarioCliente>(usucliente, HttpStatus.OK);
		}else {
			return new ResponseEntity<UsuarioCliente>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UsuarioCliente usucliente){
		
		UsuarioCliente p = service.obtener(usucliente.getIdUsuario());
		
		if( p != null) {
			service.actualizar(usucliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		UsuarioCliente usucliente = service.obtener(id);

		if(usucliente != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

}
