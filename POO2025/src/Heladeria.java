import java.util.Scanner;
public class Heladeria {
    public static void main(String[] args) {
                Scanner entrada = new Scanner(System.in);

                // Precios de cada sabor
                int precioLimon = 2500, precioNuez = 2800, precioLulo = 2600, precioFresa = 2000, precioCrema = 3000;

                // Contadores de paletas vendidas y montos por sabor
                int totalLimon = 0, totalNuez = 0, totalLulo = 0, totalFresa = 0, totalCrema = 0;
                int ventasLimon = 0, ventasNuez = 0, ventasLulo = 0, ventasFresa = 0, ventasCrema = 0;

                int facturas = 0;
                boolean continuar = true;

                while (continuar) {
                    facturas++;
                    System.out.println("\n*** Factura No " + facturas + " ***");
                    boolean agregarMas = true;

                    while (agregarMas) {
                        // Mostrar menú
                        System.out.println("\nMenú de paletas:");
                        System.out.println("1. Limón ($2500)");
                        System.out.println("2. Nuez ($2800)");
                        System.out.println("3. Lulo ($2600)");
                        System.out.println("4. Fresa ($2000)");
                        System.out.println("5. Crema ($3000)");
                        System.out.print("Seleccione el número del sabor: ");
                        int seleccion = entrada.nextInt();

                        System.out.print("Ingrese la cantidad de paletas: ");
                        int cantidad = entrada.nextInt();

                        // Procesar la selección con condicionales
                        if (seleccion == 1) {
                            totalLimon += cantidad;
                            ventasLimon += cantidad * precioLimon;
                        } else if (seleccion == 2) {
                            totalNuez += cantidad;
                            ventasNuez += cantidad * precioNuez;
                        } else if (seleccion == 3) {
                            totalLulo += cantidad;
                            ventasLulo += cantidad * precioLulo;
                        } else if (seleccion == 4) {
                            totalFresa += cantidad;
                            ventasFresa += cantidad * precioFresa;
                        } else if (seleccion == 5) {
                            totalCrema += cantidad;
                            ventasCrema += cantidad * precioCrema;
                        } else {
                            System.out.println("Selección inválida. Intente de nuevo.");
                            continue;
                        }

                        System.out.print("¿Desea agregar otro sabor a esta factura? (1: Sí, 2: No): ");
                        if (entrada.hasNextInt()) { // Verifica que haya ingresado un número
                            agregarMas = entrada.nextInt() == 1;
                        } else {
                            System.out.println("Entrada inválida. Se asumirá que no desea agregar más.");
                            agregarMas = false;
                            entrada.next(); // Limpia la entrada incorrecta
                        }

                    }

                    System.out.print("¿Desea hacer otra factura? (1: Sí, 2: No): ");
                    int opcionFactura = entrada.nextInt();
                    if (opcionFactura != 1) {
                        continuar = false;
                    }
                }

                // Mostrar reporte final
                int totalVenta = ventasLimon + ventasNuez + ventasLulo + ventasFresa + ventasCrema;

                System.out.println("\n******** Reporte Semanal de Ventas ********");
                System.out.println("Total de paletas vendidas:");
                System.out.println("Limón: " + totalLimon + " ($" + ventasLimon + ")");
                System.out.println("Nuez: " + totalNuez + " ($" + ventasNuez + ")");
                System.out.println("Lulo: " + totalLulo + " ($" + ventasLulo + ")");
                System.out.println("Fresa: " + totalFresa + " ($" + ventasFresa + ")");
                System.out.println("Crema: " + totalCrema + " ($" + ventasCrema + ")");
                System.out.println("Venta total de la semana: $" + totalVenta);
                System.out.println("Número total de facturas generadas: " + facturas);

                System.out.println("\n¡Gracias por usar el sistema!");
                entrada.close();
            }
        }


