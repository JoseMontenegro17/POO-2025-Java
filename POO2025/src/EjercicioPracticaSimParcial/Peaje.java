package EjercicioPracticaSimParcial;
import java.util.Scanner;
public class Peaje {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Matriz que almmacena  la cant de vehículos por día y su franja horaria
            int[][] matriz = new int[30][4];

            // Llenar la matris usando Math.random()
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == 0 || j == 3) {
                        matriz[i][j] = (int) (Math.random() * 71) + 10; // Valores entre 10 y 80
                    } else {
                        matriz[i][j] = (int) (Math.random() * 91) + 60; // Valores entre 60 y 150
                    }
                }
            }

            System.out.println("----------------------------------------------------------");
            System.out.println("|                 Reportes de los vehiculos del peaje    |");
            System.out.println("----------------------------------------------------------");

            System.out.print("Ingrese un número de día (1-30): ");
            int dia = scanner.nextInt();

            if (dia >= 1 && dia <= 30) {
                System.out.println("\n----------------------------------------------------------");
                System.out.println("|                      Reporte dek dia" + dia);
                System.out.println("----------------------------------------------------------");
                System.out.println("Hora 0-6      Hora 6-12     Hora 12-18    Hora 18-24");
                System.out.println("----------------------------------------------------------");
                System.out.println(matriz[dia - 1][0] + "        " + matriz[dia - 1][1] + "         " + matriz[dia - 1][2] + "         " + matriz[dia - 1][3]);

                // Calcular totales por franja horaria
                int franja_00_12 = matriz[dia - 1][0] + matriz[dia - 1][1];
                int franja_12_24 = matriz[dia - 1][2] + matriz[dia - 1][3];
                System.out.println("----------------------------------------------------------");
                System.out.println("00-12 Total: " + franja_00_12);
                System.out.println("12-24 Total: " + franja_12_24);
            } else {
                System.out.println("Día fuera de rango.");
            }

            // Calcular promedio de vehículos por franja horaria en todo el mes
            double suma_fr0_6 = 0, suma_fr6_12 = 0, suma_fr12_18 = 0, suma_fr18_24 = 0;

            for (int i = 0; i < 30; i++) {
                suma_fr0_6 += matriz[i][0];
                suma_fr6_12 += matriz[i][1];
                suma_fr12_18 += matriz[i][2];
                suma_fr18_24 += matriz[i][3];
            }

            System.out.println("\n----------------------------------------------------------");
            System.out.println("|          Promedio de vehiculos por franjasa          |");
            System.out.println("----------------------------------------------------------");
            System.out.println("Hora 0-6      Hora 6-12     Hora 12-18    Hora 18-24");
            System.out.println("----------------------------------------------------------");
            System.out.printf("%.2f         %.2f         %.2f         %.2f\n",
                    suma_fr0_6 / 30, suma_fr6_12 / 30, suma_fr12_18 / 30, suma_fr18_24 / 30);

            // Generar vector con total de vehículos por día
            int[] total_dia = new int[30];
            for (int i = 0; i < 30; i++) {
                total_dia[i] = matriz[i][0] + matriz[i][1] + matriz[i][2] + matriz[i][3];
            }

            // Determinar los días con mayor y menor circulación
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
            System.out.println("| Día con mayor circulación: " + dia_mayor + " | Vehículos: " + mayor+ "|");
            System.out.println("| Día con menor circulación: " + dia_menor + " | Vehículos: " + menor+ "|");
            System.out.println("-----------------------------------------------------------");

            scanner.close();
        }
    }
    /*
    Se tiene los datos de la cantidad de vehículos que pasan por el peaje de entrada y salida, durante
un número determinado de días, máximo 30, en cuatro franjas horarias, así:
Día Hora 0-6 Hora 6-12 Hora 12-18 Hora 18-24
1 60 125 145 80
2 58 114 132 87
3 42 100 102 62
. . . . .
. . . . .
30 65 116 121 65

Escriba un programa que realice las siguientes actividades:
a. Usar una matriz con cuatro columnas, para almacenar la cantidad de vehículos diarios por cada
franja horaria, de tal forma que se llene con números aleatorios enteros. Las franjas de Hora 0-
6 y Hora 18-24 se llena con valores entre 10 y 80. Las otras franjas tiene valores entre 60 y 150.
b. Genere un reporte que le solicite al usuario un numero de día entre 1 y 30 y muestre los siguiente:
No. Día: XX
Cantidad de Vehículos
Hora 0-6: XX
Hora 6-12: XX
Hora 12-18: XX
Hora 18-24: XX
Cantidad de Vehículos en la Franja de 00-12: XX
Cantidad de Vehículos en la Franja de 12-24: XX
c. Calcular el promedio de cada una de las cuatro franjas horarias.
d. Generar un vector que calcule el total de vehículos que circularon diariamente.
e. Determinar los días que hubo mayor circulación y menor circulación de vehículos por el peaje.
     */





