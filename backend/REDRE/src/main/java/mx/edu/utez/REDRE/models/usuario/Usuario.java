package mx.edu.utez.REDRE.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Entity
//@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String correo;
    private String password;

    private Object persona;
}
