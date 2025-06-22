package Sesion01_Reto02;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    // Muestra los detalles de cualquier tipo de material
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    // Suma la duración de los videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    // Marca los ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        System.out.println();
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ej = (Ejercicio) obj;
                ej.marcarRevisado();
                System.out.println("✅ Ejercicio '" + ej.titulo + "' marcado como revisado.");
            }
        }
    }

    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();


        materiales.add(new Video("Introducción a Java", "Mario", 15));
        materiales.add(new Video("POO en Java", "Carlos", 20));

        materiales.add(new Articulo("Historia de Java", "Ana", 1200));
        materiales.add(new Articulo("Tipos de datos", "Luis", 800));

        materiales.add(new Ejercicio("Variables y tipos", "Luis"));
        materiales.add(new Ejercicio("Condicionales", "Mario"));

        mostrarMateriales(materiales);

        List<Video> videos = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            }
        }
        contarDuracionVideos(videos);

        marcarEjerciciosRevisados(materiales);

        filtrarPorAutor(materiales, m -> m.getAutor().equalsIgnoreCase("Mario"));
    }

}
