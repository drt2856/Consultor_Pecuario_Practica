package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.Especieanimal;
import cu.edu.unah.Proyectov1.model.EspecieanimalPK;

public interface EspecieanimalRepository extends JpaRepository<Especieanimal, EspecieanimalPK>{

}
