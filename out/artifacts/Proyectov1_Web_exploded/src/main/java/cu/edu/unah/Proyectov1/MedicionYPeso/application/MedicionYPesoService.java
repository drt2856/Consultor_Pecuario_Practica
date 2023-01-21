package cu.edu.unah.Proyectov1.MedicionYPeso.application;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.MedicionYPeso.domain.MedicionYPeso;
import cu.edu.unah.Proyectov1.MedicionYPeso.domain.MedicionYPesoPK;
import cu.edu.unah.Proyectov1.MedicionYPeso.domain.MedicionYPesoRepository;

@Service
public class MedicionYPesoService {

	@Autowired
	private MedicionYPesoRepository medicionYPesorepository;
	
	public MedicionYPeso save(MedicionYPeso medicionYPeso) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (medicionYPeso.getMedicionYPesoPK()  != null && medicionYPesorepository.existsById(medicionYPeso.getMedicionYPesoPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return medicionYPesorepository.save(medicionYPeso);
	}

	public MedicionYPeso update(MedicionYPeso medicionYPeso) {
		if (medicionYPeso.getMedicionYPesoPK() != null && !medicionYPesorepository.existsById(medicionYPeso.getMedicionYPesoPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return medicionYPesorepository.save(medicionYPeso);
	}

	public List<MedicionYPeso> findAll() {
		return medicionYPesorepository.findAll();
	}

	
	
	public MedicionYPeso findId(MedicionYPesoPK id) {
		MedicionYPeso univ = medicionYPesorepository.findById(id).get();
		return univ;

	}

	public void delete(MedicionYPesoPK id) {
		medicionYPesorepository.deleteById(id);
}
}
