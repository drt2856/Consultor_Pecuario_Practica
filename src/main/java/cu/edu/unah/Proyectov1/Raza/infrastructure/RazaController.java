package cu.edu.unah.Proyectov1.Raza.infrastructure;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import cu.edu.unah.Proyectov1.EspecieAnimal.domian.Especieanimal;
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

import cu.edu.unah.Proyectov1.Raza.domian.Raza;
import cu.edu.unah.Proyectov1.Raza.domian.RazaPK;
import cu.edu.unah.Proyectov1.Raza.application.RazaService;

@RequestMapping("/raza")
@RestController
public class RazaController {
	
	@Autowired
	private RazaService razaService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Raza>> findAll() {
		try {
			return new ResponseEntity<List<Raza>>(razaService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Raza> findById(
			
			@RequestBody RazaPK id) {
		try {
			return new ResponseEntity<Raza>(razaService.findId(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Raza> create(
			
			@RequestBody Raza raza) throws URISyntaxException {
		Raza result = razaService.save(raza);

		return new ResponseEntity<Raza>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Raza> updateRaza(
			
			
			@RequestBody Raza raza) throws URISyntaxException {
		if (raza.getRazaPK() == null) {
			return new ResponseEntity<Raza>(HttpStatus.NOT_FOUND);
		}

		try {
			Raza result = razaService.update(raza);

			return new ResponseEntity<Raza>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody RazaPK id) {
		razaService.delete(id);

		return ResponseEntity.ok().build();
	}


@PostMapping(path = { "/delete/{us}/{rol}/{uf}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf) {
	RazaPK id = new RazaPK(us,rol,uf);
	System.out.println("voy a borrar"+id);
	razaService.delete(id);
	return ResponseEntity.ok().build();
}}
