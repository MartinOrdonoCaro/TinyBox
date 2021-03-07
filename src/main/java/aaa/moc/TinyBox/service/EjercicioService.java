package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Ejercicio;
import aaa.moc.TinyBox.exception.EjercicioNotFoundException;
import aaa.moc.TinyBox.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    /**
     * Crea un nuevo ejercicio.
     * @param ejercicio Ejercicio
     * @return instancia del ejercicio creado
     */
    public Ejercicio create(Ejercicio ejercicio) {
        return this.ejercicioRepository.save(ejercicio);
    }

    /**
     * Borra un ejercio dado un id. Si el ejercicio no existe lanza una excepción
     * @param id Id del Ejercicio
     */
    public void delete(Long id) {
        if(this.ejercicioRepository.findById(id).isPresent()) {
            this.ejercicioRepository.deleteById(id);
        } else {
            throw new EjercicioNotFoundException("No existe un ejercicio con id {0}",
                    new String[]{id.toString()});
        }
    }

    /**
     * Lista todos los ejercicios.
     */
    public List<Ejercicio> findAll() {
        return StreamSupport.stream(this.ejercicioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca un ejercicio por id.
     * @param id del Ejercicio
     * @return ejercicio con el id indicado
     */
    public Ejercicio findOne(Long id) {
        Optional<Ejercicio> ejercicioOptional = this.ejercicioRepository.findById(id);
        if(ejercicioOptional.isPresent()) {
            return ejercicioOptional.get();
        } else {
            throw new EjercicioNotFoundException("No existe ejercicio con id {0}",
                    new String[]{id.toString()});
        }
    }
}
