import java.util.ArrayList;

public class Venta {
    int numeroFactura;
    ArrayList<Producto> productosVendidos;
    double valorTotal;

    public Venta(int numeroFactura, ArrayList<Producto> productosVendidos, double valorTotal) {
        this.numeroFactura = numeroFactura;
        this.productosVendidos = productosVendidos;
        this.valorTotal = valorTotal;
    }
}
