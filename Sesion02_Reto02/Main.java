package Sesion02_Reto02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        String[] nombres = {
            "Dra. Sánchez",
            "Dr. Gómez",
            "Enfermera López",
            "Dra. Ruíz",
        };

        for (String nombre : nombres) {
            executor.execute(new ProfesionalMedico(nombre, salaCirugia));
        }

        executor.shutdown(); 
    }

}


