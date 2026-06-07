package org.example.observer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogArchivoObserver implements TemperaturaObserver {
    private File archivoLog;

    public LogArchivoObserver(String rutaArchivo) {
        this.archivoLog = new File(rutaArchivo);
    }

    @Override
    public void nuevoRegistro(String temperatura) {
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        String lineaLog = "[" + fechaHora + "] Temperatura: " + temperatura;
        try (FileWriter writer = new FileWriter(archivoLog, true)) {
            writer.write(lineaLog + System.lineSeparator());
            System.out.println("[Archivo] Se guardó la lectura en el log con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir el log en archivo: " + e.getMessage());
        }
    }
}
