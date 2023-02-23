package mx.edu.utez.REDRE.models.departamento;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;
import mx.edu.utez.REDRE.models.responsable.Responsable;

import java.util.List;

@Entity
@Table(name = "departamentos")
@NoArgsConstructor
@Setter
@Getter
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uid", nullable = false, unique = true)
    private String uid; // User ID de Firebase
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;
    @Column(name = "division_academica", nullable = false, unique = true)
    private String divisionAcademica;
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @OneToOne(mappedBy = "departamento", cascade = CascadeType.ALL, optional = false)
    private Responsable responsable;

    @OneToMany(mappedBy = "departamento")
    private List<ReporteFinal> reportesFinales;

    public Departamento(Long id, String uid, String nombre, String correo, String divisionAcademica, Boolean status, Responsable responsable, List<ReporteFinal> reportesFinales) {
        this.id = id;
        this.uid = uid;
        this.nombre = nombre;
        this.correo = correo;
        this.divisionAcademica = divisionAcademica;
        this.status = status;
        this.responsable = responsable;
        this.reportesFinales = reportesFinales;
        this.responsable.setDepartamento(this);
    }
}
