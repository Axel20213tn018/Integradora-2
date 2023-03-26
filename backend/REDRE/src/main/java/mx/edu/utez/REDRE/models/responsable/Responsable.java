package mx.edu.utez.REDRE.models.responsable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.departamento.Departamento;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "responsables")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uid", nullable = false, unique = true)
    private String uid;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(nullable = false)
    private String correo;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @Column(name = "division_academica", nullable = false)
    private String divisionAcademica;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    @JsonBackReference
    private Departamento departamento;

    @OneToMany(mappedBy = "responsable")
    @JsonManagedReference
    private List<Asesor> asesores;
}
