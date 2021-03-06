package aaa.moc.TinyBox.service;

import aaa.moc.TinyBox.domain.Ejercicio;
import aaa.moc.TinyBox.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public Ejercicio save(Ejercicio ejercicio) {
        return this.ejercicioRepository.save(ejercicio);
    }

    public void delete(Long id) {
        this.ejercicioRepository.deleteById(id);
    }

    public List<Ejercicio> findAll() {

        return StreamSupport.stream(this.ejercicioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

    }

    public Ejercicio findOne(Long id) {
        Optional<Ejercicio> ejercicioOptional = this.ejercicioRepository.findById(id);

        if(ejercicioOptional.isPresent()) {
            return ejercicioOptional.get();
        } else {
            return null;
        }
    }
}
