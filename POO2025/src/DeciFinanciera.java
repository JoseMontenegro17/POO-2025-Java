import java.util.Scanner;

public class DeciFinanciera {
    /*
    El dueño de una empresa desea planificar las decisiones financieras que tomara en el siguiente
año. La manera de planificarlas depende de lo siguiente:
Si actualmente su capital se encuentra con saldo negativo, pedirá un préstamo bancario para
que su nuevo saldo sea de U$10.000. Si su capital tiene actualmente un saldo positivo pedirá un
préstamo bancario para tener un nuevo saldo de U$20.000, pero si su capital tiene actualmente
un saldo superior a los U$20.000 no pedirá ningún préstamo.
Posteriormente repartirá su presupuesto de la siguiente manera:
• U$5.000 para equipo de computo
• U$2.000 para mobiliario
• El resto la mitad será para la compra de insumos y la otra para otorgar incentivos al personal.
Desplegar que cantidades se destinaran para la compra de insumos e incentivos al personal y,
en caso de que fuera necesario, a cuánto ascendería la cantidad que se pediría al banco.
     */

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el saldo actual del capital en dólares: ");
            double saldoActual = scanner.nextDouble();
            double prestamo = 0;

            // Determinar el nuevo saldo
            if (saldoActual < 0) {
                prestamo = 10000 - saldoActual;
                saldoActual = 10000;
            } else if (saldoActual > 0 && saldoActual < 20000) {
                prestamo = 20000 - saldoActual;
                saldoActual = 20000;
            }
            double equipoComputo = 5000;
            double mobiliario = 2000;
            double restante = saldoActual - (equipoComputo + mobiliario);
            double insumos = restante / 2;
            double incentivos = restante / 2;

            System.out.println("\n----- PLANIFICACIÓN FINANCIERA -----");
            if (prestamo > 0) {
                System.out.println("Cantidad solicitada al banco: $" + prestamo);
            } else {
                System.out.println("No se requiere préstamo bancario.");
            }
            System.out.println("Monto destinado para equipo de computo: $" + equipoComputo);
            System.out.println("Monto destinado para mobiliario: $" + mobiliario);
            System.out.println("Monto destinado para compra de insumos: $" + insumos);
            System.out.println("Monto destinado para incentivos al personal: $" + incentivos);

            scanner.close();
        }
    }

