package SmartWeb.demo.modelTest;

import SmartWeb.demo.model.DatosSueno;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class DatosSuenoTest {

    @Test
    void testConstructorYgetters(){
        Long id = 5L;
        LocalDateTime fechaHora = LocalDateTime.of(2025, 12, 16, 22, 0);
        Float duracion = 7.5f;

        List<Float> temp = Arrays.asList(20.0f, 21.0f);

        DatosSueno dato = new DatosSueno();
        dato.setId(id);
        dato.setFechaHora(fechaHora);
        dato.setDuracionSueno(duracion);
        dato.setTemperatura(temp);

        assertEquals(id, dato.getId());
        assertEquals(fechaHora, dato.getFechaHora());
        assertEquals(duracion, dato.getDuracionSueno());

        assertEquals(2, dato.getTemperatura().size());
        assertEquals(20.0f, dato.getTemperatura().get(0));

    }

    @Test
    void testInicializacionListas() {
        DatosSueno dato = new DatosSueno();

        dato.setRuido(new ArrayList<>());
        dato.setOxigenacion(new ArrayList<>());
        dato.setTemperatura(new ArrayList<>());

        assertNotNull(dato.getRuido());
        assertTrue(dato.getRuido().isEmpty());
        assertNotNull(dato.getOxigenacion());
        assertTrue(dato.getOxigenacion().isEmpty());
        assertNotNull(dato.getTemperatura());
        assertTrue(dato.getTemperatura().isEmpty());
    }
}
