package cu.edu.unah.Proyectov1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.Animal;
import cu.edu.unah.Proyectov1.model.AnimalPK;


public interface AnimalRepository extends JpaRepository<Animal, AnimalPK>{

}
