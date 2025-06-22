package Sesion02_Reto01;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> nav = executor.submit(new SistemaNavegacion());
        Future<String> soporte = executor.submit(new SistemaSoporteVital());
        Future<String> termico = executor.submit(new SistemaControlTermico());
        Future<String> comunicacion = executor.submit(new SistemaComunicaciones());

        try {
            System.out.println(comunicacion.get());
            System.out.println(soporte.get());
            System.out.println(termico.get());
            System.out.println(nav.get());

            System.out.println("✅ Todos los sistemas reportan estado operativo.");

        } catch (InterruptedException | ExecutionException e) {

            System.err.println("❌ Error durante la simulación: " + e.getMessage());
            
        } finally {
            executor.shutdown(); 
        }
    }

}
