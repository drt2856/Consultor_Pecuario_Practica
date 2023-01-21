package cu.edu.unah.Proyectov1.Users.application;

import cu.edu.unah.Proyectov1.Users.domain.Users;
import cu.edu.unah.Proyectov1.Users.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UsersServices {

	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	public Users findById(String id) {
		return usersRepository.findById(id).get();
	}

	public Users save(Users users) {
		if (users.getUsername()!=null && usersRepository.existsById(users.getUsername())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}

		return usersRepository.save(users);
	}

	public Users update(Users users) {
		if (users.getUsername()!=null && !usersRepository.existsById(users.getUsername())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}

		return usersRepository.save(users);
	}

	public void delete(String id) {
		usersRepository.deleteById(id);
	}
}
