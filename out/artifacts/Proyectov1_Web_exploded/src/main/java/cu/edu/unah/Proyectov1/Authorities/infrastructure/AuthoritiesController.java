package cu.edu.unah.Proyectov1.Authorities.infrastructure;

import cu.edu.unah.Proyectov1.Authorities.domain.Authorities;
import cu.edu.unah.Proyectov1.Authorities.domain.AuthoritiesPK;
import cu.edu.unah.Proyectov1.Authorities.application.AuthoritiesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/Authorities")
@RestController
public class AuthoritiesController {
	@Autowired
	private AuthoritiesServices authoritiesServices;

	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Authorities>> findAll() {
		try {
			return new ResponseEntity<List<Authorities>>(authoritiesServices.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = { "/find" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Authorities> findById(@RequestBody AuthoritiesPK id) {
		try {
			return new ResponseEntity<Authorities>(authoritiesServices.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = { "/findByUsername/{username}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Authorities>> findById(@PathVariable String username) {
		try {
			return new ResponseEntity<List<Authorities>>(authoritiesServices.findByUsername(username), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Authorities> createAuthorities(
			@RequestBody Authorities authorities) throws URISyntaxException {
		Authorities result = authoritiesServices.save(authorities);
		return ResponseEntity.created(new URI("/Authorities/create/" + result.getAuthoritiesPK())).body(result);
	}

	@PutMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Authorities> updateCarrera(@RequestBody Authorities authorities) throws URISyntaxException {
		if (authorities.getAuthoritiesPK()==null) {
			return new ResponseEntity<Authorities>(HttpStatus.NOT_FOUND);
		}
		try {
			Authorities result = authoritiesServices.update(authorities);
			return ResponseEntity.created(new URI("/Authorities/updated/" + result.getAuthoritiesPK())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = { "/delete" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@RequestBody AuthoritiesPK id) {
		authoritiesServices.delete(id);
		return ResponseEntity.ok().build();
	}

}
