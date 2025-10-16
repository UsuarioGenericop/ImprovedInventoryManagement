import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();
    static int cantidadProductos;

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE INVENTARIO - Comercializadora OliVanders ===");
        int opcion;
        do {
            System.out.println("\n1. Registrar producto");
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
                case 2 -> mostrarProductos();
                case 3 -> mostrarExistencias();
//                case 4 -> modificarProducto();
//                case 5 -> eliminarProducto();
//                case 6 -> registrarVenta();
//                case 7 -> mostrarVentas();
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 8);
    }

    public static void registrarProducto() {
        System.out.println("\n=== REGISTRAR PRODUCTOS ===");
        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int cantidadProductosIngreso = scanner.nextInt();
        scanner.nextLine();
        cantidadProductos += cantidadProductosIngreso;
        for (int i = 0; i < cantidadProductosIngreso; i++) {

            String id;
            do {
                System.out.print("Numero de identificacion del producto " + (i + 1) + " a ingresar: ");
                id = scanner.nextLine().trim();
                for (Producto producto : productos) {
                    do {
                        for (Producto producto2 : productos) {
                            if (Objects.equals(producto2.id, id)) {
                                System.out.println("Un producto con este ID ya ha sido registrado");
                                System.out.print("Numero de identificacion del producto " + (i + 1) + " a ingresar: ");
                                id = scanner.nextLine().trim();
                            }
                        }
                    } while (Objects.equals(producto.id, id));
                }
            } while (id.isEmpty());

            String nombre;
            do {
                System.out.print("Nombre del producto " + (i + 1) + " a ingresar: ");
                nombre = scanner.nextLine().trim();
            } while (nombre.isEmpty());

            String serie;
            System.out.print("Numero de serie del producto " + (i + 1) + " a ingresar (opcional): ");
            serie = scanner.nextLine().trim();

            String valor;
            do {
                System.out.print("Valor del producto " + (i + 1) + " a ingresar: ");
                valor = scanner.nextLine().trim();
            } while (valor.isEmpty());

            String proveedor;
            do {
                System.out.print("Nombre del proveedor del producto " + (i + 1) + " a ingresar: ");
                proveedor = scanner.nextLine().trim();
            } while (proveedor.isEmpty());

            String existencias;
            do {
                System.out.print("Existencias del producto " + (i + 1) + " a ingresar: ");
                existencias = scanner.nextLine();
            } while (existencias.isEmpty());

            productos.add(new Producto(id, nombre, serie, valor, proveedor, existencias));
        }
    }

    public static void mostrarProductos() {
        System.out.println("\n=== LISTADO COMPLETO DE PRODUCTOS ===");
        System.out.printf("%-15s %-20s %-15s %-10s %-20s\n", "ID", "Nombre", "Serie", "Valor", "Proveedor");
        System.out.println("-------------------------------------------------------------------------------");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.printf("%-15s %-20s %-15s %-10s %-20s\n", productos.get(i).returnId(), productos.get(i).returnNombre()
                    , productos.get(i).returnSerie(), productos.get(i).returnValor(), productos.get(i).returnProveedor());
        }
    }

    public static void mostrarExistencias() {
        System.out.println("\n=== LISTADO COMPLETO DE EXISTENCIAS ===");
        System.out.printf("%-20s %-15s %-10s\n", "Nombre del producto", "Identificación", "Cantidad");
        System.out.println("-------------------------------------------------------------------------------");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.printf("%-20s %-15s %-10s\n",
                    productos.get(i).returnNombre(), productos.get(i).returnId(), productos.get(i).returnExistencias());
        }
    }


}