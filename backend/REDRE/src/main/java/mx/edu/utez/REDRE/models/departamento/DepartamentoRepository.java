package mx.edu.utez.REDRE.models.departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    @Override
    Optional<Departamento> findById(Long aLong);

    Optional<Departamento> findByEmail(String correo);
}
