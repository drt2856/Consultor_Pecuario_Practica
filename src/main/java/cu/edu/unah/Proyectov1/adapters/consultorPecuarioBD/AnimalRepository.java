package cu.edu.unah.Proyectov1.adapters.consultorPecuarioBD;

import cu.edu.unah.Proyectov1.domain.models.Animal;
import cu.edu.unah.Proyectov1.domain.models.AnimalPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnimalRepository extends JpaRepository<Animal, AnimalPK>{

}
