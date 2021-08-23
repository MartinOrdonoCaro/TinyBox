package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Sesion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SesionRepository extends CrudRepository<Sesion,Long> {
    List<Sesion> findAllByFechaInicioAfterAndFechaFinBefore(Date fechaInicio, Date fechaFin);
}
