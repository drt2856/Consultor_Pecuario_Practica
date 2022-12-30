package cu.edu.unah.Proyectov1.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cu.edu.unah.Proyectov1.model.Area;

import cu.edu.unah.Proyectov1.repository.AreaRepository;

@Service
public class AreaService {

	@Autowired
	private AreaRepository arearepository;
	
	public Area save(Area area) {//para los id de tipo int se pone 0 como condicion y no null,si el tipo de dato del id es long se puede mantener el null
		if (area.getIdArea() != 0 && arearepository.existsById(area.getIdArea())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return arearepository.save(area);
	}

	public Area update(Area area) {
		if (area.getIdArea()  != 0 && !arearepository.existsById(area.getIdArea())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return arearepository.save(area);
	}

	public List<Area> findAll() {
		return arearepository.findAll();
	}

	
	
	public Area findarea(int id) {
		Area univ = arearepository.findById(id).get();
		return univ;

	}

	public void delete(int id) {
		arearepository.deleteById(id);
}
}
