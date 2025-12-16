package SmartWeb.demo.controller;

import SmartWeb.demo.model.DatosSueno;
import SmartWeb.demo.service.DatosSuenoService;

import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/datos-suenio")
public class DatosSuenoController {

    private final DatosSuenoService datosSuenoService;

    public DatosSuenoController(DatosSuenoService datosSuenoService) {
        this.datosSuenoService = datosSuenoService;
    }

    @GetMapping
    public List<DatosSueno> EncontrarDatoSueno() {
        return datosSuenoService.EncontrarDatoSueno();
    }

    @GetMapping("/{id}")
    public DatosSueno EncontrarporID(@PathVariable Long id) {
        return datosSuenoService.EncontrarporID(id).orElse(null);
    }

    @PostMapping
    public DatosSueno crearDataSueno(@RequestBody DatosSueno datos) {
        return datosSuenoService.GuardarRegistroDatoSueno(datos);
    }



    @PutMapping("/{id}")
    public DatosSueno updateDataSueno(@PathVariable Long id, @RequestBody DatosSueno datos) {
        datos.setId(id); // Marcamos el ID para actualizar
        return datosSuenoService.GuardarRegistroDatoSueno(datos);
    }

    @DeleteMapping("/{id}")
    public void deleteDataSueno(@PathVariable Long id) {
        datosSuenoService.BorrarporID(id);
    }
}


