package org.example.observer;

public class ConsolaClimaObserver implements TemperaturaObserver {
    @Override
    public void nuevoRegistro(String temperaturaStr) {
        System.out.println("[Consola] Temperatura leída: " + temperaturaStr);

        try {
            // Limpiamos el " c" que devuelve WeatherChannelService para parsearlo a double
            String limpio = temperaturaStr.replace(" c", "").trim();
            double temp = Double.parseDouble(limpio);

            if (temp < 12.0) {
                System.out.println("-> Hace frío, se encenderá la caldera.");
            } else if (temp > 17.0) {
                System.out.println("-> Hace calor, se encenderá el aire acondicionado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("-> No se pudo evaluar el clima por formato inválido.");
        }
    }
}
