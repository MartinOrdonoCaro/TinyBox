package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Entrenamiento;
import aaa.moc.TinyBox.exception.EntrenamientoNotFoundException;
import aaa.moc.TinyBox.repository.EntrenamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EntrenamientoService {

    @Autowired
    private EntrenamientoRepository entrenamientoRepository;

    /**
     * Crea una nueva entrenamiento.
     * @param entrenamiento Entrenamiento
     * @return instancia de la entrenamiento creada
     */

    public Entrenamiento create(Entrenamiento entrenamiento){ return this.entrenamientoRepository.save(entrenamiento);}

    /**
     * Borra una entrenamiento dando un id. Si la entrenamiento no existe lanza una excepción
     * @param id Id de la Entrenamiento
     */

    public void delete(Long id){
        if(this.entrenamientoRepository.findById(id).isPresent()) {
            this.entrenamientoRepository.deleteById(id);
        } else {
            throw new EntrenamientoNotFoundException("No existe una entrenamiento con id {0}",
                    new String[]{id.toString()});
        }
    }


    /**
     * Lista todas las entrenamientoes.
     */
    public List<Entrenamiento> findAll() {
        return StreamSupport.stream(this.entrenamientoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca una entrenamiento por id.
     * @param id de la Entrenamiento
     * @return entrenamiento con el id indicado
     */
    public Entrenamiento findOne(Long id) {
        Optional<Entrenamiento> entrenamientoOptional = this.entrenamientoRepository.findById(id);
        if(entrenamientoOptional.isPresent()) {
            return entrenamientoOptional.get();
        } else {
            throw new EntrenamientoNotFoundException("No existe ejercicio con id {0}",
                    new String[]{id.toString()});
        }
    }
}
