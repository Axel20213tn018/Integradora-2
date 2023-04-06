package mx.edu.utez.REDRE.security.model;

import mx.edu.utez.REDRE.models.asesor.Asesor;
import mx.edu.utez.REDRE.models.departamento.Departamento;
import mx.edu.utez.REDRE.models.estudiante.Estudiante;
import mx.edu.utez.REDRE.models.responsable.Responsable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserAuth implements UserDetails {
    private String email;
    private String password;
    private Departamento departamento;
    private Responsable responsable;
    private Asesor asesor;
    private Estudiante estudiante;

    private Collection<? extends GrantedAuthority> authorities;

    public UserAuth(String email, String password, Departamento departamento, Collection<? extends GrantedAuthority> authorities){
        this.email = email;
        this.password = password;
        this.departamento = departamento;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
