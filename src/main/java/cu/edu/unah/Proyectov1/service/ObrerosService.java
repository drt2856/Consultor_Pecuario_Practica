package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Obreros;

import cu.edu.unah.Proyectov1.repository.ObrerosRepository;

@Service
public class ObrerosService {

	@Autowired
	private ObrerosRepository obrerosrepository;
	
	public Obreros save(Obreros obreros) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (obreros.getIdObrero() != null && obrerosrepository.existsById(obreros.getIdObrero())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return obrerosrepository.save(obreros);
	}

	public Obreros update(Obreros obreros) {
		if (obreros.getIdObrero()  != null && !obrerosrepository.existsById(obreros.getIdObrero())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return obrerosrepository.save(obreros);
	}

	public List<Obreros> findAll() {
		return obrerosrepository.findAll();
	}

	
	
	public Obreros findobreros(int id) {
		Obreros univ = obrerosrepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		obrerosrepository.deleteById(id);
}
}
