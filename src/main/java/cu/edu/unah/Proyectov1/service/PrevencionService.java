package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Prevencion;
import cu.edu.unah.Proyectov1.repository.PrevencionRepository;

@Service
public class PrevencionService {

	@Autowired
	private PrevencionRepository prevencionrepository;
	
	public Prevencion save(Prevencion prevencion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (prevencion.getIdPrevencion() != 0 && prevencionrepository.existsById(prevencion.getIdPrevencion())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return prevencionrepository.save(prevencion);
	}

	public Prevencion update(Prevencion prevencion) {
		if (prevencion.getIdPrevencion()  != 0 && !prevencionrepository.existsById(prevencion.getIdPrevencion())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return prevencionrepository.save(prevencion);
	}

	public List<Prevencion> findAll() {
		return prevencionrepository.findAll();
	}

	
	
	public Prevencion findId(int id) {
		Prevencion univ = prevencionrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		prevencionrepository.deleteById(id);
}
}
