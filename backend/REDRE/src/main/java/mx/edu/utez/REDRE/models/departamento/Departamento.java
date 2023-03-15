package mx.edu.utez.REDRE.models.departamento;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;
import mx.edu.utez.REDRE.models.responsable.Responsable;

import java.util.List;

@Entity
@Table(name = "departamentos")
@AllArgsConstructor
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
    @OneToMany(mappedBy = "departamento")
    private List<Responsable> responsables;

    @OneToMany(mappedBy = "departamento")
    private List<ReporteFinal> reportesFinales;

}
