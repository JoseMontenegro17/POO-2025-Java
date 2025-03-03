package EjerciciosEstructurasRepetitivas;
import java.util.Scanner;
public class ClinicaMateernidad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de nacimientos: ");
        int cantidadNacimientos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        int masculinos = 0, femeninos = 0;

        // Vamos a capturar los datos de los bb
        for (int i = 1; i <= cantidadNacimientos; i++) {
            System.out.print("Ingrese el nombre del bebé " + i + ": ");
            String nombre = scanner.nextLine();

            char sexo;
            do {
                System.out.print("Ingrese el sexo del bebé (M para masculino, F para femenino): ");
                sexo = scanner.next().toUpperCase().charAt(0);
                scanner.nextLine(); // Consumir el salto de línea

                if (sexo != 'M' && sexo != 'F') {
                    System.out.println("Entrada inválida. Por favor, ingrese 'M' o 'F'.");
                }
            } while (sexo != 'M' && sexo != 'F');

            // Contar bebés según su sexo
            if (sexo == 'M') {
                masculinos++;
            } else {
                femeninos++;
            }
        }

        
        System.out.println("\nResumen de nacimientos:");
        System.out.println("Bebés masculinos: " + masculinos);
        System.out.println("Bebés femeninos: " + femeninos);

        scanner.close();
    }
    /*
    Una clínica de maternidad necesita un sistema para determinar cuántos bebés han nacido
recientemente. Dicho sistema solicita al usuario capturar la cantidad de nacimientos (N), el
nombre de cada bebé y su sexo (implemente un ciclo do-while para validar la captura, siendo M

para masculino y F para femenino). Al final, debe imprimir la cantidad de bebés de cada sexo.
     */
}
