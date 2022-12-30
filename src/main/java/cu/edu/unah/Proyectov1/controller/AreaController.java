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

import cu.edu.unah.Proyectov1.model.Area;
import cu.edu.unah.Proyectov1.service.AreaService;

@RequestMapping("/Area")
@RestController
public class AreaController {
	
	@Autowired
	private AreaService Urep;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Area>> findAll() {
		try {
			return new ResponseEntity<List<Area>>(Urep.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Area> findById(
			
						@PathVariable int id) {
		try {
			return new ResponseEntity<Area>(Urep.findarea(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Area> create(@RequestBody Area univ) throws URISyntaxException {
		Area x = univ;
		Area result = Urep.save(univ);

		return ResponseEntity.created(new URI("/Area/create/" + result.getIdArea())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Area> updateArea(
			
			
			@RequestBody Area univ) throws URISyntaxException {
		if (univ.getIdArea() == 0) {
			return new ResponseEntity<Area>(HttpStatus.NOT_FOUND);
		}

		try {
			Area result = Urep.update(univ);

			return ResponseEntity.created(new URI("/Area/updated/" + result.getIdArea())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@PathVariable int id) {
		Urep.delete(id);

		return ResponseEntity.ok().build();
	}

}
