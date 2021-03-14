package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Entrenador;
import aaa.moc.TinyBox.exception.EntrenadorNotFoundException;
import aaa.moc.TinyBox.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    /**
     * Crea un nuevo entrenador.
     * @param entrenador Entrenador
     * @return instancia del entrenador creado
     */
    public Entrenador create(Entrenador entrenador) {
        return this.entrenadorRepository.save(entrenador);
    }

    /**
     * Borra un entrenador dado un id. Si el entrenador no existe lanza una excepción
     * @param id Id del Entrenador
     */
    public void delete(Long id) {
        if(this.entrenadorRepository.findById(id).isPresent()) {
            this.entrenadorRepository.deleteById(id);
        } else {
            throw new EntrenadorNotFoundException("No existe un entrenador con id {0}",
                    new String[]{id.toString()});
        }
    }

    /**
     * Lista todos los entrenadors.
     */
    public List<Entrenador> findAll() {
        return StreamSupport.stream(this.entrenadorRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca un entrenador por id.
     * @param id del Entrenador
     * @return entrenador con el id indicado
     */
    public Entrenador findOne(Long id) {
        Optional<Entrenador> entrenadorOptional = this.entrenadorRepository.findById(id);
        if(entrenadorOptional.isPresent()) {
            return entrenadorOptional.get();
        } else {
            throw new EntrenadorNotFoundException("No existe entrenador con id {0}",
                    new String[]{id.toString()});
        }
    }
}
