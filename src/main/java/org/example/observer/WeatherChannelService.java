package org.example.observer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class WeatherChannelService implements ClimaOnline {
    @Override
    public String temperatura() {
        String urlApi = "https://api.openweathermap.org/data/2.5/weather?q=Viedma,Argentina&units=metric&APPID=b5f521f693aaae476e78e56235718936";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String jsonResponse = response.body();
                JsonObject respuesta = JsonParser.parseString(jsonResponse).getAsJsonObject();
                double temperatura = respuesta.getAsJsonObject("main").get("temp").getAsDouble();
                return temperatura  + " c";
            } else {
                System.out.println("Error en la petición. Código de estado: " + response.statusCode());
            }

        } catch (Exception e) {
            System.err.println("Ocurrió un error al conectar o parsear: " + e.getMessage());
            e.printStackTrace();
        }

        // por si falla
        return "Error al obtener la temperatura";
    }
}