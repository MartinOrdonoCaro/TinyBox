package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.domain.Ejercicio;
import aaa.moc.TinyBox.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {
    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Ejercicio>> findAll() {
        return ResponseEntity.ok(this.ejercicioService.findAll());
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Ejercicio> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.ejercicioService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Ejercicio> create(@Valid @RequestBody Ejercicio ejercicio) {
        return ResponseEntity.ok(this.ejercicioService.create(ejercicio));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.ejercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
