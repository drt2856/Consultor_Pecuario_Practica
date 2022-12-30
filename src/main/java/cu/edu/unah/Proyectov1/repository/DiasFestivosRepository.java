package cu.edu.unah.Proyectov1.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import cu.edu.unah.Proyectov1.model.DiasFestivos;

public interface DiasFestivosRepository extends JpaRepository<DiasFestivos, Date>{

}
