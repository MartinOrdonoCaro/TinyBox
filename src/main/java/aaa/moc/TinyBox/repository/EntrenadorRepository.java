package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends CrudRepository<Entrenador,Long> {
}