package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Actividad;
import aaa.moc.TinyBox.exception.ActividadNotFoundException;
import aaa.moc.TinyBox.repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    /**
     * Crea una nueva actividad.
     * @param actividad Actividad
     * @return instancia de la actividad creada
     */

    public Actividad create(Actividad actividad){ return this.actividadRepository.save(actividad);}

    /**
     * Borra una actividad dando un id. Si la actividad no existe lanza una excepción
     * @param id Id de la Actividad
     */

    public void delete(Long id){
        if(this.actividadRepository.findById(id).isPresent()) {
            this.actividadRepository.deleteById(id);
        } else {
            throw new ActividadNotFoundException("No existe una actividad con id {0}",
                    new String[]{id.toString()});
        }
    }


    /**
     * Lista todas las actividades.
     */
    public List<Actividad> findAll() {
        return StreamSupport.stream(this.actividadRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca una actividad por id.
     * @param id de la Actividad
     * @return actividad con el id indicado
     */
    public Actividad findOne(Long id) {
        Optional<Actividad> actividadOptional = this.actividadRepository.findById(id);
        if(actividadOptional.isPresent()) {
            return actividadOptional.get();
        } else {
            throw new ActividadNotFoundException("No existe ejercicio con id {0}",
                    new String[]{id.toString()});
        }
    }


}
