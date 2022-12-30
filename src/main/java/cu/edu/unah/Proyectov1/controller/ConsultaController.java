package cu.edu.unah.Proyectov1.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cu.edu.unah.Proyectov1.model.Obreros;
import cu.edu.unah.Proyectov1.service.ConsultaService;


@RequestMapping("/Consulta")
@RestController
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService ;
	private int i;
	
	@GetMapping(path= {"/consulta1"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Obreros>> consulta1() {
		  
		i = 0;
		try {
			return new ResponseEntity<List<Obreros>>(consultaService.consulta1(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	  @GetMapping("tardanzas")
	  public ResponseEntity<?>Tardanzas(
			  @RequestParam(name="inicio",required=true)@DateTimeFormat(pattern="yyyy-mm-dd")Date fechaInicio,
			  @RequestParam(name="fin",required = true)@DateTimeFormat(pattern="yyyy-mm-dd")Date fechaFin){
			  return ResponseEntity.ok(consultaService.consulta2(fechaInicio, fechaFin));
	  }


	  @GetMapping("Acumulados")
	  public ResponseEntity<?>Acumulados(
			  @RequestParam(name="inicio",required=true)@DateTimeFormat(pattern="yyyy-mm-dd")Date fechaInicio,
			  @RequestParam(name="fin",required = true)@DateTimeFormat(pattern="yyyy-mm-dd")Date fechaFin){
			  return ResponseEntity.ok(consultaService.consulta3(fechaInicio, fechaFin));
	  }
}
 