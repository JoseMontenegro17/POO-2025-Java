import  java.util.Scanner;
public class ClasifacionJubalacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar edad y antigüedad
        System.out.print("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese la antigüedad en el empleo (en años): ");
        int antiguedad = scanner.nextInt();

        // Determinar tipo de jubilación
        if (edad >= 60 && antiguedad < 25) {
            System.out.println("La persona se jubila por edad.");
        } else if (edad < 60 && antiguedad >= 25) {
            System.out.println("La persona se jubila por antigüedad joven.");
        } else if (edad >= 60 && antiguedad >= 25) {
            System.out.println("La persona se jubila por antigüedad adulta.");
        } else {
            System.out.println("La persona no cumple con los requisitos para jubilarse en 2004.");
        }

        scanner.close();
    }
}

