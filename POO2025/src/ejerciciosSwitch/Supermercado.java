package ejerciciosSwitch;
import java.util.Scanner;
public class Supermercado {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar genero
            System.out.println("Ingrese su género (H para hombre, M para mujer): ");
            char genero = scanner.next().toUpperCase().charAt(0);

            // Validar genero
            if (genero != 'H' && genero != 'M') {
                System.out.println("Entrada inválida. Debe ingresar H o M.");
                return;
            }

            // Solicitar numero de la balita
            System.out.println("Ingrese el número de la bolita (1-5): ");
            int numeroBolita = scanner.nextInt();

            // Validar número de bolita
            if (numeroBolita < 1 || numeroBolita > 5) {
                System.out.println("Número de bolita inválido. Debe estar entre 1 y 5.");
                return;
            }

            // Determinar premio hacendo uso del switch
            String premio = "";

            switch (genero) {
                case 'H':
                    switch (numeroBolita) {
                        case 1: premio = "Desodorante"; break;
                        case 2: premio = "Six-Pack de cerveza"; break;
                        case 3: premio = "Camiseta"; break;
                        case 4: premio = "Pantaloneta"; break;
                        case 5: premio = "Sudadera"; break;
                    }
                    break;
                case 'M':
                    switch (numeroBolita) {
                        case 1: premio = "Loción"; break;
                        case 2: premio = "Bikini"; break;
                        case 3: premio = "Crema para la cara"; break;
                        case 4: premio = "Plancha para el cabello"; break;
                        case 5: premio = "Esmalte de uñas"; break;
                    }
                    break;
            }

            // Mostrar premio
            System.out.println("¡Felicidades! Su premio es: " + premio);
            scanner.close();
        }
    }

}
