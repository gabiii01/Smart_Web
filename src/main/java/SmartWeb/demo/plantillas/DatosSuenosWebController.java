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
        model.addAttribute("historial", historial);
        return "historial-datos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {

        model.addAttribute("datoSueno", new DatosSueno());
        return "formulario-datos";
    }


    @PostMapping("/nuevo")
    public RedirectView guardarDatosSueno(@ModelAttribute DatosSueno datoSueno) {
        datosSuenoService.GuardarRegistroDatoSueno(datoSueno);
        return new RedirectView("/datos");
    }

}