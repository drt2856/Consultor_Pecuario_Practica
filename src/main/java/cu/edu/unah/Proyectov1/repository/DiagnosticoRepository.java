package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.Diagnostico;
import cu.edu.unah.Proyectov1.model.DiagnosticoPK;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, DiagnosticoPK>{

}
