package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Tratamientos;
import cu.edu.unah.Proyectov1.repository.TratamientosRepository;

@Service
public class TratamientosService {

	@Autowired
	private TratamientosRepository tratamientosrepository;
	
	public Tratamientos save(Tratamientos tratamientos) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (tratamientos.getIdTratamiento() != 0 && tratamientosrepository.existsById(tratamientos.getIdTratamiento())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return tratamientosrepository.save(tratamientos);
	}

	public Tratamientos update(Tratamientos tratamientos) {
		if (tratamientos.getIdTratamiento()!= 0 && !tratamientosrepository.existsById(tratamientos.getIdTratamiento())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return tratamientosrepository.save(tratamientos);
	}

	public List<Tratamientos> findAll() {
		return tratamientosrepository.findAll();
	}

	
	
	public Tratamientos findId(int id) {
		Tratamientos univ = tratamientosrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		tratamientosrepository.deleteById(id);
}
}
