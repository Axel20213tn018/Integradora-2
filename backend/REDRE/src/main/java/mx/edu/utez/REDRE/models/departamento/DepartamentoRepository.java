package mx.edu.utez.REDRE.models.departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    @Modifying
    @Query(
            value = "UPDATE departamentos SET status = :status WHERE id = :id",
            nativeQuery = true
    )
    int updateStatusById(
        @Param("status") Boolean status,
        @Param("id") Long id
    );

    @Override
    Optional<Departamento> findById(Long aLong);

    //Optional<Departamento> findByEmail(Long id);
    //Optional<Departamento> findByEmail(String correo);

    boolean existsByCorreo(String email);

    List<Departamento> findAllByStatus(Boolean status);
}
