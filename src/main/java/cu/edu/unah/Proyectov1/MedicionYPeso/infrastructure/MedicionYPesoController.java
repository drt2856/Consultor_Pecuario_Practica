package cu.edu.unah.Proyectov1.MedicionYPeso.infrastructure;

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

import cu.edu.unah.Proyectov1.MedicionYPeso.domain.MedicionYPeso;
import cu.edu.unah.Proyectov1.MedicionYPeso.domain.MedicionYPesoPK;
import cu.edu.unah.Proyectov1.MedicionYPeso.application.MedicionYPesoService;

@RequestMapping("/medicionYPeso")
@RestController
public class MedicionYPesoController {
	
	@Autowired
	private MedicionYPesoService medicionYPesoService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<MedicionYPeso>> findAll() {
		try {
			return new ResponseEntity<List<MedicionYPeso>>(medicionYPesoService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MedicionYPeso> findById(
			
			@RequestBody MedicionYPesoPK id) {
		try {
			return new ResponseEntity<MedicionYPeso>(medicionYPesoService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MedicionYPeso> create(
			
			@RequestBody MedicionYPeso medicionYPeso) throws URISyntaxException {
		MedicionYPeso result = medicionYPesoService.save(medicionYPeso);


		return new ResponseEntity<MedicionYPeso>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MedicionYPeso> updateMedicionYPeso(
			
			
			@RequestBody MedicionYPeso medicionYPeso) throws URISyntaxException {
		if (medicionYPeso.getMedicionYPesoPK() == null) {
			return new ResponseEntity<MedicionYPeso>(HttpStatus.NOT_FOUND);
		}

		try {
			MedicionYPeso result = medicionYPesoService.update(medicionYPeso);

			return new ResponseEntity<MedicionYPeso>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody MedicionYPesoPK id) {
		medicionYPesoService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}/{uf}/{paf}/{sof}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf,@PathVariable int paf,@PathVariable int sof) {
MedicionYPesoPK id = new MedicionYPesoPK(us,rol,uf,paf,sof);
System.out.println("voy a borrar"+id);
medicionYPesoService.delete(id);
return ResponseEntity.ok().build();
}}

