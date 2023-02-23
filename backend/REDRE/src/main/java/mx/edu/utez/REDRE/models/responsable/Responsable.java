package mx.edu.utez.REDRE.models.responsable;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @Column(name = "division_academica", nullable = false, unique = true)
    private String divisionAcademica;

    @OneToOne
    @JoinColumn(name = "departamento_id", referencedColumnName = "id", unique = true, nullable = false)
    @JsonIgnore
    private Departamento departamento;

    @OneToMany(mappedBy = "responsable")
    private List<Asesor> asesores;
}
