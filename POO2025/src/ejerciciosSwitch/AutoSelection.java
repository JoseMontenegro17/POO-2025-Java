/*
Una empresa automotriz necesita un sistema para seleccionar el tipo de carro (auto, SUV o
camioneta) lo cual debe de aparecer en un menú, y el color (negro, blanco o rojo) en otro menú.
Al final se necesita que despliegue la selección realizada. Nota. Debe de anidarse una estructura
de selección múltiple dentro de otra.
 */

package ejerciciosSwitch;
import java.util.Scanner;
public class AutoSelection {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Menú para seleccionar el tipo de auto
            System.out.println("Seleccione el tipo de carro:");
            System.out.println("1. Auto");
            System.out.println("2. SUV");
            System.out.println("3. Camioneta");
            System.out.print("Opción: ");
            int tipoCarro = scanner.nextInt();

            String tipo = "";
            String color = "";

            switch (tipoCarro) {
                case 1:
                    tipo = "Auto";
                    break;
                case 2:
                    tipo = "SUV";
                    break;
                case 3:
                    tipo = "Camioneta";
                    break;
                default:
                    System.out.println("Opción no válida");
                    return;
            }

            // seleccion de color de auto
            System.out.println("\nSeleccione el color del carro:");
            System.out.println("1. Negro");
            System.out.println("2. Blanco");
            System.out.println("3. Rojo");
            System.out.print("Opción: ");
            int colorCarro = scanner.nextInt();

            switch (colorCarro) {
                case 1:
                    color = "Negro";
                    break;
                case 2:
                    color = "Blanco";
                    break;
                case 3:
                    color = "Rojo";
                    break;
                default:
                    System.out.println("Opción no válida");
                    return;
            }

            // Mostrar la selección final
            System.out.println("\nUsted ha seleccionado un " + tipo + " de color " + color + ".");

            scanner.close();
        }
    }


