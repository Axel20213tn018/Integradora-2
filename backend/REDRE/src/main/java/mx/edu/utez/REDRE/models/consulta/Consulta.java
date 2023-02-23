package mx.edu.utez.REDRE.models.consulta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.REDRE.models.reporte_final.ReporteFinal;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "consultas")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fecha_consulta", columnDefinition = "datetime", nullable = false)
    private String fechaConsulta;

    @ManyToOne
    @JoinColumn(name = "reporte_final_id", nullable = false)
    private ReporteFinal reporteFinal;
}
