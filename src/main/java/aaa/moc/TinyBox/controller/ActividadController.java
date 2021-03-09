package aaa.moc.TinyBox.controller;


import aaa.moc.TinyBox.domain.Actividad;
import aaa.moc.TinyBox.service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Actividad>> findAll() {
        return ResponseEntity.ok(this.actividadService.findAll());
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<Actividad> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.actividadService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Actividad> create(@Valid @RequestBody Actividad actividad) {
        return ResponseEntity.ok(this.actividadService.create(actividad));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.actividadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
