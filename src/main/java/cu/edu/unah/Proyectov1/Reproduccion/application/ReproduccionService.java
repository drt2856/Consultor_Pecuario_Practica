package cu.edu.unah.Proyectov1.Reproduccion.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;


import cu.edu.unah.Proyectov1.Raza.domian.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.Reproduccion.domain.Reproduccion;
import cu.edu.unah.Proyectov1.Reproduccion.domain.ReproduccionPK;
import cu.edu.unah.Proyectov1.Reproduccion.domain.ReproduccionRepository;

@Service
public class ReproduccionService {

	@Autowired
	private ReproduccionRepository reproduccionrepository;

	public Reproduccion save(Reproduccion reproduccion) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if(reproduccion.getReproduccionPK()!= null) {
			boolean existe = reproduccionrepository.existsById(reproduccion.getReproduccionPK());
			if (existe) {
				throw new EntityExistsException("There is already existing entity with such ID in the database.");
			}
		}

		return reproduccionrepository.save(reproduccion);
	}


	public Reproduccion update(Reproduccion reproduccion) {
		if (reproduccion.getReproduccionPK() != null && !reproduccionrepository.existsById(reproduccion.getReproduccionPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return reproduccionrepository.save(reproduccion);
	}

	public List<Reproduccion> findAll() {
		return reproduccionrepository.findAll();
	}

	
	
	public Reproduccion findId( ReproduccionPK id) {
		Reproduccion reproduccion = reproduccionrepository.findById(id).get();
		return reproduccion;

	}

	public void delete(ReproduccionPK id) {
		reproduccionrepository.deleteById(id);
}

}
