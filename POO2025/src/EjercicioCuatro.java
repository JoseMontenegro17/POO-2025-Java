/*
Una frutería ofrece las manzanas con descuento según la siguiente tabla:
NUM. DE KILOS COMPRADOS % DESCUENTO
0 - 2 0%
2.01 - 5 10%
5.01 - 10 15%
10.01 en adelante 20%
Determinar cuánto pagara una persona que compre manzanas es esa frutería.
 */
import java.util.Scanner;
public class EjercicioCuatro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                final double PRECIO_POR_KILO = 5.0;


                System.out.print("Ingrese la cantidad de kilos de manzana que desea comprar: ");
                double kilos = scanner.nextDouble();

                // Determinar el porcentaje de descuento
                double descuento = 0;
                if (kilos > 10) {
                    descuento = 0.20; // 20% de descuento
                } else if (kilos > 5) {
                    descuento = 0.15; // 15% de descuento
                } else if (kilos > 2) {
                    descuento = 0.10; // 10% de descuento
                }

                // Calcular el preecio total
                double precioBruto = kilos * PRECIO_POR_KILO;
                double descuentoAplicado = precioBruto * descuento;
                double precioFinal = precioBruto - descuentoAplicado;


                System.out.println("\n----- FACTURA -----");
                System.out.println("Kilos comprados: " + kilos + " kg");
                System.out.println("Precio por kilo: $" + PRECIO_POR_KILO);
                System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
                System.out.println("Total a pagar: $" + precioFinal);

                scanner.close();
            }
        }

