package cu.edu.unah.Proyectov1.Raza.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.Raza.domian.Raza;
import cu.edu.unah.Proyectov1.Raza.domian.RazaPK;
import cu.edu.unah.Proyectov1.Raza.domian.RazaRepository;

@Service
public class RazaService {

	@Autowired
	private RazaRepository razarepository;
	
	public Raza save(Raza raza) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if(raza.getRazaPK()!= null) {
			boolean existe = razarepository.existsById(raza.getRazaPK());
		if (existe) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		}

		return razarepository.save(raza);
	}

	public Raza update(Raza raza) {
		if (raza.getRazaPK() != null && !razarepository.existsById(raza.getRazaPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return razarepository.save(raza);
	}

	public List<Raza> findAll() {
		return razarepository.findAll();
	}

	
	
	public Raza findId(RazaPK id) {
		Raza univ = razarepository.findById(id).get();
		return univ;

	}

	public void delete(RazaPK id) {
		razarepository.deleteById(id);
}
}
