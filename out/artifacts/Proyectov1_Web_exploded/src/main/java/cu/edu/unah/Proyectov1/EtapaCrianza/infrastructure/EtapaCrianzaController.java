package cu.edu.unah.Proyectov1.EtapaCrianza.infrastructure;

import cu.edu.unah.Proyectov1.EtapaCrianza.application.EtapaCrianzaService;
import cu.edu.unah.Proyectov1.EtapaCrianza.domain.EtapaCrianza;
import cu.edu.unah.Proyectov1.EtapaCrianza.domain.EtapaCrianzaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/etapaCrianza")
@RestController
public class EtapaCrianzaController {
	
	@Autowired
	private EtapaCrianzaService etapaCrianzaService;
	
	@GetMapping(path= {"/findAll"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<EtapaCrianza>> findAll() {
		try {
			return new ResponseEntity<List<EtapaCrianza>>(etapaCrianzaService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/find" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EtapaCrianza> findById(
			
			@RequestBody EtapaCrianzaPK id) {
		try {
			return new ResponseEntity<EtapaCrianza>(etapaCrianzaService.findId (id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(path = { "/create" },produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EtapaCrianza> create(
			
			@RequestBody EtapaCrianza etapaCrianza) throws URISyntaxException {
		EtapaCrianza result = etapaCrianzaService.save(etapaCrianza);


		return new ResponseEntity<EtapaCrianza>(result,HttpStatus.CREATED);
	}
	
	@PutMapping(path = {"/update"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EtapaCrianza> updateEstapaCrianza(
			
			
			@RequestBody EtapaCrianza etapaCrianza) throws URISyntaxException {
		if (etapaCrianza.getEtapaCrianzaPK() == null) {
			return new ResponseEntity<EtapaCrianza>(HttpStatus.NOT_FOUND);
		}

		try {
			EtapaCrianza result = etapaCrianzaService.update(etapaCrianza);

			return new ResponseEntity<EtapaCrianza>(result,HttpStatus.CREATED);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(
			
			@RequestBody EtapaCrianzaPK id) {
		etapaCrianzaService.delete(id);

		return ResponseEntity.ok().build();
	}

@PostMapping(path = { "/delete/{us}/{rol}/{uf}/{paf}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public ResponseEntity<Void> delete(@PathVariable int us,@PathVariable int rol,@PathVariable int uf,@PathVariable int paf) {
EtapaCrianzaPK id = new EtapaCrianzaPK(us,rol,uf,paf);
System.out.println("voy a borrar"+id);
etapaCrianzaService.delete(id);
return ResponseEntity.ok().build();
}}

