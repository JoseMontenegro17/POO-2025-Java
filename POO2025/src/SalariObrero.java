import java.util.Scanner;
public class SalariObrero {

    /*
    Un obrero necesita calcular su salario semanal, el cual se obtiene de la sig. manera:
• Si trabaja 40 horas o menos se le paga $5000 por hora
• Si trabaja más de 40 horas se le paga $5000 por cada una de las primeras 40 horas y un
aumento del 20% por cada hora extra.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double PAGO_POR_HORA = 5000;
        final double PORCENTAJE_EXTRA = 1.2; // 20% adicional

        // Solicitar la cantidad de horas trabajadas
        System.out.print("Ingrese las horas trabajadas en la semana: ");
        int horasTrabajadas = scanner.nextInt();

        double salarioSemanal;

        if (horasTrabajadas <= 40) {
            salarioSemanal = horasTrabajadas * PAGO_POR_HORA;
        } else {
            int horasExtras = horasTrabajadas - 40;
            salarioSemanal = (40 * PAGO_POR_HORA) + (horasExtras * PAGO_POR_HORA * PORCENTAJE_EXTRA);
        }

        // Mostrar el salario calculado
        System.out.println("El salario semanal es: $" + salarioSemanal);

        scanner.close();
    }
}
