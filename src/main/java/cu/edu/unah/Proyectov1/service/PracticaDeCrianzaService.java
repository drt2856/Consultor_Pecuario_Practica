package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.PracticaDeCrianza;
import cu.edu.unah.Proyectov1.model.PracticaDeCrianzaPK;
import cu.edu.unah.Proyectov1.repository.PracticaDeCrianzaRepository;

@Service
public class PracticaDeCrianzaService {

	@Autowired
	private PracticaDeCrianzaRepository practicaDeCrianzarepository;
	
	public PracticaDeCrianza save(PracticaDeCrianza practicaDeCrianza) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (practicaDeCrianza.getPracticaDeCrianzaPK() != null && practicaDeCrianzarepository.existsById(practicaDeCrianza.getPracticaDeCrianzaPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return practicaDeCrianzarepository.save(practicaDeCrianza);
	}

	public PracticaDeCrianza update(PracticaDeCrianza practicaDeCrianza) {
		if (practicaDeCrianza.getPracticaDeCrianzaPK() != null && !practicaDeCrianzarepository.existsById(practicaDeCrianza.getPracticaDeCrianzaPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return practicaDeCrianzarepository.save(practicaDeCrianza);
	}

	public List<PracticaDeCrianza> findAll() {
		return practicaDeCrianzarepository.findAll();
	}

	
	
	public PracticaDeCrianza findId(PracticaDeCrianzaPK id) {
		PracticaDeCrianza univ = practicaDeCrianzarepository.findById(id).get();
		return univ;

	}

	public void delete(PracticaDeCrianzaPK id) {
		practicaDeCrianzarepository.deleteById(id);
}
}
