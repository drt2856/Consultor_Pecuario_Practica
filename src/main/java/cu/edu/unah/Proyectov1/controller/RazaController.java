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

import cu.edu.unah.Proyectov1.model.Raza;
import cu.edu.unah.Proyectov1.model.RazaPK;
import cu.edu.unah.Proyectov1.service.RazaService;

@RequestMapping("/Raza")
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
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Raza> findById(
			
			@RequestBody RazaPK id) {
		try {
			return new ResponseEntity<Raza>(razaService.findraza(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Raza> create(
			
			@RequestBody Raza univ) throws URISyntaxException {
		Raza result = razaService.save(univ);

		return ResponseEntity.created(new URI("/Raza/create/" + result.getRazaPK())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Raza> updateRaza(
			
			
			@RequestBody Raza univ) throws URISyntaxException {
		if (univ.getRazaPK() == null) {
			return new ResponseEntity<Raza>(HttpStatus.NOT_FOUND);
		}

		try {
			Raza result = razaService.update(univ);

			return ResponseEntity.created(new URI("/Raza/updated/" + result.getRazaPK())).body(result);
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
