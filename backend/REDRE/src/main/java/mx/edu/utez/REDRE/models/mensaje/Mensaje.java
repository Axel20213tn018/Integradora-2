package mx.edu.utez.REDRE.models.mensaje;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mensajes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uid_remitente", nullable = false)
    private String uidRemitente;
    @Column(name = "uid_destinatario", nullable = false)
    private String uidDestinatario;
    @Column(name = "fecha_envio", nullable = false, columnDefinition = "datetime")
    private String fechaEnvio;
    @Column(name = "mensaje", nullable = false)
    private String mensaje;
}
