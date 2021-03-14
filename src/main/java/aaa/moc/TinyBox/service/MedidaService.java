package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Medida;
import aaa.moc.TinyBox.exception.MedidaNotFoundException;
import aaa.moc.TinyBox.repository.MedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MedidaService {

    @Autowired
    private MedidaRepository medidaRepository;

    /**
     * Crea un nuevo medida.
     * @param medida Medida
     * @return instancia del medida creado
     */
    public Medida create(Medida medida) {
        return this.medidaRepository.save(medida);
    }

    /**
     * Borra un medida dado un id. Si el medida no existe lanza una excepción
     * @param id Id del Medida
     */
    public void delete(Long id) {
        if(this.medidaRepository.findById(id).isPresent()) {
            this.medidaRepository.deleteById(id);
        } else {
            throw new MedidaNotFoundException("No existe un medida con id {0}",
                    new String[]{id.toString()});
        }
    }

    /**
     * Lista todos los medidas.
     */
    public List<Medida> findAll() {
        return StreamSupport.stream(this.medidaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    /**
     * Busca un medida por id.
     * @param id del Medida
     * @return medida con el id indicado
     */
    public Medida findOne(Long id) {
        Optional<Medida> medidaOptional = this.medidaRepository.findById(id);
        if(medidaOptional.isPresent()) {
            return medidaOptional.get();
        } else {
            throw new MedidaNotFoundException("No existe medida con id {0}",
                    new String[]{id.toString()});
        }
    }
}
