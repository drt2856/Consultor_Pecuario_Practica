package cu.edu.unah.Proyectov1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

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

import cu.edu.unah.Proyectov1.model.Minutos;
import cu.edu.unah.Proyectov1.model.MinutosPK;
import cu.edu.unah.Proyectov1.service.MinutosService;

@RequestMapping("/Minutos")
@RestController
public class MinutosController {
	
	@Autowired
	private MinutosService minutosService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Minutos>> findAll() {
		try {
			return new ResponseEntity<List<Minutos>>(minutosService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Minutos> findById(
			
						@RequestBody MinutosPK id) {
		try {
			return new ResponseEntity<Minutos>(minutosService.findminutos(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Minutos> create(
			
			@RequestBody Minutos univ) throws URISyntaxException {
		Minutos result = minutosService.save(univ);

		return ResponseEntity.created(new URI("/Minutos/create/" + result.getMinutosPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Minutos> updateMinutos(
			
			
			@RequestBody Minutos univ) throws URISyntaxException {
		if (univ.getMinutosPK() == null) {
			return new ResponseEntity<Minutos>(HttpStatus.NOT_FOUND);
		}

		try {
			Minutos result = minutosService.update(univ);

			return ResponseEntity.created(new URI("/Minutos/updated/" + result.getMinutosPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody MinutosPK id) {
		minutosService.delete(id);

		return ResponseEntity.ok().build();
	}

}
