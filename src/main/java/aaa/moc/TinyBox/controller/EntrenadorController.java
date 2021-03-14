package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.domain.Entrenador;
import aaa.moc.TinyBox.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Entrenador>> findAll() {
        return ResponseEntity.ok(this.entrenadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.entrenadorService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Entrenador> create(@Valid @RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(this.entrenadorService.create(entrenador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.entrenadorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
