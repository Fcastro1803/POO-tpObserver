package org.example.observer;

public class Main {
    static void main(String[] args) {

        // 1. Instanciamos el servicio real de Weather Channel para Viedma
        ClimaOnline servicioWeather = new WeatherChannelService();

        // 2. Creamos nuestro Medidor
        Medidor medidor = new Medidor(servicioWeather);

        // 3. Creamos los dos observadores independientes
        TemperaturaObserver logger = new LogArchivoObserver("temperaturas_viedma.txt");
        TemperaturaObserver consolaInteligente = new ConsolaClimaObserver();

        // 4. Suscribimos los observadores al medidor
        medidor.registrarObserver(logger);
        medidor.registrarObserver(consolaInteligente);

        // 5. Ejecucion
        System.out.println("=== Gatillando lectura del sensor ===");
        medidor.leerTemperatura();
    }
}
