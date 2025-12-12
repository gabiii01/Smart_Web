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
    public List<DatosSueño> EncontrarDatoSueño() {
        return datosSueñoService.EncontrarDatoSueño();
    }

    @GetMapping("/{id}")
    public DatosSueño EncontrarporID(@PathVariable Long id) {
        return datosSueñoService.EncontrarporID(id).orElse(null);
    }

    @PostMapping
    public DatosSueño crearDataSueno(@RequestBody DatosSueño datos) {
        return datosSueñoService.GuardarRegistroDatoSueño(datos);
    }

    @PutMapping("/{id}")
    public DatosSueño updateDataSueno(@PathVariable Long id, @RequestBody DatosSueño datos) {
        datos.setId(id); // Marcamos el ID para actualizar
        return datosSueñoService.GuardarRegistroDatoSueño(datos);
    }

    @DeleteMapping("/{id}")
    public void deleteDaraSuenp(@PathVariable Long id) {
        datosSueñoService.BorrarporID(id);
    }
}
