package mx.edu.utez.REDRE.models.departamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;
import mx.edu.utez.REDRE.models.responsable.Responsable;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DepartamentoDto {
    private Long id;
    private String uid;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private String divisionAcademica;
    private Boolean status;
    private List<Responsable> responsables;
    private List<ReporteFinal> reportesFinales;

    public Departamento getDepartamento(){
        return new Departamento(
                getId(),
                getUid(),
                getNombre(),
                getApellidos(),
                getCorreo(),
                getPassword(),
                getDivisionAcademica(),
                getStatus(),
                getResponsables(),
                getReportesFinales()
        );
    }
}
