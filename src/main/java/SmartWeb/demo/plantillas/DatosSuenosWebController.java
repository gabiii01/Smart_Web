package SmartWeb.demo.plantillas;


import SmartWeb.demo.model.DatosSueno;
import SmartWeb.demo.service.DatosSuenoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/datos")

public class DatosSuenosWebController {


    private final DatosSuenoService datosSuenoService;


    public DatosSuenosWebController(DatosSuenoService datosSuenoService) {
        this.datosSuenoService = datosSuenoService;
    }

    @GetMapping
    public String listarDatosSueno(Model model) {

        var historial = datosSuenoService.EncontrarDatoSueno();
        model.addAttribute("datos", historial);
        return "historial-datos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {

        model.addAttribute("datoSueno", new DatosSueno());
        return "formulario-datos";
    }

    @PostMapping("/nuevo")
    public RedirectView guardarDatosSueno(@ModelAttribute DatosSueno datoSueno) {

        if (datoSueno.getTemperatura() == null || datoSueno.getTemperatura().isEmpty()) {
            generarMedicionesSimuladas(datoSueno);
        }

        datosSuenoService.GuardarRegistroDatoSueno(datoSueno);
        return new RedirectView("/datos");
    }

    /*
    REALIZAMOS UN METODO QUE GENERE MEDICIONES SIMULADAS
     */
    private void generarMedicionesSimuladas(DatosSueno datoSueno) {

        List<Float> temperaturas = new ArrayList<>();
        List<Float> ruidos = new ArrayList<>();
        List<Float> oxigenaciones = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            temperaturas.add(18 + (float) (Math.random() * 5));
            ruidos.add((float) (Math.random() * 50));
            oxigenaciones.add(90 + (float) (Math.random() * 5));
        }

        datoSueno.setTemperatura(temperaturas);
        datoSueno.setRuido(ruidos);
        datoSueno.setOxigenacion(oxigenaciones);
    }


}

