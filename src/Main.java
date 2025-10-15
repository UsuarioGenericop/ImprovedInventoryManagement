import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE INVENTARIO - Comercializadora OliVanders ===");
        int opcion;
        do {
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Mostrar existencias");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Registrar venta");
            System.out.println("7. Mostrar ventas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarProducto();
//                case 2 -> mostrarProductos();
//                case 3 -> mostrarExistencias();
//                case 4 -> modificarProducto();
//                case 5 -> eliminarProducto();
//                case 6 -> registrarVenta();
//                case 7 -> mostrarVentas();
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }
    public static void registrarProducto(){
        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadProductos; i++) {

            String identificacion;
            do {
                System.out.print("Numero de identificacion del producto " + (i + 1) + " : ");
                identificacion = scanner.nextLine().trim();
            } while (identificacion.isEmpty());

            String nombre;
            do {
                System.out.print("Nombre del producto " + (i + 1) + " : ");
                nombre = scanner.nextLine().trim();
            } while (nombre.isEmpty());

            String serie;
            System.out.print("Numero de serie del producto " + (i + 1) + " (opcional) : ");
            serie = scanner.nextLine().trim();

            String valor;
            do {
                System.out.print("Valor del producto " + (i + 1) + " : ");
                valor = scanner.nextLine().trim();
            } while (valor.isEmpty());

            String proveedor;
            do {
                System.out.print("Nombre del proveedor del producto " + (i + 1) + " : ");
                proveedor = scanner.nextLine().trim();
            } while (proveedor.isEmpty());

            String existencias;
            do {
                System.out.print("Existencias del producto " + (i + 1) + " : ");
                existencias = scanner.nextLine();
            } while (existencias.isEmpty());

            productos.add(new Producto(identificacion, nombre, serie, valor, proveedor, existencias));
        }
    }
}