package Sesion03_Reto01;

import java.util.*;
import java.util.stream.*;

public class Confirmacion {
   
    public static void main(String[] args) {

        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Carla", "domicilio", "555-1234"),
            new Pedido("Ana", "local", null),
            new Pedido("Luna", "domicilio", null),
            new Pedido("Juan", "domicilio", "555-5678"),
            new Pedido("Marta", "local", "555-0000"),
            new Pedido("Elena", "domicilio", "555-1111")
        );

        List<String> mensajes = pedidos.stream()
            .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
            .map(Pedido::getTelefono)             
            .flatMap(Optional::stream)            
            .map(tel -> "📞 Confirmación enviada al número: " + tel)
            .collect(Collectors.toList());

        mensajes.forEach(System.out::println);
    }

}


