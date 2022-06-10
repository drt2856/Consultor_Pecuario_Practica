package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.Alimentacion;
import cu.edu.unah.Proyectov1.model.AlimentacionPK;

public interface AlimentacionRepository extends JpaRepository<Alimentacion, AlimentacionPK>{

}
