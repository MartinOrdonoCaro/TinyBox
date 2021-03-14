package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Actor;
import aaa.moc.TinyBox.exception.ActorNotFoundException;
import aaa.moc.TinyBox.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    /**
     * Crea un nuevo actor.
     * @param actor Actor
     * @return instancia del actor creado
     */
    public Actor create(Actor actor) {
        return this.actorRepository.save(actor);
    }

    /**
     * Borra un ejercio dado un id. Si el actor no existe lanza una excepción
     * @param id Id del Actor
     */
    public void delete(Long id) {
        if(this.actorRepository.findById(id).isPresent()) {
            this.actorRepository.deleteById(id);
        } else {
            throw new ActorNotFoundException("No existe un actor con id {0}",
                    new String[]{id.toString()});
        }
    }

    /**
     * Lista todos los actors.
     */
    public List<Actor> findAll() {
        return StreamSupport.stream(this.actorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca un actor por id.
     * @param id del Actor
     * @return actor con el id indicado
     */
    public Actor findOne(Long id) {
        Optional<Actor> actorOptional = this.actorRepository.findById(id);
        if(actorOptional.isPresent()) {
            return actorOptional.get();
        } else {
            throw new ActorNotFoundException("No existe actor con id {0}",
                    new String[]{id.toString()});
        }
    }

    /**
     * Busca un actor por nombre.
     * @param nombre del Actor
     * @return actor correspondiente al nombre
     */
    public Actor findOneByNombre(String nombre) {
        Optional<Actor> actorOptional = this.actorRepository.findByNombre(nombre);
        if(actorOptional.isPresent()) {
            return actorOptional.get();
        } else {
            throw new ActorNotFoundException("No existe actor con nombre {0}",
                    new String[]{nombre});
        }
    }
}
