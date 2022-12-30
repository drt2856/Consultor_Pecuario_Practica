package cu.edu.unah.Proyectov1.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
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

import cu.edu.unah.Proyectov1.model.DiasFestivos;
import cu.edu.unah.Proyectov1.service.DiasFestivosService;

@RequestMapping("/DiasFestivos")
@RestController
public class DiasFestivosController {
	
	@Autowired
	private DiasFestivosService diasFestivos;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<DiasFestivos>> findAll() {
		try {
			return new ResponseEntity<List<DiasFestivos>>(diasFestivos.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find/{id}" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DiasFestivos> findById(
			
						@PathVariable Date id) {
		try {
			return new ResponseEntity<DiasFestivos>(diasFestivos.finddiasfestivos(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DiasFestivos> create(
			
			@RequestBody DiasFestivos univ) throws URISyntaxException {
		DiasFestivos result = diasFestivos.save(univ);

		return ResponseEntity.created(new URI("/DiasFestivos/create/" + result.getFecha())).body(result);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DiasFestivos> updateDiasFestivos(
			
			
			@RequestBody DiasFestivos univ) throws URISyntaxException {
		if (univ.getFecha() == null) {
			return new ResponseEntity<DiasFestivos>(HttpStatus.NOT_FOUND);
		}

		try {
			DiasFestivos result = diasFestivos.update(univ);

			return ResponseEntity.created(new URI("/DiasFestivos/updated/" + result.getFecha( ))).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@PathVariable Date id) {
		diasFestivos.delete(id);

		return ResponseEntity.ok().build();
	}

}
