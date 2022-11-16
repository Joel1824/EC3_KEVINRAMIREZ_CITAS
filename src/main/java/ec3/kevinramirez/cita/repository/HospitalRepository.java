package ec3.kevinramirez.cita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec3.kevinramirez.cita.model.Hospital;



@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
