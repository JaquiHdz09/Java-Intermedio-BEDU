package Sesion04_Reto02;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AeropuertoControl {
    private final Random random = new Random();

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2000);
            boolean disponible = random.nextDouble() < 0.80;
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        });
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2500);
            boolean favorable = random.nextDouble() < 0.85;
            System.out.println("🌦️ Clima favorable: " + favorable);
            return favorable;
        });
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2300);
            boolean despejado = random.nextDouble() < 0.90;
            System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
            return despejado;
        });
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            esperar(2100);
            boolean disponible = random.nextDouble() < 0.95;
            System.out.println("👷‍♂️ Personal disponible: " + disponible);
            return disponible;
        });
    }

    private void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException("Error al esperar");
        }
    }

}
