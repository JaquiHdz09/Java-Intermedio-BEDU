package Sesion04_Reto02;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = control.verificarPista();
        CompletableFuture<Boolean> clima = control.verificarClima();
        CompletableFuture<Boolean> trafico = control.verificarTraficoAereo();
        CompletableFuture<Boolean> personal = control.verificarPersonalTierra();

        CompletableFuture<Void> todas = CompletableFuture.allOf(pista, clima, trafico, personal);

        todas.thenRun(() -> {
            try {
                boolean resultadoFinal =
                        pista.get() &&
                        clima.get() &&
                        trafico.get() &&
                        personal.get();

                if (resultadoFinal) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }

            } catch (InterruptedException | ExecutionException e) {
                System.out.println("\n❌ Error al obtener resultados: " + e.getMessage());
            }
        }).exceptionally(ex -> {
            System.out.println("\n❌ Error en verificación: " + ex.getMessage());
            return null;
        });

        try {
            Thread.sleep(4000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


