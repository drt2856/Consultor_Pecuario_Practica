package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.model.Enfermedades;
import cu.edu.unah.Proyectov1.repository.EnfermedadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EnfermedadesService {

	@Autowired
	private EnfermedadesRepository enfermedadesrepository;
	
	public Enfermedades save(Enfermedades enfermedades) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (enfermedades.getIdEnfermedades() != 0 && enfermedadesrepository.existsById(enfermedades.getIdEnfermedades())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return enfermedadesrepository.save(enfermedades);
	}

	public Enfermedades update(Enfermedades enfermedades) {
		if (enfermedades.getIdEnfermedades() != 0 && !enfermedadesrepository.existsById(enfermedades.getIdEnfermedades())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return enfermedadesrepository.save(enfermedades);
	}

	public List<Enfermedades> findAll() {
		return enfermedadesrepository.findAll();
	}

	
	
	public Enfermedades findId(int id) {
		Enfermedades univ = enfermedadesrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		enfermedadesrepository.deleteById(id);
}
}
