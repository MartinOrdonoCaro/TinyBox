package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.domain.Sesion;
import aaa.moc.TinyBox.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/sesion")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    DateFormat format = new SimpleDateFormat("dd/M/yyyy HH:mm");

    @GetMapping("/findAll")
    public ResponseEntity<List<Sesion>> findAll() {
        return ResponseEntity.ok(this.sesionService.findAll());
    }

    @GetMapping("/findAllCurrent")
    public ResponseEntity<List<Sesion>> findAllCurrent() {
        return ResponseEntity.ok(this.sesionService.findAllCurrentWeek());
    }

    @PostMapping("/findAllByWeek")
    public ResponseEntity<List<Sesion>> findAllByWeek(@RequestBody @NotNull String start, @RequestBody @NotNull String end) throws ParseException {
        return ResponseEntity.ok(this.sesionService.findAllByWeek(format.parse(start), format.parse(end)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sesion> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.sesionService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Sesion> create(@Valid @RequestBody Sesion sesion) {
        return ResponseEntity.ok(this.sesionService.create(sesion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.sesionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
