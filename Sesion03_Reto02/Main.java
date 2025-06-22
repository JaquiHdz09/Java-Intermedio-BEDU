package Sesion03_Reto02;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Encuesta> centroEncuestas = Arrays.asList(
            new Encuesta("Ana", "El tiempo de espera fue largo", 2),
            new Encuesta("Luis", null, 4),
            new Encuesta("Carlos", null, 3)
        );

        List<Encuesta> norteEncuestas = Arrays.asList(
            new Encuesta("Marta", "La atención fue buena, pero la limpieza puede mejorar", 3),
            new Encuesta("Pedro", null, 2),
            new Encuesta("Lucía", "Faltaban insumos", 5)
        );

        List<Sucursal> sucursales = Arrays.asList(
            new Sucursal("Centro", centroEncuestas),
            new Sucursal("Norte", norteEncuestas)
        );

        List<String> mensajesSeguimiento = sucursales.stream()
            .flatMap(sucursal ->
                sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .flatMap(encuesta -> encuesta.getComentario()
                        .map(comentario -> Stream.of("Sucursal " + sucursal.getNombre()
                                + ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
                        .orElseGet(Stream::empty))
            )
            .collect(Collectors.toList());

        mensajesSeguimiento.forEach(System.out::println);
    }

}

