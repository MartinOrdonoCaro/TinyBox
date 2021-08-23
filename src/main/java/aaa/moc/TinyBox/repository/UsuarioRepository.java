package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    Optional<Usuario> findByNombre(String nombre);
}