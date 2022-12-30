package cu.edu.unah.Proyectov1.domain.services;

import cu.edu.unah.Proyectov1.model.Proposito;
import cu.edu.unah.Proyectov1.repository.PropositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PropositoService {

	@Autowired
	private PropositoRepository propositorepository;
	
	public Proposito save(Proposito proposito) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (proposito.getIdProposito() != 0 && propositorepository.existsById(proposito.getIdProposito())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return propositorepository.save(proposito);
	}

	public Proposito update(Proposito proposito) {
		if (proposito.getIdProposito()!= 0 && !propositorepository.existsById(proposito.getIdProposito())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return propositorepository.save(proposito);
	}

	public List<Proposito> findAll() {
		return propositorepository.findAll();
	}

	
	
	public Proposito findId(int id) {
		Proposito univ = propositorepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		propositorepository.deleteById(id);
}
}
