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
    private String correo;
    private String divisionAcademica;
    private Boolean status;
    private Responsable responsable;
    private List<ReporteFinal> reportesFinales;

    public Departamento getDepartamento(){
        return new Departamento(
            getId(),
            getUid(),
            getNombre(),
            getCorreo(),
            getDivisionAcademica(),
            getStatus(),
            getResponsable(),
            getReportesFinales()
        );
    }
}
