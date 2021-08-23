package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.domain.Entrenamiento;
import aaa.moc.TinyBox.service.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entrenamiento")
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Entrenamiento>> findAll() {
        return ResponseEntity.ok(this.entrenamientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenamiento> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.entrenamientoService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Entrenamiento> create(@Valid @RequestBody Entrenamiento entrenamiento) {
        return ResponseEntity.ok(this.entrenamientoService.create(entrenamiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.entrenamientoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
