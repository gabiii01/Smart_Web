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
    public List<DatosSueño> findAll() {
        return datosSueñoRepositorio.findAll();
    }

    // Buscar uno por ID
    public Optional<DatosSueño> findById(Long id) {
        return datosSueñoRepositorio.findById(id);
    }

    // Crear o actualizar
    public DatosSueño save(DatosSueño datosSueño) {
        return datosSueñoRepositorio.save(datosSueño);
    }

    // Borrar un registro por ID
    public void deleteById(Long id) {
        datosSueñoRepositorio.deleteById(id);
    }
}
