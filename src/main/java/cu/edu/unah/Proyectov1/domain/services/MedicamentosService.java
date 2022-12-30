package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.model.Medicamentos;
import cu.edu.unah.Proyectov1.repository.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MedicamentosService {

	@Autowired
	private MedicamentosRepository medicamentosrepository;
	
	public Medicamentos save(Medicamentos medicamentos) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (medicamentos.getIdMedicamentos() != 0 && medicamentosrepository.existsById(medicamentos.getIdMedicamentos())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return medicamentosrepository.save(medicamentos);
	}

	public Medicamentos update(Medicamentos medicamentos) {
		if (medicamentos.getIdMedicamentos() != 0 && !medicamentosrepository.existsById(medicamentos.getIdMedicamentos())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return medicamentosrepository.save(medicamentos);
	}

	public List<Medicamentos> findAll() {
		return medicamentosrepository.findAll();
	}

	
	
	public Medicamentos findId(int id) {
		Medicamentos univ = medicamentosrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		medicamentosrepository.deleteById(id);
}
}
