package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Reproduccion;
import cu.edu.unah.Proyectov1.model.ReproduccionPK;
import cu.edu.unah.Proyectov1.repository.ReproduccionRepository;

@Service
public class ReproduccionService {

	@Autowired
	private ReproduccionRepository Reproduciconrepository;
	
	public Reproduccion save(Reproduccion Reproduccion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (Reproduccion.getReproduccionPK() != null && Reproduciconrepository.existsById(Reproduccion.getReproduccionPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return Reproduciconrepository.save(Reproduccion);
	}

	public Reproduccion update(Reproduccion Reproduccion) {
		if (Reproduccion.getReproduccionPK() != null && !Reproduciconrepository.existsById(Reproduccion.getReproduccionPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return Reproduciconrepository.save(Reproduccion);
	}

	public List<Reproduccion> findAll() {
		return Reproduciconrepository.findAll();
	}

	
	
	public Reproduccion findReproducicon( ReproduccionPK id) {
		Reproduccion univ = Reproduciconrepository.findById(id).get();
		return univ;

	}

	public void delete(ReproduccionPK id) {
		Reproduciconrepository.deleteById(id);
}

}
