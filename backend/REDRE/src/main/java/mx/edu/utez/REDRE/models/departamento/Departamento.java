package mx.edu.utez.REDRE.models.departamento;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.responsable.Responsable;

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

    @OneToOne(mappedBy = "departamento", cascade = CascadeType.ALL, optional = false)
    private Responsable responsable;

    public Departamento(Long id, String uid, String nombre, String correo, String divisionAcademica, Responsable responsable) {
        this.id = id;
        this.uid = uid;
        this.nombre = nombre;
        this.correo = correo;
        this.divisionAcademica = divisionAcademica;
        this.responsable = responsable;
        this.responsable.setDepartamento(this);
    }
}
