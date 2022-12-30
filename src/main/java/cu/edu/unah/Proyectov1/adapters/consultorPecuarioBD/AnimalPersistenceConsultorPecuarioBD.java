package cu.edu.unah.Proyectov1.adapters.consultorPecuarioBD;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import cu.edu.unah.Proyectov1.domain.out_ports.AnimalPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cu.edu.unah.Proyectov1.domain.models.Animal;
import cu.edu.unah.Proyectov1.domain.models.AnimalPK;
import cu.edu.unah.Proyectov1.domain.services.AnimalServiceImpl;


@Repository("animalPersistence")
public class AnimalPersistenceConsultorPecuarioBD implements AnimalPersistence {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalPersistenceConsultorPecuarioBD(AnimalRepository animalRepository) {
        this.animalRepository =animalRepository;
    }


    @GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Animal>> findAll() {
        try {
            return new ResponseEntity<List<Animal>>(animalRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Animal> findById(

            @PathVariable AnimalPK id) {
        try {
            return new ResponseEntity<Animal>(animalRepository.findId (id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Animal> create(

            @RequestBody Animal univ) throws URISyntaxException {
        Animal result = animalRepository.save(univ);

        return ResponseEntity.created(new URI("/Animal/create/" + result.getAnimalPK())).body(result);
    }

    @PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Animal> updateAnimal(


            @RequestBody Animal univ) throws URISyntaxException {
        if (univ.getAnimalPK() == null) {
            return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
        }

        try {
            Animal result = animalRepository.update(univ);

            return ResponseEntity.created(new URI("/Animal/updated/" + result.getAnimalPK())).body(result);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> delete(

            @RequestBody AnimalPK id) {
        animalService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping(path = { "/delete/{us}/{rol}/{uf}/{paf}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf,@PathVariable int paf) {
        AnimalPK id = new AnimalPK(us,rol,uf,paf);
        System.out.println("voy a borrar"+id);
        animalService.delete(id);
        return ResponseEntity.ok().build();
    }}
