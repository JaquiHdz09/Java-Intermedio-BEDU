package Sesion01_Reto01;

 import java.util.*;
 
public class Main {


    // Método genérico que muestra cualquier tipo de orden
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    // Método que procesa las órdenes personalizadas
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                ((OrdenPersonalizada) obj).agregarCosto(costoAdicional);
            }
        }
    }

    // Desafío adicional
    public static void mostrarResumenTotal(List<OrdenMasa> masa, List<OrdenPersonalizada> personalizadas, List<OrdenPrototipo> prototipos) {
        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa.size());
        System.out.println("🛠️ Personalizadas: " + personalizadas.size());
        System.out.println("🧪 Prototipos: " + prototipos.size());
    }

    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        System.out.println("📋 Órdenes registradas:");
        mostrarOrdenes(ordenesMasa);

        System.out.println("\n📋 Órdenes registradas:");
        mostrarOrdenes(ordenesPersonalizadas);

        System.out.println("\n📋 Órdenes registradas:");
        mostrarOrdenes(ordenesPrototipo);

        procesarPersonalizadas(ordenesPersonalizadas, 200);

        mostrarResumenTotal(ordenesMasa, ordenesPersonalizadas, ordenesPrototipo);
    }

}
