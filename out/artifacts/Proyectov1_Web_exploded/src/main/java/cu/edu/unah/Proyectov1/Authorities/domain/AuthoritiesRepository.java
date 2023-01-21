package cu.edu.unah.Proyectov1.Authorities.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesPK>{

	public List<Authorities> findByUsername(String username);
}
