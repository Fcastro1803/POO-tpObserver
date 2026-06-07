package org.example.observer;

public class Main {
    static void main(String[] args) {

        // 1. Instanciamos el servicio real de Weather Channel para Viedma
        ClimaOnline servicioWeather = new WeatherChannelService();
        Medidor medidor = new Medidor(servicioWeather);

        TemperaturaObserver logger = new LogArchivoObserver("temperaturas_viedma.txt");

        TemperaturaObserver consolaBase = new ConsolaClimaObserver();
        TemperaturaObserver consolaInteligente = new ClimatizadorDecorator(consolaBase);

        // 4. Suscribimos los observadores al medidor
        medidor.registrarObserver(logger);
        medidor.registrarObserver(consolaInteligente);

        // 5. Ejecucion
        System.out.println("=== Ejecutando lectura con Observer + Decorador ===");
        medidor.leerTemperatura();
    }
}
