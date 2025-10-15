import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA DE INVENTARIO - Comercializadora OliVanders ===");
        System.out.print("Ingrese la cantidad de productos a registrar: ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine();

        String[] productos = new String[cantidadProductos];
        String[][] especificaciones = new String[cantidadProductos][5];
        String[][] existencias = new String[cantidadProductos][2];

        for (int i = 0; i < cantidadProductos; i++) {

            do {
                System.out.print("Numero de identificacion del producto " + (i + 1) + " : ");
                especificaciones[i][0] = scanner.nextLine().trim();
            } while (especificaciones[i][0].isEmpty());
            do {
                System.out.print("Nombre del producto " + (i + 1) + " : ");
                especificaciones[i][1] = scanner.nextLine().trim();
                productos[i] = especificaciones[i][1];
            } while (especificaciones[i][1].isEmpty());

            System.out.print("Numero de serie del producto " + (i + 1) + " (opcional) : ");
            especificaciones[i][2] = scanner.nextLine().trim();
            do {
                System.out.print("Valor del producto " + (i + 1) + " : ");
                especificaciones[i][3] = scanner.nextLine().trim();
            } while (especificaciones[i][3].isEmpty());

            do {
                System.out.print("Nombre del proveedor del producto " + (i + 1) + " : ");
                especificaciones[i][4] = scanner.nextLine().trim();
            } while (especificaciones[i][4].isEmpty());

            do {
                System.out.print("Existencias del producto " + (i + 1) + " : ");
                String existenciasPresentes = scanner.nextLine();
                existencias[i][0] = especificaciones[i][1];
                existencias[i][1]= existenciasPresentes;
            } while (especificaciones[i][4].isEmpty());
        }
        System.out.println("\n=== LISTADO COMPLETO DE PRODUCTOS ===");
        System.out.printf("%-15s %-20s %-15s %-10s %-20s\n", "ID", "Nombre", "Serie", "Valor", "Proveedor");
        System.out.println("-------------------------------------------------------------------------------");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.printf("%-15s %-20s %-15s %-10s %-20s\n",
                    especificaciones[i][0], especificaciones[i][1], especificaciones[i][2],
                    especificaciones[i][3], especificaciones[i][4]);
        }

        System.out.println("\n=== EXISTENCIAS DE PRODUCTOS ===");
        System.out.printf("%-20s %-15s %-10s\n", "Nombre del producto", "Identificación", "Cantidad");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < cantidadProductos; i++) {
            System.out.printf("%-20s %-15s %-10s\n",
                    existencias[i][0], especificaciones[i][0], existencias[i][1]);
        }
        System.out.println("\n=== LISTADO DE PRODUCTOS ===");
        for (int i = 0; i < productos.length; i++)
        {
            System.out.println("⚫ " + productos[i]);}
        scanner.close();
    }
}