import java.util.Scanner;
public class CompraRefr {
    public static void main(String[] args) {
        /*
        Una empresa quiere hacer una compra de varias piezas de la misma clase a una fábrica de
refacciones. La empresa, dependiendo del monto total de la compra, decidirá qué hacer para
pagar al fabricante.
• Si el monto total de la compra excede de $500.000 la empresa tendrá la capacidad de invertir
de su propio dinero un 55% del monto de la compra, pedir prestado al banco un 30% y el
resto lo pagará solicitando un crédito al fabricante.
• Si el monto total de la compra no excede de $500.000 la empresa tendrá capacidad de
invertir de su propio dinero un 70% y el restante 30% lo pagará solicitando crédito al
fabricante.
• El fabricante cobra por concepto de intereses un 20% sobre la cantidad que se le pague a
crédito.
         */
        Scanner scanner = new Scanner(System.in);
        final double INTERES_FABRICANTE = 0.20; // 20% de interés

        // Solicitar el monto total de la compra
        System.out.print("Ingrese el monto total de la compra: ");
        double montoTotal = scanner.nextDouble();

        double inversionEmpresa, prestamoBanco = 0, creditoFabricante, intereses;

        if (montoTotal > 500000) {
            inversionEmpresa = montoTotal * 0.55;
            prestamoBanco = montoTotal * 0.30;
            creditoFabricante = montoTotal * 0.15;
        } else {
            inversionEmpresa = montoTotal * 0.70;
            creditoFabricante = montoTotal * 0.30;
        }

        // Calcular intereses sobre el crédito al fabricante
        intereses = creditoFabricante * INTERES_FABRICANTE;

        // Mostrar resultados
        System.out.println("\nResumen del pago:");
        System.out.println("Inversión propia: $" + inversionEmpresa);
        if (montoTotal > 500000) {
            System.out.println("Préstamo del banco: $" + prestamoBanco);
        }
        System.out.println("Crédito con el fabricante: $" + creditoFabricante);
        System.out.println("Intereses a pagar al fabricante: $" + intereses);
        System.out.println("Total a pagar incluyendo intereses: $" + (montoTotal + intereses));

        scanner.close();
    }
}

