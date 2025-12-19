package SmartWeb.demo.serviceTest;


import SmartWeb.demo.model.DatosSueno;
import SmartWeb.demo.repository.DatosSuenoRepositorio;
import SmartWeb.demo.service.DatosSuenoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class DatoSuenoServiceTest {

    @Mock
    private DatosSuenoRepositorio datosSuenoRepositorio;

    @InjectMocks
    private DatosSuenoService datosSuenoService;

    private DatosSueno datosPrueba;


    @BeforeEach
    void setUp(){
        datosPrueba = new DatosSueno();
        datosPrueba.setId(1L);
        datosPrueba.setFechaHora(LocalDateTime.now().minusHours(8));
        datosPrueba.setDuracionSueno(8.0f);
        datosPrueba.setTemperatura(Arrays.asList(20.0f, 21.0f, 21.0f, 23.0f));
        datosPrueba.setRuido(Arrays.asList(10.0f, 15.0f, 13.1f, 23.1f, 12.4f));
        datosPrueba.setOxigenacion(Arrays.asList(96.2f, 95.5f, 98.1f, 97.6f, 93.9f));
    }

    @Test
    @DisplayName("Prueba de listar los registros")
    void testEncontrarDatosSueno(){
        when(datosSuenoRepositorio.findAll()).thenReturn(Arrays.asList(datosPrueba));
        List<DatosSueno> resultado = datosSuenoService.EncontrarDatoSueno();
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
    }

    @Test
    @DisplayName("Prueba de borrado por ID")
    void testBorrarPorId() {
        datosSuenoService.BorrarporID(1L);
        verify(datosSuenoRepositorio, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("Prueba de guardado básico")
    void testGuardarRegistro() {
        when(datosSuenoRepositorio.save(any(DatosSueno.class))).thenReturn(datosPrueba);
        DatosSueno resultado = datosSuenoService.GuardarRegistroDatoSueno(datosPrueba);
        assertNotNull(resultado);
        verify(datosSuenoRepositorio, times(1)).save(datosPrueba);
    }

    @Test
    @DisplayName("Prueba buscar por ID")
    void testBuscarPorId() {
        // Arrange
        DatosSueno ds = new DatosSueno();
        when(datosSuenoRepositorio.findById(1L)).thenReturn(Optional.of(ds));

        // Act
        Optional<DatosSueno> resultado = datosSuenoService.EncontrarporID(1L);

        // Assert
        assertTrue(resultado.isPresent());
    }
}
