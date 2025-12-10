package SmartWeb.demo.model;

import jakarta.persistence.*;

import java.util.Arrays;

public class DatosSueño {

    private int id;
    private float duracionSueño;
    private float [] temperatura;
    private float [] ruido;
    private float [] oxigenacion;


    public DatosSueño(){
    }

    public DatosSueño(int id, float duracionSueño, float[] temperatura, float[] ruido, float[] oxigenacion) {
        this.id = id;
        this.duracionSueño = duracionSueño;
        this.temperatura = temperatura;
        this.ruido = ruido;
        this.oxigenacion = oxigenacion;
    }

    public float getDuracionSueño() {
        return duracionSueño;
    }

    public void setDuracionSueño(float duracionSueño) {
        this.duracionSueño = duracionSueño;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float[] getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float[] temperatura) {
        this.temperatura = temperatura;
    }

    public float[] getRuido() {
        return ruido;
    }

    public void setRuido(float[] ruido) {
        this.ruido = ruido;
    }

    public float[] getOxigenacion() {
        return oxigenacion;
    }

    public void setOxigenacion(float[] oxigenacion) {
        this.oxigenacion = oxigenacion;
    }

    @Override
    public String toString() {
        return "DatosSueño{" +
                "id=" + id +
                ", duracionSueño=" + duracionSueño +
                ", temperatura=" + Arrays.toString(temperatura) +
                ", ruido=" + Arrays.toString(ruido) +
                ", oxigenacion=" + Arrays.toString(oxigenacion) +
                '}';
    }
}
