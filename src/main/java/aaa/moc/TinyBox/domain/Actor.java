package aaa.moc.TinyBox.domain;

import aaa.moc.TinyBox.enumerate.Rol;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Actor implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @NotEmpty(message = "El campo nombre no puede estar vacío.")
    @Size(max = 50, message = "El campo nombre no puede tener más de 50 caracteres")
    @Column(length = 50)
    private String nombre;

    @NotEmpty(message = "El campo contraseña no puede estar vacío.")
    @Size(max = 100, message = "El campo contraseña no puede tener más de 100 caracteres")
    @Column(length = 100)
    private String contrasena;

    @NotEmpty(message = "El campo email no puede estar vacío.")
    @Email(message = "El email no es válido")
    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.toString()));
        return roles;
    }

    @Override
    public String getPassword() {
        return this.getContrasena();
    }

    @Override
    public String getUsername() {
        return this.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
