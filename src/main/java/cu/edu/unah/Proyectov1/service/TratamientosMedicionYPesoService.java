package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.TratamientosMedicionYPeso;
import cu.edu.unah.Proyectov1.model.TratamientosMedicionYPesoPK;
import cu.edu.unah.Proyectov1.repository.TratamientosMedicionYPesoRepository;

@Service
public class TratamientosMedicionYPesoService {

	@Autowired
	private TratamientosMedicionYPesoRepository tratamientosMedicionYPesorepository;
	
	public TratamientosMedicionYPeso save(TratamientosMedicionYPeso tratamientosMedicionYPeso) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (tratamientosMedicionYPeso.getTratamientosMedicionYPesoPK() != null && tratamientosMedicionYPesorepository.existsById(tratamientosMedicionYPeso.getTratamientosMedicionYPesoPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return tratamientosMedicionYPesorepository.save(tratamientosMedicionYPeso);
	}

	public TratamientosMedicionYPeso update(TratamientosMedicionYPeso tratamientosMedicionYPeso) {
		if (tratamientosMedicionYPeso.getTratamientosMedicionYPesoPK() != null && !tratamientosMedicionYPesorepository.existsById(tratamientosMedicionYPeso.getTratamientosMedicionYPesoPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return tratamientosMedicionYPesorepository.save(tratamientosMedicionYPeso);
	}

	public List<TratamientosMedicionYPeso> findAll() {
		return tratamientosMedicionYPesorepository.findAll();
	}

	
	
	public TratamientosMedicionYPeso findId(TratamientosMedicionYPesoPK id) {
		TratamientosMedicionYPeso univ = tratamientosMedicionYPesorepository.findById(id).get();
		return univ;

	}

	public void delete(TratamientosMedicionYPesoPK id) {
		tratamientosMedicionYPesorepository.deleteById(id);
}
}
