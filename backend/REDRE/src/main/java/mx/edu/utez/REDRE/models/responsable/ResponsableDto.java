package mx.edu.utez.REDRE.models.responsable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.departamento.DepartamentoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResponsableDto {
    private Long id;
    private String uid;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private Boolean status;
    private String divisionAcademica;
    private Departamento departamento;
    private List<Asesor> asesores;

    public Responsable getResponsable(){
        return new Responsable(
                getId(),
                getUid(),
                getNombre(),
                getApellidos(),
                getCorreo(),
                getPassword(),
                getStatus(),
                getDivisionAcademica(),
                getDepartamento(),
                getAsesores()
        );
    }

}
