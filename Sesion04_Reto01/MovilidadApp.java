package Sesion04_Reto01;

import java.util.concurrent.*;
import java.util.Random;

public class MovilidadApp {

    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                Thread.sleep(2000 + new Random().nextInt(1000));
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al calcular la ruta");
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                Thread.sleep(1000 + new Random().nextInt(1000));
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al estimar la tarifa");
            }
        });
    }

    public void procesarSolicitud() {
        calcularRuta()
            .thenCombine(estimarTarifa(), (ruta, tarifa) ->
                "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa
            )
            .exceptionally(ex -> "❌ Ocurrió un error durante el proceso: " + ex.getMessage())
            .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        Thread.sleep(4000);
    }

}
