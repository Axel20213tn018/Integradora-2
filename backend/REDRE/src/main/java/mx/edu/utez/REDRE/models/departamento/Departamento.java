package mx.edu.utez.REDRE.models.departamento;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;
import mx.edu.utez.REDRE.models.responsable.Responsable;
import mx.edu.utez.REDRE.models.usuario.Usuario;

import java.util.List;

@Entity
@Table(name = "departamentos")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uid", nullable = false, unique = true)
    private String uid;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "division_academica", nullable = false)
    private String divisionAcademica;
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;

    //@OneToOne(mappedBy = "departamento", cascade = CascadeType.ALL, optional = false)
    //private Usuario usuario;

    @OneToMany(mappedBy = "departamento")
    @JsonManagedReference
    private List<Responsable> responsables;

    @OneToMany(mappedBy = "departamento")
    @JsonManagedReference
    private List<ReporteFinal> reportesFinales;

}
