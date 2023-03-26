package mx.edu.utez.REDRE.models.asesor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.estudiante.Estudiante;
import mx.edu.utez.REDRE.models.responsable.Responsable;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AsesorDto {
    private Long id;
    private String uid;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private Boolean status;
    private String divisionAcademica;
    private Responsable responsable;
    private List<Estudiante> estudiantes;

    public Asesor getAsesor(){
        return new Asesor(
                getId(),
                getUid(),
                getNombre(),
                getApellidos(),
                getCorreo(),
                getPassword(),
                getStatus(),
                getDivisionAcademica(),
                getResponsable(),
                getEstudiantes()
        );
    }
}
