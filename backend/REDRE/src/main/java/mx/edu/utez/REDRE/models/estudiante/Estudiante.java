package mx.edu.utez.REDRE.models.estudiante;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "asesores")
@AllArgsConstructor
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

    private String carrera;

    private int grado;

    private char grupo;

    @Column(nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;
    private String reporte;
}
