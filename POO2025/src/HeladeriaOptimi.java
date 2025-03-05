import java.util.Scanner;

public class HeladeriaOptimi {  // Manteniendo el nombre que diste

    static Scanner entrada = new Scanner(System.in);
    static final int[] precios = {2500, 2800, 2600, 2000, 3000};
    static final String[] sabores = {"Limón", "Nuez", "Lulo", "Fresa", "Crema"};
    static int[] cantidadVendida = new int[5]; // Almacena la cantidad total vendida de cada sabor
    static int totalVentas = 0;

    public static void main(String[] args) {
        boolean continuar = true;
        int numFactura = 1;

        while (continuar) {
            System.out.println("\n*** Factura No " + numFactura + " ***");
            procesarFactura();
            continuar = preguntar("¿Desea ingresar otra factura? (1: Sí, 2: No): ");
            numFactura++;
        }

        mostrarResultados();
        System.out.println("\nGracias por usar el sistema de facturación de la heladería. 😊");
    }

    static void procesarFactura() {
        boolean agregarMas;
        do {
            int sabor = seleccionarSabor();
            int cantidad = obtenerCantidad();
            cantidadVendida[sabor] += cantidad;
            totalVentas += cantidad * precios[sabor];

            agregarMas = preguntar("¿Desea agregar otro sabor a esta factura? (1: Sí, 2: No): ");
        } while (agregarMas);
    }

    static int seleccionarSabor() {
        System.out.println("\nMenú de paletas:");
        for (int i = 0; i < sabores.length; i++) {
            System.out.println((i + 1) + ". " + sabores[i] + " ($" + precios[i] + ")");
        }

        int seleccion;
        do {
            System.out.print("Seleccione el número del sabor: ");
            while (!entrada.hasNextInt()) {
                System.out.print("Entrada inválida. Seleccione un número del 1 al 5: ");
                entrada.next();
            }
            seleccion = entrada.nextInt();
        } while (seleccion < 1 || seleccion > 5);

        return seleccion - 1; // Ajusta el índice al array
    }

    static int obtenerCantidad() {
        int cantidad;
        do {
            System.out.print("Ingrese la cantidad de paletas: ");
            while (!entrada.hasNextInt()) {
                System.out.print("Entrada inválida. Ingrese un número válido: ");
                entrada.next();
            }
            cantidad = entrada.nextInt();
        } while (cantidad <= 0);

        return cantidad;
    }

    static boolean preguntar(String mensaje) {
        System.out.print(mensaje);
        while (!entrada.hasNextInt()) {
            System.out.print("Entrada inválida. Ingrese 1 para Sí o 2 para No: ");
            entrada.next();
        }
        return entrada.nextInt() == 1;
    }

    static void mostrarResultados() {
        System.out.println("\n📊 *** Reporte de Ventas ***");
        int totalPaletas = 0;
        for (int i = 0; i < sabores.length; i++) {
            System.out.println(sabores[i] + ": " + cantidadVendida[i] + " paletas vendidas ($" + (cantidadVendida[i] * precios[i]) + ")");
            totalPaletas += cantidadVendida[i];
        }
        System.out.println("🔹 Total de paletas vendidas: " + totalPaletas);
        System.out.println("💰 Venta total: $" + totalVentas);
    }
}
