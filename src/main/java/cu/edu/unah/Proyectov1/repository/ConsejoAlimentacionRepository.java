package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.ConsejoAlimentacion;
import cu.edu.unah.Proyectov1.model.ConsejoAlimentacionPK;

public interface ConsejoAlimentacionRepository extends JpaRepository<ConsejoAlimentacion,ConsejoAlimentacionPK>{

}
