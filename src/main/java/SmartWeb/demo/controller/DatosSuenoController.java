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

    // CODIGO ESPERADO EN EL DISPOSITIVO REAL DONDE EL DISPOSITIVO FACILITE LOS ARRAYS

    /*@PostMapping
    public DatosSueno crearDataSueno(@RequestBody DatosSueno datos) {
        return datosSuenoService.GuardarRegistroDatoSueno(datos);
    }
     */
    //

    @PostMapping("/nuevo")
    public String crearDataSuenoSimulado(@ModelAttribute DatosSueno datoSueno) {

        // Asegurarse de que las listas no sean null
        if (datoSueno.getTemperatura() == null) datoSueno.setTemperatura(new ArrayList<>());
        if (datoSueno.getRuido() == null) datoSueno.setRuido(new ArrayList<>());
        if (datoSueno.getOxigenacion() == null) datoSueno.setOxigenacion(new ArrayList<>());

        // Generar 80 mediciones simuladas
        for (int i = 0; i < 80; i++) {
            datoSueno.getTemperatura().add(18 + (float)(Math.random() * 5));
            datoSueno.getRuido().add((float)(Math.random() * 50));
        }

        // Guardar en la BD
        datosSuenoService.GuardarRegistroDatoSueno(datoSueno);

        return "redirect:/datos";
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


