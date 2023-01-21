package cu.edu.unah.Proyectov1.Reproduccion.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import cu.edu.unah.Proyectov1.Animal.domain.Animal;
import cu.edu.unah.Proyectov1.Raza.domian.Raza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.unah.Proyectov1.Reproduccion.domain.Reproduccion;
import cu.edu.unah.Proyectov1.Reproduccion.domain.ReproduccionPK;
import cu.edu.unah.Proyectov1.Reproduccion.application.ReproduccionService;

@RequestMapping("/reproduccion")
@RestController
public class ReproduccionController {
	
	@Autowired
	private ReproduccionService reproduccionService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Reproduccion>> findAll() {
		try {
			return new ResponseEntity<List<Reproduccion>>(reproduccionService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reproduccion> findById(
			
			@RequestBody ReproduccionPK id) {
		try {
			return new ResponseEntity<Reproduccion>(reproduccionService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reproduccion> create(

			@RequestBody Reproduccion reproduccion) throws URISyntaxException {
		Reproduccion result = reproduccionService.save(reproduccion);

		return new ResponseEntity<Reproduccion>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Reproduccion> updateAnimal(
			
			
			@RequestBody Reproduccion reproduccion) throws URISyntaxException {
		if (reproduccion.getReproduccionPK() == null) {
			return new ResponseEntity<Reproduccion>(HttpStatus.NOT_FOUND);
		}

		try {
			Reproduccion result = reproduccionService.update(reproduccion);

			return new ResponseEntity<Reproduccion>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody ReproduccionPK id) {
		reproduccionService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}/{uf}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf) {
ReproduccionPK id = new ReproduccionPK(us,rol,uf);
System.out.println("voy a borrar"+id);
reproduccionService.delete(id);
return ResponseEntity.ok().build();
}
}

