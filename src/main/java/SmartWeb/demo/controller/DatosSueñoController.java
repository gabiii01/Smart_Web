package SmartWeb.demo.controller;

import SmartWeb.demo.model.DatosSueño;
import SmartWeb.demo.service.DatosSueñoService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos-suenio")
public class DatosSueñoController {

    private final DatosSueñoService datosSueñoService;

    public DatosSueñoController(DatosSueñoService datosSueñoService) {
        this.datosSueñoService = datosSueñoService;
    }

    @GetMapping
    public List<DatosSueño> getAll() {
        return datosSueñoService.findAll();
    }

    @GetMapping("/{id}")
    public DatosSueño getById(@PathVariable Long id) {
        return datosSueñoService.findById(id).orElse(null);
    }

    @PostMapping
    public DatosSueño create(@RequestBody DatosSueño datos) {
        return datosSueñoService.save(datos);
    }

    @PutMapping("/{id}")
    public DatosSueño update(@PathVariable Long id, @RequestBody DatosSueño datos) {
        datos.setId(id); // Marcamos el ID para actualizar
        return datosSueñoService.save(datos);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        datosSueñoService.deleteById(id);
    }
}
