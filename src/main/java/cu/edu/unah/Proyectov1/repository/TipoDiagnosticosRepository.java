package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.TipoDiagnosticos;
import cu.edu.unah.Proyectov1.model.TipoDiagnosticosPK;

public interface TipoDiagnosticosRepository extends JpaRepository<TipoDiagnosticos, TipoDiagnosticosPK>{

}
