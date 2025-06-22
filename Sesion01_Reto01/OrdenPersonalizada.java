package Sesion01_Reto01;

public class OrdenPersonalizada extends OrdenProduccion{

    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente);
    }

    public void agregarCosto(int costoAdicional) {
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costoAdicional);
    }

}
