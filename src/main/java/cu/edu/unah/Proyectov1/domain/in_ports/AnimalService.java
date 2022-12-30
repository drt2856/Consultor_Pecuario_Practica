package cu.edu.unah.Proyectov1.domain.in_ports;

import cu.edu.unah.Proyectov1.domain.models.Animal;
import cu.edu.unah.Proyectov1.domain.models.AnimalPK;
import org.springframework.http.ResponseEntity;


import java.math.BigDecimal;
import java.util.List;


public interface AnimalService {

    Animal  save(Animal animal);

    Animal update(Animal animal);

    ResponseEntity<List<Animal>> findAll() ;

    Animal findId(AnimalPK id);

    void delete(AnimalPK id);
}
