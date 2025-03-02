import java.util.Random;
import java.util.Scanner;

public class MejoraTemperatura2025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Nombres de los meses del año
        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        // Número de días por mes (año 2025 no bisiesto)
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Matriz para almacenar las correspodnidentes temperaturas diarias
        double[][] temperaturas = new double[12][];

        // Variables generales para cálculo anual
        double sumaAnual = 0, tempMaxAnual = 30, tempMinAnual = 41;
        int totalDias = 0;

        // Inicializar temperaturas y cálculos mensualess
        double[] promediosMensuales = new double[12];
        double[] maxMensuales = new double[12];
        double[] minMensuales = new double[12];

        for (int mes = 0; mes < 12; mes++) {
            temperaturas[mes] = new double[diasPorMes[mes]];
            double sumaMensual = 0, tempMaxMensual = 30, tempMinMensual = 41;

            for (int dia = 0; dia < diasPorMes[mes]; dia++) {
                temperaturas[mes][dia] = 30 + rand.nextDouble() * 11; // Rango 30 a 41°C
                sumaMensual += temperaturas[mes][dia];
                tempMaxMensual = Math.max(tempMaxMensual, temperaturas[mes][dia]);
                tempMinMensual = Math.min(tempMinMensual, temperaturas[mes][dia]);
            }

            promediosMensuales[mes] = sumaMensual / diasPorMes[mes];
            maxMensuales[mes] = tempMaxMensual;
            minMensuales[mes] = tempMinMensual;

            sumaAnual += sumaMensual;
            tempMaxAnual = Math.max(tempMaxAnual, tempMaxMensual);
            tempMinAnual = Math.min(tempMinAnual, tempMinMensual);
            totalDias += diasPorMes[mes];
        }

        double promedioAnual = sumaAnual / totalDias;


        int opcion;
        do {
            System.out.println("\n+--------------------------------+");
            System.out.println("|      MENÚ DE TEMPERATURAS      |");
            System.out.println("+----+---------------------------+");
            System.out.println("| 1  | Ver temperaturas diarias  |");
            System.out.println("| 2  | Ver temperaturas mensuales|");
            System.out.println("| 3  | Ver resumen anual         |");
            System.out.println("| 4  | Salir                     |");
            System.out.println("+----+---------------------------+");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese el número del mes (1-12): ");
                    int mesSeleccionado = scanner.nextInt();
                    if (mesSeleccionado < 1 || mesSeleccionado > 12) {
                        System.out.println("X Mes inválido. Intente de nuevo.");
                        break;
                    }
                    System.out.println("\nMes: " + nombresMeses[mesSeleccionado - 1]);
                    System.out.println("+------+------------+");
                    System.out.println("| Día  | Temperatura |");
                    System.out.println("+------+------------+");
                    for (int dia = 0; dia < diasPorMes[mesSeleccionado - 1]; dia++) {
                        System.out.printf("| %4d | %10.2f°C |\n", dia + 1, temperaturas[mesSeleccionado - 1][dia]);
                    }
                    System.out.println("+------+------------+");
                    break;

                case 2:
                    System.out.println("\n===== TEMPERATURAS MENSUALES =====");
                    System.out.println("+------------+------------+------------+------------+");
                    System.out.println("|   Mes      | Promedio   | Máxima     | Mínima     |");
                    System.out.println("+------------+------------+------------+------------+");
                    for (int mes = 0; mes < 12; mes++) {
                        System.out.printf("| %-10s | %10.2f°C | %10.2f°C | %10.2f°C |\n",
                                nombresMeses[mes], promediosMensuales[mes], maxMensuales[mes], minMensuales[mes]);
                    }
                    System.out.println("+------------+------------+------------+------------+");
                    break;

                case 3:
                    System.out.println("\n===== RESUMEN ANUAL =====");
                    System.out.println("+-------------+------------+");
                    System.out.println("| Categoría   | Temperatura |");
                    System.out.println("+-------------+------------+");
                    System.out.printf("| Promedio    | %10.2f°C |\n", promedioAnual);
                    System.out.printf("| Máxima      | %10.2f°C |\n", tempMaxAnual);
                    System.out.printf("| Mínima      | %10.2f°C |\n", tempMinAnual);
                    System.out.println("+-------------+------------+");
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("X Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
