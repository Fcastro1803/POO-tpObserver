package org.example.observer;

public abstract class ObserverDecorator implements TemperaturaObserver {
    protected TemperaturaObserver observerDecorado;

    public ObserverDecorator(TemperaturaObserver observerDecorado) {
        this.observerDecorado = observerDecorado;
    }

    @Override
    public void nuevoRegistro(String temperaturaStr) {
        // Comportamiento por defecto: delegar al objeto interno
        this.observerDecorado.nuevoRegistro(temperaturaStr);
    }
}
