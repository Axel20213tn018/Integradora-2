package mx.edu.utez.REDRE.models.estudiante;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;

import javax.persistence.*;

@Entity
@Table(name = "estudiantes")
@NoArgsConstructor
@Setter
@Getter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uid", nullable = false, unique = true)
    private String uid;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(nullable = false, unique = true)
    private String correo;
    @Column(name = "division_academica", nullable = false)
    private String divisionAcademica;
    @Column(name = "carrera", nullable = false)
    private String carrera;
    @Column(nullable = false)
    private int grado;
    @Column(nullable = false)
    private char grupo;
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @Column(name = "reporte")
    private String reporte; // Posible cambio a futuro

    @ManyToOne
    @JoinColumn(name = "asesor_id", nullable = false)
    private Asesor asesor;

    @OneToOne(mappedBy = "estudiante", cascade = CascadeType.ALL, optional = false)
    private ReporteFinal reporteFinal;

    public Estudiante(Long id, String uid, String nombre, String apellidos, String correo, String divisionAcademica, String carrera, int grado, char grupo, Boolean status, String reporte, Asesor asesor, ReporteFinal reporteFinal) {
        this.id = id;
        this.uid = uid;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.divisionAcademica = divisionAcademica;
        this.carrera = carrera;
        this.grado = grado;
        this.grupo = grupo;
        this.status = status;
        this.reporte = reporte;
        this.asesor = asesor;
        this.reporteFinal = reporteFinal;
        this.reporteFinal.setEstudiante(this);
    }
}
