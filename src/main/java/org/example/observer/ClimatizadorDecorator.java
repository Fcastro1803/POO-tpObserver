package org.example.observer;

public class ClimatizadorDecorator extends ObserverDecorator {

    public ClimatizadorDecorator(TemperaturaObserver observerDecorado) {
        super(observerDecorado);
    }

    @Override
    public void nuevoRegistro(String temperaturaStr) {
        super.nuevoRegistro(temperaturaStr);

        try {
            String limpio = temperaturaStr.replace(" c", "").trim();
            double temp = Double.parseDouble(limpio);

            if (temp < 12.0) {
                System.out.println("-> [Alerta Decorador] Hace frío, se encenderá la caldera.");
            } else if (temp > 17.0) {
                System.out.println("-> [Alerta Decorador] Hace calor, se encenderá el aire acondicionado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("-> [Alerta Decorador] Error al procesar formato numérico.");
        }
    }
}
