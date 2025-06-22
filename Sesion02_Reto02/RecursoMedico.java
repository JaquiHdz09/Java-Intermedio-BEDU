package Sesion02_Reto02;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println("🔄 " + profesional + " está intentando acceder a " + nombre + "...");
        lock.lock();
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000);
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.err.println("⚠️ " + profesional + " fue interrumpido.");
        } finally {
            lock.unlock();
        }
    }

}
