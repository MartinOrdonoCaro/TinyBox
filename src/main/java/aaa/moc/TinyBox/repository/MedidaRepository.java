package aaa.moc.TinyBox.repository;

import aaa.moc.TinyBox.domain.Medida;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidaRepository extends CrudRepository<Medida,Long> {
}