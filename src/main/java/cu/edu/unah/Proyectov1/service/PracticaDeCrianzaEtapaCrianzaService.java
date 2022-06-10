package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.PracticaDeCrianzaEtapaCrianza;
import cu.edu.unah.Proyectov1.model.PracticaDeCrianzaEtapaCrianzaPK;
import cu.edu.unah.Proyectov1.repository.PracticaDeCrianzaEtapaCrianzaRepository;

@Service
public class PracticaDeCrianzaEtapaCrianzaService {

	@Autowired
	private PracticaDeCrianzaEtapaCrianzaRepository practicaDeCrianzaEtapaCrianzarepository;
	
	public PracticaDeCrianzaEtapaCrianza save(PracticaDeCrianzaEtapaCrianza practicaDeCrianzaEtapaCrianza) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (practicaDeCrianzaEtapaCrianza.getPracticaDeCrianzaEtapaCrianzaPK() != null && practicaDeCrianzaEtapaCrianzarepository.existsById(practicaDeCrianzaEtapaCrianza.getPracticaDeCrianzaEtapaCrianzaPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return practicaDeCrianzaEtapaCrianzarepository.save(practicaDeCrianzaEtapaCrianza);
	}

	public PracticaDeCrianzaEtapaCrianza update(PracticaDeCrianzaEtapaCrianza practicaDeCrianzaEtapaCrianza) {
		if (practicaDeCrianzaEtapaCrianza.getPracticaDeCrianzaEtapaCrianzaPK() != null && !practicaDeCrianzaEtapaCrianzarepository.existsById(practicaDeCrianzaEtapaCrianza.getPracticaDeCrianzaEtapaCrianzaPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return practicaDeCrianzaEtapaCrianzarepository.save(practicaDeCrianzaEtapaCrianza);
	}

	public List<PracticaDeCrianzaEtapaCrianza> findAll() {
		return practicaDeCrianzaEtapaCrianzarepository.findAll();
	}

	
	
	public PracticaDeCrianzaEtapaCrianza findId(PracticaDeCrianzaEtapaCrianzaPK id) {
		PracticaDeCrianzaEtapaCrianza univ = practicaDeCrianzaEtapaCrianzarepository.findById(id).get();
		return univ;

	}

	public void delete(PracticaDeCrianzaEtapaCrianzaPK id) {
		practicaDeCrianzaEtapaCrianzarepository.deleteById(id);
}
}
