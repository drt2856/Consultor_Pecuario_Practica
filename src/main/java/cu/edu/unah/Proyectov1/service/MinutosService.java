package cu.edu.unah.Proyectov1.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Area;
import cu.edu.unah.Proyectov1.model.Minutos;
import cu.edu.unah.Proyectov1.model.MinutosPK;
import cu.edu.unah.Proyectov1.repository.MinutosRepository;

@Service
public class MinutosService {

	@Autowired
	private MinutosRepository minutosrepository;
	
	public Minutos save(Minutos minutos) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (minutos.getMinutosPK() != null && minutosrepository.existsById(minutos.getMinutosPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return minutosrepository.save(minutos);
	}

	public Minutos update(Minutos minutos) {
		if (minutos.getMinutosPK()  != null && !minutosrepository.existsById(minutos.getMinutosPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return minutosrepository.save(minutos);
	}

	public List<Minutos> findAll() {
		return minutosrepository.findAll();
	}

	
	public Minutos findminutos(MinutosPK id) {
		Minutos univ = minutosrepository.findById(id).get();
		return univ;

	}
	

	

	public void delete(MinutosPK id) {
		minutosrepository.deleteById(id);
}
}
