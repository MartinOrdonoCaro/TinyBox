package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long> {

    Optional<Actor> findByNombre(String nombre);
}