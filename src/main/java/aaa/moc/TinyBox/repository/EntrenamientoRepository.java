package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Actividad;
import aaa.moc.TinyBox.domain.Entrenamiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenamientoRepository extends CrudRepository<Entrenamiento, Long> {
}
