package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Ejercicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjercicioRepository extends CrudRepository<Ejercicio,Long> {
}