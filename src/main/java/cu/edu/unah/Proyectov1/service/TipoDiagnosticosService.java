package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.TipoDiagnosticos;
import cu.edu.unah.Proyectov1.model.TipoDiagnosticosPK;
import cu.edu.unah.Proyectov1.repository.TipoDiagnosticosRepository;

@Service
public class TipoDiagnosticosService {

	@Autowired
	private TipoDiagnosticosRepository tipoDiagnosticosrepository;
	
	public TipoDiagnosticos save(TipoDiagnosticos tipoDiagnosticos) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (tipoDiagnosticos.getTipoDiagnosticosPK() != null && tipoDiagnosticosrepository.existsById(tipoDiagnosticos.getTipoDiagnosticosPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return tipoDiagnosticosrepository.save(tipoDiagnosticos);
	}

	public TipoDiagnosticos update(TipoDiagnosticos tipoDiagnosticos) {
		if (tipoDiagnosticos.getTipoDiagnosticosPK() != null && !tipoDiagnosticosrepository.existsById(tipoDiagnosticos.getTipoDiagnosticosPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return tipoDiagnosticosrepository.save(tipoDiagnosticos);
	}

	public List<TipoDiagnosticos> findAll() {
		return tipoDiagnosticosrepository.findAll();
	}

	
	
	public TipoDiagnosticos findId(TipoDiagnosticosPK id) {
		TipoDiagnosticos univ = tipoDiagnosticosrepository.findById(id).get();
		return univ;

	}

	public void delete(TipoDiagnosticosPK id) {
		tipoDiagnosticosrepository.deleteById(id);
}
}
