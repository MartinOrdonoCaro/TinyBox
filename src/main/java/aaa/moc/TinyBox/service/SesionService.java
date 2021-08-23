package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Sesion;
import aaa.moc.TinyBox.exception.SesionNotFoundException;
import aaa.moc.TinyBox.repository.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SesionService {

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Crea una nueva sesion.
     * @param sesion Sesion
     * @return instancia de la sesion creada
     */

    public Sesion create(Sesion sesion){
        sesion.setUsuario(this.usuarioService.findOneByNombre(sesion.getUsuario().getNombre()));
        return this.sesionRepository.save(sesion);
    }

    /**
     * Borra una sesion dando un id. Si la sesion no existe lanza una excepción
     * @param id Id de la Sesion
     */

    public void delete(Long id){
        if(this.sesionRepository.findById(id).isPresent()) {
            this.sesionRepository.deleteById(id);
        } else {
            throw new SesionNotFoundException("No existe una sesion con id {0}",
                    new String[]{id.toString()});
        }
    }


    /**
     * Lista todas las sesiones.
     */
    public List<Sesion> findAll() {
        return StreamSupport.stream(this.sesionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    /**
     * Lista todas las sesiones de esta semana.
     */
    public List<Sesion> findAllCurrentWeek() {
        Date inicio, fin;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
        } else {
            calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
        }
        inicio = calendar.getTime();
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        fin = calendar.getTime();
        return this.sesionRepository.findAllByFechaInicioAfterAndFechaFinBefore(inicio, fin);
    }


    /**
     * Lista todas las sesiones de una semana.
     */
    public List<Sesion> findAllByWeek(Date start, Date end) {
        return this.sesionRepository.findAllByFechaInicioAfterAndFechaFinBefore(start, end);
    }

    /**
     * Busca una sesion por id.
     * @param id de la Sesion
     * @return sesion con el id indicado
     */
    public Sesion findOne(Long id) {
        Optional<Sesion> sesionOptional = this.sesionRepository.findById(id);
        if(sesionOptional.isPresent()) {
            return sesionOptional.get();
        } else {
            throw new SesionNotFoundException("No existe ejercicio con id {0}",
                    new String[]{id.toString()});
        }
    }
}
