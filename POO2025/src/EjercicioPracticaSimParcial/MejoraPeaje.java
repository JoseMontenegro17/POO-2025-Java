package EjercicioPracticaSimParcial;
import java.util.Scanner;
public class MejoraPeaje {
    //en esta nueva mejora se le incorporo un do while para que tal caso que el usuario ingrese un num pasado de 30 le retorne un mensaje y otra ves el menu
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[][] matriz = new int[30][4];

            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0 || j == 3) {
                        matriz[i][j] = (int) (Math.random() * 71) + 10;
                    } else {
                        matriz[i][j] = (int) (Math.random() * 91) + 60;
                    }
                }
            }

            System.out.println("----------------------------------------------------------");
            System.out.println("|                 Reportes de los vehiculos del peaje    |");
            System.out.println("----------------------------------------------------------");
            int dia;

            do {
                System.out.print("Ingrese un número de día (1-30): ");
                dia = scanner.nextInt();
                if (dia < 1 || dia > 30) {
                    System.out.println("Error: Día fuera de rango. Intente nuevamente.\n");
                }
            } while (dia < 1 || dia > 30);

            System.out.println("\n----------------------------------------------------------");
            System.out.println("|                      Reporte del día " + dia + "               |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Hora 0-6      Hora 6-12     Hora 12-18    Hora 18-24");
            System.out.println("----------------------------------------------------------");
            System.out.println(matriz[dia - 1][0] + "        " + matriz[dia - 1][1] + "         " + matriz[dia - 1][2] + "         " + matriz[dia - 1][3]);

            int franja_00_12 = matriz[dia - 1][0] + matriz[dia - 1][1];
            int franja_12_24 = matriz[dia - 1][2] + matriz[dia - 1][3];
            System.out.println("----------------------------------------------------------");
            System.out.println("00-12 Total: " + franja_00_12);
            System.out.println("12-24 Total: " + franja_12_24);

            double suma_fr0_6 = 0, suma_fr6_12 = 0, suma_fr12_18 = 0, suma_fr18_24 = 0;

            for (int i = 0; i < 30; i++) {
                suma_fr0_6 += matriz[i][0];
                suma_fr6_12 += matriz[i][1];
                suma_fr12_18 += matriz[i][2];
                suma_fr18_24 += matriz[i][3];
            }

            System.out.println("\n----------------------------------------------------------");
            System.out.println("|          Promedio de vehiculos por franjas           |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Hora 0-6      Hora 6-12     Hora 12-18    Hora 18-24");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%.2f         %.2f         %.2f         %.2f\n",
                    suma_fr0_6 / 30, suma_fr6_12 / 30, suma_fr12_18 / 30, suma_fr18_24 / 30);

            int[] total_dia = new int[30];
            for (int i = 0; i < 30; i++) {
                total_dia[i] = matriz[i][0] + matriz[i][1] + matriz[i][2] + matriz[i][3];
            }

            int mayor = total_dia[0], menor = total_dia[0], dia_mayor = 1, dia_menor = 1;

            for (int i = 1; i < 30; i++) {
                if (total_dia[i] > mayor) {
                    mayor = total_dia[i];
                    dia_mayor = i + 1;
                }
                if (total_dia[i] < menor) {
                    menor = total_dia[i];
                    dia_menor = i + 1;
                }
            }

            System.out.println("\n----------------------------------------------------------");
            System.out.println("          Dias con > y < circulación         ");
            System.out.println("----------------------------------------------------------");
            System.out.println("| Día con mayor circulación: " + dia_mayor + " | Vehículos: " + mayor + " |");
            System.out.println("| Día con menor circulación: " + dia_menor + " | Vehículos: " + menor + " |");
            System.out.println("-----------------------------------------------------------");

            scanner.close();
        }
    }

