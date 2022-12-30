package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.domain.in_ports.AnimalService;
import cu.edu.unah.Proyectov1.domain.out_ports.AnimalPersistence;
import cu.edu.unah.Proyectov1.domain.models.Animal;
import cu.edu.unah.Proyectov1.domain.models.AnimalPK;
import cu.edu.unah.Proyectov1.adapters.consultorPecuarioBD.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

	private AnimalPersistence animalPersistence;

	@Autowired
	public AnimalServiceImpl(AnimalPersistence animalPersistence) {
		this.animalPersistence = animalPersistence;
	}




	public Animal save(Animal animal) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (animal.getAnimalPK() != null && animalPersistence.existsById(animal.getAnimalPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return animalPersistence.save(animal);
	}

	public Animal update(Animal animal) {
		if (animal.getAnimalPK() != null && !animalPersistence.existsById(animal.getAnimalPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return animalPersistence.save(animal);
	}

	public List<Animal> findAll() {
		return animalPersistence.findAll();
	}



	public Animal findId(AnimalPK id) {
		Animal univ = animalPersistence.findId(id).get();
		return univ;

	}

	public void delete(AnimalPK id) {
		animalPersistence.deleteById(AnimalPK id);
}
}
