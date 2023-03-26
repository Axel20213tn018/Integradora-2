package mx.edu.utez.REDRE.models.asesor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.estudiante.Estudiante;
import mx.edu.utez.REDRE.models.responsable.Responsable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "asesores")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Asesor {
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
    @Column(name = "password", nullable = false)
    private String password;
    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    @Column(name = "division_academica", nullable = false, unique = true)
    private String divisionAcademica;

    @ManyToOne
    @JoinColumn(name = "responsable_id", nullable = false)
    @JsonBackReference
    private Responsable responsable;

    @OneToMany(mappedBy = "asesor")
    private List<Estudiante> estudiantes;
}
