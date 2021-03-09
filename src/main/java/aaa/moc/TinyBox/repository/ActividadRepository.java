package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Actividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends CrudRepository<Actividad,Long> {
}
