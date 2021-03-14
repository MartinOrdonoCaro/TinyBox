package aaa.moc.TinyBox.controller;

import aaa.moc.TinyBox.domain.Medida;
import aaa.moc.TinyBox.service.MedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/medida")
public class MedidaController {
    @Autowired
    private MedidaService medidaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Medida>> findAll() {
        return ResponseEntity.ok(this.medidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medida> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.medidaService.findOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Medida> create(@Valid @RequestBody Medida medida) {
        return ResponseEntity.ok(this.medidaService.create(medida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.medidaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
