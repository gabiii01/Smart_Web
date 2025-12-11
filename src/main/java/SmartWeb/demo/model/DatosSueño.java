package SmartWeb.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "datos_sueno")
public class DatosSueño {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float duracionSueño;

    @ElementCollection
    private List<Float> temperatura;

    @ElementCollection
    private List<Float> ruido;

    @ElementCollection
    private List<Float> oxigenacion;

    public DatosSueño() {}

    public DatosSueño(Long id, float duracionSueño, List<Float> temperatura, List<Float> ruido, List<Float> oxigenacion) {
        this.id = id;
        this.duracionSueño = duracionSueño;
        this.temperatura = temperatura;
        this.ruido = ruido;
        this.oxigenacion = oxigenacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getDuracionSueño() {
        return duracionSueño;
    }

    public void setDuracionSueño(float duracionSueño) {
        this.duracionSueño = duracionSueño;
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
