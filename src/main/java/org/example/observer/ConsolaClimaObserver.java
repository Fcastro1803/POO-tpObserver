package org.example.observer;

public class ConsolaClimaObserver implements TemperaturaObserver {
    @Override
    public void nuevoRegistro(String temperaturaStr) {
        System.out.println("[Consola] Temperatura leída: " + temperaturaStr);
    }
}
