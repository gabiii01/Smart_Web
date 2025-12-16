package SmartWeb.demo.model;

import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "datos_sueno")
public class DatosSueno {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaHora;

    private float duracionSueno;

    @ElementCollection
    @CollectionTable(
            name = "temperaturas_sueno",
            joinColumns = @JoinColumn(name = "datos_sueno_id")
    )
    @Column(name = "valor")
    private List<Float> temperatura;


    @ElementCollection
    @CollectionTable(
            name = "ruido_sueno",
            joinColumns = @JoinColumn(name = "datos_sueno_id")
    )
    @Column(name = "valor")
    private List<Float> ruido;

    @ElementCollection
    @CollectionTable(
            name = "oxigenacion_sueno",
            joinColumns = @JoinColumn(name = "datos_sueno_id")
    )
    @Column(name = "valor")
    private List<Float> oxigenacion;


    public DatosSueno() {
        this.temperatura = new ArrayList<>();
        this.ruido = new ArrayList<>();
        this.oxigenacion = new ArrayList<>();
    }

    public DatosSueno(Long id, LocalDateTime fechaHora, float duracionSueno, List<Float> temperatura, List<Float> ruido, List<Float> oxigenacion) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.duracionSueno = duracionSueno;
        this.temperatura = temperatura;
        this.ruido = ruido;
        this.oxigenacion = oxigenacion;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getDuracionSueno() {
        return duracionSueno;
    }

    public void setDuracionSueno(float duracionSueno) {
        this.duracionSueno = duracionSueno;
    }

    public List<Float> getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(List<Float> temperatura) {
        this.temperatura = temperatura;
    }

    public List<Float> getRuido() {
        return ruido;
    }

    public void setRuido(List<Float> ruido) {
        this.ruido = ruido;
    }

    public List<Float> getOxigenacion() {
        return oxigenacion;
    }

    public void setOxigenacion(List<Float> oxigenacion) {
        this.oxigenacion = oxigenacion;
    }
}
