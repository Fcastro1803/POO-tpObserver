package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class Medidor {
    private String temperatura;
    private ClimaOnline clima;

    // 1. La lista de observadores
    private List<TemperaturaObserver> observadores;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
        this.observadores = new ArrayList<>();
    }

    // 2. Métodos para que los observadores se suscriban
    public void registrarObserver(TemperaturaObserver obs) {
        this.observadores.add(obs);
    }

    public String leerTemperatura() {
        //leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();

        //Le avisamos a todos los que estén mirando
        this.notificarObservadores(this.temperatura);

        return this.temperatura;
    }

    private void notificarObservadores(String temp) {
        for (TemperaturaObserver obs : this.observadores) {
            obs.nuevoRegistro(temp); // Polimorfismo
        }
    }

}
