import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();
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
                case 4 -> modificarProducto();
                case 5 -> eliminarProducto();
                case 6 -> registrarVenta();
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
    public static void modificarProducto() {
        System.out.println("\n=== MODIFICAR PRODUCTOS ===");
        System.out.print("Ingrese el ID del producto que desea modificar: ");
        String id = scanner.nextLine();
        for (Producto producto : productos) {
            if (Objects.equals(producto.id, id)) {

                String newId;
                do {
                    System.out.print("Nuevo numero de identificacion del producto " + id + " a ingresar: ");
                    newId = scanner.nextLine().trim();
                    if (!newId.equals(id)) {
                        for (Producto producto2 : productos) {
                            do {
                                for (Producto producto3 : productos) {
                                    if (Objects.equals(producto3.id, newId)) {
                                        System.out.println("Un producto con este ID ya ha sido registrado");
                                        System.out.print("Nuevo numero de identificacion del producto " + id + " : ");
                                        newId = scanner.nextLine().trim();
                                    }
                                }
                            } while (Objects.equals(producto2.id, newId));
                        }
                    }else{System.out.println("Se mantuvo el antiguo id");}
                } while (newId.isEmpty());


                String nombre;
                do {
                    System.out.print("Nuevo nombre del producto " + id + " : ");
                    nombre = scanner.nextLine().trim();
                } while (nombre.isEmpty());

                String serie;
                System.out.print("Nuevo numero de serie del producto " + id + " (opcional): ");
                serie = scanner.nextLine().trim();

                String valor;
                do {
                    System.out.print("Nuevo valor del producto " + id + " : ");
                    valor = scanner.nextLine().trim();
                } while (valor.isEmpty());

                String proveedor;
                do {
                    System.out.print("Nuevo nombre del proveedor del producto " + id + " : ");
                    proveedor = scanner.nextLine().trim();
                } while (proveedor.isEmpty());

                String existencias;
                do {
                    System.out.print("Nuevas existencias del producto " + id + " : ");
                    existencias = scanner.nextLine();
                } while (existencias.isEmpty());

                producto.id = newId;
                producto.nombre = nombre;
                producto.serie = serie;
                producto.valor = valor;
                producto.proveedor = proveedor;
                producto.existencias = existencias;

                System.out.println("Producto modificado correctamente.");
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
    public static void eliminarProducto(){
        System.out.println("\n=== ELIMINAR PRODUCTOS ===");
        System.out.print("Ingrese el ID del producto que desea eliminar: ");
        String id = scanner.nextLine();
        for (Producto producto : productos) {
            if (Objects.equals(producto.id, id)) {
                productos.remove(producto);
                System.out.println("Producto eliminado correctamente.");
                cantidadProductos--;
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }
    public static void registrarVenta(){
        System.out.println("\n=== REGISTRAR VENTAS ===");
        System.out.print("Ingrese la cantidad de productos a vender: ");
        String cantidadProductosVenta = scanner.nextLine();
        scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(cantidadProductosVenta.trim()); i++) {
            System.out.print("Ingrese el ID del producto " + (i + 1) + " que desea vender: ");
            String id = scanner.nextLine();
            for (Producto producto : productos) {
                if (Objects.equals(producto.id, id)) {
                    System.out.print("Ingrese la cantidad del producto " + producto.nombre +  " que desea vender: ");
                    String cantidadVenta = scanner.nextLine();
                        if (Integer.parseInt(cantidadVenta.trim()) > Integer.parseInt(producto.existencias.trim())){
                            System.out.print("No hay sufucientes existencias del producto " + producto.nombre + " para vender: ");
                        }else {
                            int newExistencias = Integer.parseInt(producto.existencias.trim()) - Integer.parseInt(cantidadVenta.trim());
                            producto.existencias = String.valueOf(newExistencias);
                        }
                    return;
                }

            }System.out.println("Producto no encontrado.");
        }
    }


}