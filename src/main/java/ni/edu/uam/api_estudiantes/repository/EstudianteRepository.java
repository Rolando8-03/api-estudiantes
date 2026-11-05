package ni.edu.uam.api_estudiantes.repository;

import ni.edu.uam.api_estudiantes.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}