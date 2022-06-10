package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Diagnostico;
import cu.edu.unah.Proyectov1.model.DiagnosticoPK;
import cu.edu.unah.Proyectov1.repository.DiagnosticoRepository;

@Service
public class DiagnosticoService {

	@Autowired
	private DiagnosticoRepository diagnosticorepository;
	
	public Diagnostico save(Diagnostico diagnostico) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (diagnostico.getDiagnosticoPK() != null && diagnosticorepository.existsById(diagnostico.getDiagnosticoPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return diagnosticorepository.save(diagnostico);
	}

	public Diagnostico update(Diagnostico diagnostico) {
		if (diagnostico.getDiagnosticoPK() != null && !diagnosticorepository.existsById(diagnostico.getDiagnosticoPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return diagnosticorepository.save(diagnostico);
	}

	public List<Diagnostico> findAll() {
		return diagnosticorepository.findAll();
	}

	
	
	public Diagnostico findId(DiagnosticoPK id) {
		Diagnostico univ = diagnosticorepository.findById(id).get();
		return univ;

	}

	public void delete(DiagnosticoPK id) {
		diagnosticorepository.deleteById(id);
}
}
