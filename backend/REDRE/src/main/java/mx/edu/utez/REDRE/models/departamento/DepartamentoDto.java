package mx.edu.utez.REDRE.models.departamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.responsable.Responsable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartamentoDto {
    private Long id;
    private String uid;
    private String nombre;
    private String correo;
    private String divisionAcademica;
    private Responsable responsable;

    public Departamento getDepartamento(){
        return new Departamento(
            getId(),
            getUid(),
            getNombre(),
            getCorreo(),
            getDivisionAcademica(),
            getResponsable()
        );
    }
}
