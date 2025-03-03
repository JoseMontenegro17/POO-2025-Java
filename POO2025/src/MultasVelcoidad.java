/*
El departamento de policía de la ciudad ha acumulado información referente a las infracciones
de los límites de velocidad durante un determinado período de tiempo. El departamento ha
dividido la ciudad en cuatro cuadrantes y desea realizar una estadística de las infracciones a

los límites de velocidad en cada uno de ellos. Para cada infracción se capturan los siguientes
datos:
Número de registro del vehículo (placa alfanumérica), cuadrante en el que se produjo la
infracción (1 a 4), límite de velocidad permitido en km/h (entero), velocidad real desarrollada en
km/h (entero).
Diseñe un algoritmo para producir dos informes; el primero, que contiene una lista de las multas
de velocidad recolectadas, donde la multa se calcula como la suma del costo de la infracción
($500.000) más $20.000 por cada km/h que se ha excedido la velocidad límite. Por ejemplo:
El vehículo con placa GFD123 registró una velocidad de 85 km/h en una zona de 60 km/h, por
lo que la multa se calculó de la siguiente forma: 500.000 + (85-60) * 20.000 = 800.000.
Registro Velocidad registrada Velocidad límite Multa
GFD123 85 60 800.000
Este informe debe ser seguido de un segundo, en el cual se proporciona un análisis de las
infracciones por cuadrante. Para cada uno de los cuatro cuadrantes mencionados, debe darse
el número de infracciones y la multa promedio. Por ejemplo:
Cuadrante 1. Total de infracciones: ____. Multa promedio: _____
...
Cuadrante 4. Total de infracciones: ____. Multa promedio: _____
La multa promedio se calcula sumando el monto de todas las multas en un cuadrante y
dividiendo entre el número de multas en ese cuadrante.
NOTA: Suponga que se acumularon datos de N infracciones.
 */

public class MultasVelcoidad {
    public static void main(String[] args) {

            String[][] infracciones = {
                    {"GFD123", "1", "60", "85"},
                    {"ABC456", "2", "50", "70"},
                    {"XYZ789", "3", "80", "90"},
                    {"LMN321", "1", "60", "60"}, // No supera el límite
                    {"JKL654", "4", "40", "50"}
            };

            // Variables para el análisis por cuadrante
            int total1 = 0, total2 = 0, total3 = 0, total4 = 0;
            int sumaMulta1 = 0, sumaMulta2 = 0, sumaMulta3 = 0, sumaMulta4 = 0;

            System.out.println("\nInforme de multas de velocidad:\n");
            System.out.printf("%-10s %-20s %-20s %-10s\n", "Placa", "Velocidad registrada", "Velocidad límite", "Multa");
            System.out.println("-".repeat(70));

            for (int i = 0; i < infracciones.length; i++) {
                String placa = infracciones[i][0];
                int cuadrante = Integer.parseInt(infracciones[i][1]);
                int limite = Integer.parseInt(infracciones[i][2]);
                int velocidad = Integer.parseInt(infracciones[i][3]);

                if (velocidad > limite) {
                    int multa = 500000 + (velocidad - limite) * 20000;
                    System.out.printf("%-10s %-20d %-20d $%,d\n", placa, velocidad, limite, multa);

                    // Sumar multas e infracciones por cuadrante
                    if (cuadrante == 1) {
                        total1++;
                        sumaMulta1 += multa;
                    } else if (cuadrante == 2) {
                        total2++;
                        sumaMulta2 += multa;
                    } else if (cuadrante == 3) {
                        total3++;
                        sumaMulta3 += multa;
                    } else if (cuadrante == 4) {
                        total4++;
                        sumaMulta4 += multa;
                    }
                }
            }

            // Mostrar análisis por cuadrante
            System.out.println("\nAnálisis de infracciones por cuadrante:\n");
            System.out.printf("Cuadrante 1. Total de infracciones: %d. Multa promedio: $%,.2f\n", total1, total1 > 0 ? (double) sumaMulta1 / total1 : 0);
            System.out.printf("Cuadrante 2. Total de infracciones: %d. Multa promedio: $%,.2f\n", total2, total2 > 0 ? (double) sumaMulta2 / total2 : 0);
            System.out.printf("Cuadrante 3. Total de infracciones: %d. Multa promedio: $%,.2f\n", total3, total3 > 0 ? (double) sumaMulta3 / total3 : 0);
            System.out.printf("Cuadrante 4. Total de infracciones: %d. Multa promedio: $%,.2f\n", total4, total4 > 0 ? (double) sumaMulta4 / total4 : 0);
        }
    }


