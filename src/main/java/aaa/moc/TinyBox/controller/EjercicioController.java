package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.domain.Ejercicio;
import aaa.moc.TinyBox.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ejercicio")
public class EjercicioController {
    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Ejercicio>> findAll() {
        return ResponseEntity.ok(this.ejercicioService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Ejercicio> create(@Valid @RequestBody Ejercicio ejercicio) {
        return ResponseEntity.ok(this.ejercicioService.save(ejercicio));
    }


}
