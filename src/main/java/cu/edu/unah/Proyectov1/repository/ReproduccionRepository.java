package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.Reproduccion;
import cu.edu.unah.Proyectov1.model.ReproduccionPK;

public interface ReproduccionRepository extends JpaRepository<Reproduccion, ReproduccionPK>{

}
