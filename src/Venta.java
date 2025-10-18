import java.util.ArrayList;

public class Venta {
    int numeroFactura;
    ArrayList<String> cantidadVendidaProducto;
    ArrayList<Producto> productosVendidosDetalle;
    String valorTotal;

    public Venta(int numeroFactura, String valorTotal, ArrayList<Producto> productosVendidosDetalle , ArrayList<String> cantidadVendidaProducto) {
        this.numeroFactura = numeroFactura;
        this.valorTotal = valorTotal;
        this.productosVendidosDetalle = productosVendidosDetalle;
        this.cantidadVendidaProducto = cantidadVendidaProducto;
    }
}
