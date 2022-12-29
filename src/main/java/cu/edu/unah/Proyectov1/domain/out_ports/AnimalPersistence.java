package cu.edu.unah.Proyectov1.domain.out_ports;

import cu.edu.unah.Proyectov1.domain.models.Animal;
import cu.edu.unah.Proyectov1.domain.models.AnimalPK;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface AnimalPersistence {

  abstract Animal save(Animal animal);

   Animal update(Animal animal);

    ResponseEntity<List<Animal>> findAll() ;

    Animal findId(AnimalPK id);

    void delete(AnimalPK id);
}





