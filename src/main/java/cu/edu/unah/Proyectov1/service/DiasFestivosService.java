package cu.edu.unah.Proyectov1.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.DiasFestivos;
import cu.edu.unah.Proyectov1.model.Minutos;
import cu.edu.unah.Proyectov1.model.MinutosPK;
import cu.edu.unah.Proyectov1.repository.DiasFestivosRepository;

@Service
public class DiasFestivosService {

	@Autowired
	private DiasFestivosRepository diasFestivosrepository;
	
	public DiasFestivos save(DiasFestivos diasFestivos) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (diasFestivos.getFecha() != null && diasFestivosrepository.existsById(diasFestivos.getFecha())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return diasFestivosrepository.save(diasFestivos);
	}

	public DiasFestivos update(DiasFestivos diasFestivos) {
		if (diasFestivos.getFecha()  != null && !diasFestivosrepository.existsById(diasFestivos.getFecha())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return diasFestivosrepository.save(diasFestivos);
	}

	public List<DiasFestivos> findAll() {
		return diasFestivosrepository.findAll();
	}
	
	
	public DiasFestivos finddiasfestivos(Date id) {
		DiasFestivos univ = diasFestivosrepository.findById(id).get();
		return univ;

	}
	
	
	

	public void delete(Date id) {
		diasFestivosrepository.deleteById(id);
}
}
