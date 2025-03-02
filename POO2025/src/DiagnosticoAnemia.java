import java.util.Scanner;

/*
 Tomando como base los resultados obtenidos en un laboratorio de análisis clínicos, un médico
determina si una persona tiene anemia o no, lo cual depende de su nivel de hemoglobina en la
sangre, de su edad y de su sexo. Si el nivel de hemoglobina que tiene una persona es menor
que el rango que le corresponde, se determina su resultado como positivo y en caso contrario
como negativo. La tabla en la que el medico se basa para obtener el resultado es la siguiente:

EDAD NIVEL HEMOGLOBINA
0 - 1 mes 13 - 26 g%
> 1 y < = 6 meses 10 - 18 g%
> 6 y < = 12 meses 11 - 15 g%
> 1 y < = 5 años 11.5 - 15 g%
> 5 y < = 10 años 12.6 - 15.5 g%
> 10 y < = 15 años 13 - 15.5 g%
Mujeres > 15 años 12 - 16 g%
Hombres > 15 años 14 - 18 g%
 */
public class DiagnosticoAnemia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese la edad en años: ");
        double edad = scanner.nextDouble();
        System.out.print("Ingrese el nivel de hemoglobina (g%): ");
        double hemoglobina = scanner.nextDouble();

        String sexo = "";
        if (edad > 15) {
            System.out.print("Ingrese el sexo (M para masculino, F para femenino): ");
            sexo = scanner.next().toUpperCase();
        }

        // Determinar los valores normales según la edad y el sexo
        double minNivel = 0, maxNivel = 0;

        if (edad >= 0 && edad <= 1.0 / 12) {
            minNivel = 13; maxNivel = 26;
        } else if (edad > 1.0 / 12 && edad <= 0.5) {
            minNivel = 10; maxNivel = 18;
        } else if (edad > 0.5 && edad <= 1) {
            minNivel = 11; maxNivel = 15;
        } else if (edad > 1 && edad <= 5) {
            minNivel = 11.5; maxNivel = 15;
        } else if (edad > 5 && edad <= 10) {
            minNivel = 12.6; maxNivel = 15.5;
        } else if (edad > 10 && edad <= 15) {
            minNivel = 13; maxNivel = 15.5;
        } else if (edad > 15 && sexo.equals("F")) {
            minNivel = 12; maxNivel = 16;
        } else if (edad > 15 && sexo.equals("M")) {
            minNivel = 14; maxNivel = 18;
        } else {
            System.out.println("Edad o sexo no válidos.");
            scanner.close();
            return;
        }

        // Evaluar si la persona tiene anemia
        if (hemoglobina < minNivel) {
            System.out.println("Resultado: Positivo para anemia.");
        } else {
            System.out.println("Resultado: Negativo para anemia.");
        }

        scanner.close();
    }
}
