package SmartWeb.demo.service;

import SmartWeb.demo.model.DatosSueño;
import SmartWeb.demo.repository.DatosSueñoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatosSueñoService {

    private final DatosSueñoRepositorio datosSueñoRepositorio;

    public DatosSueñoService(DatosSueñoRepositorio datosSueñoRepositorio) {
        this.datosSueñoRepositorio = datosSueñoRepositorio;
    }

    // Obtener todos los registros
    public List<DatosSueño> EncontrarDatoSueño() {
        return datosSueñoRepositorio.findAll();
    }

    // Buscar uno por ID
    public Optional<DatosSueño> EncontrarporID(Long id) {
        return datosSueñoRepositorio.findById(id);
    }

    // Crear o actualizar
    public DatosSueño GuardarRegistroDatoSueño(DatosSueño datosSueño) {
        return datosSueñoRepositorio.save(datosSueño);
    }

    // Borrar un registro por ID
    public void BorrarporID(Long id) {
        datosSueñoRepositorio.deleteById(id);
    }
}
