package mx.edu.utez.REDRE.models.asesor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsesorRepository extends JpaRepository<Asesor, Long> {
    @Modifying
    @Query(value = "UPDATE asesor SET status = :status WHERE id = :id", nativeQuery = true)
    int updateStatusById(
            @Param("status") Boolean status,
            @Param("id")Long id);
    boolean existsByCorreo(String correo);

    List<Asesor> findAllByStatus(Boolean status);
}
