package mx.edu.utez.REDRE.models.estudiante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstudianteDto {
    private Long id;
    private String uid;
    private String nombre;
    private String apellidos;
    private String correo;
    private String divisionAcademica;
    private String carrera;
    private int grado;
    private char grupo;
    private Boolean status;
    private String reporte;
    private Asesor asesor;
    private ReporteFinal reporteFinal;

    public Estudiante getEstudiante(){
        return new Estudiante(
                getId(),
                getUid(),
                getNombre(),
                getApellidos(),
                getCorreo(),
                getDivisionAcademica(),
                getCarrera(),
                getGrado(),
                getGrupo(),
                getStatus(),
                getReporte(),
                getAsesor(),
                getReporteFinal()
        );
    }
}
