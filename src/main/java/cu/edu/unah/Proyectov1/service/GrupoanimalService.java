package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Grupoanimal;
import cu.edu.unah.Proyectov1.repository.GrupoanimalRepository;

@Service
public class GrupoanimalService {

	@Autowired
	private GrupoanimalRepository grupoanimalrepository;
	
	public Grupoanimal save(Grupoanimal grupoanimal) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (grupoanimal.getIdGrupoAnimal() != 0 && grupoanimalrepository.existsById(grupoanimal.getIdGrupoAnimal())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return grupoanimalrepository.save(grupoanimal);
	}

	public Grupoanimal update(Grupoanimal grupoanimal) {
		if (grupoanimal.getIdGrupoAnimal() != 0 && !grupoanimalrepository.existsById(grupoanimal.getIdGrupoAnimal())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return grupoanimalrepository.save(grupoanimal);
	}

	public List<Grupoanimal> findAll() {
		return grupoanimalrepository.findAll();
	}

	
	
	public Grupoanimal findgrupoanimal(int id) {
		Grupoanimal univ = grupoanimalrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		grupoanimalrepository.deleteById(id);
}
}
