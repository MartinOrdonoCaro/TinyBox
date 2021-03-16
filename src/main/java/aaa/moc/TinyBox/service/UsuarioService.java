package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Usuario;
import aaa.moc.TinyBox.enumerate.Rol;
import aaa.moc.TinyBox.exception.UsuarioNotFoundException;
import aaa.moc.TinyBox.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Crea un nuevo usuario.
     * @param usuario Usuario
     * @return instancia del usuario creado
     */
    public Usuario create(Usuario usuario) {
        usuario.setRol(Rol.ROLE_USUARIO);
        usuario.setContrasena(passwordEncoder.encode(usuario.getPassword()));
        return this.usuarioRepository.save(usuario);
    }

    /**
     * Borra un usuario dado un id. Si el usuario no existe lanza una excepción
     * @param id Id del Usuario
     */
    public void delete(Long id) {
        if(this.usuarioRepository.findById(id).isPresent()) {
            this.usuarioRepository.deleteById(id);
        } else {
            throw new UsuarioNotFoundException("No existe un usuario con id {0}",
                    new String[]{id.toString()});
        }
    }

    /**
     * Lista todos los usuarios.
     */
    public List<Usuario> findAll() {
        return StreamSupport.stream(this.usuarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca un usuario por id.
     * @param id del Usuario
     * @return usuario con el id indicado
     */
    public Usuario findOne(Long id) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new UsuarioNotFoundException("No existe usuario con id {0}",
                    new String[]{id.toString()});
        }
    }
}
