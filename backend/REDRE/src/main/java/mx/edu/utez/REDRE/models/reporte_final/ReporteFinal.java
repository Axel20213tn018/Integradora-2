package mx.edu.utez.REDRE.models.reporte_final;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.consulta.Consulta;
import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.estudiante.Estudiante;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reportes_finales")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReporteFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "reporte_tsu")
    private String reporteTsu; // Posible cambio a futuro
    @Column(name = "reporte_ing")
    private String reporteIng; // Posible cambio a futuro

    @OneToOne
    @JoinColumn(name = "alumno_id", referencedColumnName = "id", unique = true, nullable = false)
    @JsonIgnore
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    @OneToMany(mappedBy = "reporteFinal")
    private List<Consulta> consultas;
}
