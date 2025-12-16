package SmartWeb.demo.service;

import SmartWeb.demo.model.DatosSueno;
import SmartWeb.demo.repository.DatosSuenoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatosSuenoService {

    private final DatosSuenoRepositorio datosSuenoRepositorio;

    public DatosSuenoService(DatosSuenoRepositorio datosSuenoRepositorio) {
        this.datosSuenoRepositorio = datosSuenoRepositorio;
    }

    // Obtener todos los registros
    public List<DatosSueno> EncontrarDatoSueno() {
        return datosSuenoRepositorio.findAll();
    }

    // Buscar uno por ID
    public Optional<DatosSueno> EncontrarporID(Long id) {
        return datosSuenoRepositorio.findById(id);
    }

    // Crear o actualizar
    public DatosSueno GuardarRegistroDatoSueno(DatosSueno datosSueno) {
        return datosSuenoRepositorio.save(datosSueno);
    }

    // Borrar un registro por ID
    public void BorrarporID(Long id) {
        datosSuenoRepositorio.deleteById(id);
    }
    public double calcularMediaTemperatura(DatosSueno dato) {

    if (dato.getTemperatura() == null || dato.getTemperatura().isEmpty()) {
        return 0.0;
    }

    return dato.getTemperatura().stream()
            .mapToDouble(Float::doubleValue)
            .average()
            .orElse(0.0);
}
    
}
