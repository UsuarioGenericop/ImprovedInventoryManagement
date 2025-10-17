import java.util.ArrayList;

public class Venta {
    int numeroFactura;
    ArrayList<String> productosVendidos;
    ArrayList<Producto> productosVendidosDetalle;
    String valorTotal;

    public Venta(int numeroFactura, ArrayList<String> productosVendidos, String valorTotal , ArrayList<Producto> productosVendidosDetalle) {
        this.numeroFactura = numeroFactura;
        this.productosVendidos = productosVendidos;
        this.valorTotal = valorTotal;
        this.productosVendidosDetalle = productosVendidosDetalle;
    }
}
