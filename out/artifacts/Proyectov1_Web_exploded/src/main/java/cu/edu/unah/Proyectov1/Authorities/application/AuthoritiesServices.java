package cu.edu.unah.Proyectov1.Authorities.application;

import cu.edu.unah.Proyectov1.Authorities.domain.Authorities;
import cu.edu.unah.Proyectov1.Authorities.domain.AuthoritiesPK;
import cu.edu.unah.Proyectov1.Authorities.domain.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthoritiesServices {

	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	public List<Authorities> findAll() {
		return authoritiesRepository.findAll();
	}

	public Authorities findById(AuthoritiesPK id) {
		return authoritiesRepository.findById(id).get();
	}
	public List<Authorities> findByUsername(String username){
		return authoritiesRepository.findByUsername(username);
	}

	public Authorities save(Authorities authorities) {
		if (authorities.getAuthoritiesPK()!=null && authoritiesRepository.existsById(authorities.getAuthoritiesPK())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return authoritiesRepository.save(authorities);
	}

	public Authorities update(Authorities authorities) {
		if (authorities.getAuthoritiesPK()!=null && !authoritiesRepository.existsById(authorities.getAuthoritiesPK())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return authoritiesRepository.save(authorities);
	}

	public void delete(AuthoritiesPK id) {
		authoritiesRepository.deleteById(id);
	}
}
