package ec3.kevinramirez.cita.service;

import java.util.List;

import ec3.kevinramirez.cita.model.Hospital;



public interface HospitalService {

	void guardar(Hospital hospital);
	void actualizar(Hospital hospital);
	void eliminar(Integer id);
	List<Hospital> listar();
	Hospital obtener(Integer id);
}
