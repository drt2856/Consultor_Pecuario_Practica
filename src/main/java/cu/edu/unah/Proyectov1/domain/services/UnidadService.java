package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.model.Unidad;
import cu.edu.unah.Proyectov1.model.UnidadPK;
import cu.edu.unah.Proyectov1.repository.UnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UnidadService {

	@Autowired
	private UnidadRepository unidadrepository;
	
	public Unidad save(Unidad unidad) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (unidad.getUnidadPK() != null && unidadrepository.existsById(unidad.getUnidadPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return unidadrepository.save(unidad);
	}

	public Unidad update(Unidad unidad) {
		if (unidad.getUnidadPK() != null && !unidadrepository.existsById(unidad.getUnidadPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return unidadrepository.save(unidad);
	}

	public List<Unidad> findAll() {
		return unidadrepository.findAll();
	}

	
	
	public Unidad findId(UnidadPK id) {
		Unidad univ = unidadrepository.findById(id).get();
		return univ;

	}

	public void delete(UnidadPK id) {
		unidadrepository.deleteById(id);
}
}
