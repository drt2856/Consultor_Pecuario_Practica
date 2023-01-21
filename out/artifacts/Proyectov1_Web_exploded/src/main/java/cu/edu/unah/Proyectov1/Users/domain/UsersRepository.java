package cu.edu.unah.Proyectov1.Users.domain;

import cu.edu.unah.Proyectov1.Users.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{

}
