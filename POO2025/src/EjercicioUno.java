/*
 * 1. En una tienda de computadoras se planea ofrecer a los clientes un descuento que dependerá
del número de equipos que compre. Si las computadoras son menos de cinco se les dará un
10% de descuento sobre el total de la compra; si el número de computadoras es mayor o igual
a cinco pero menos de diez se le otorga un 20% de descuento; y si son 10 o más se les da un
40% de descuento. El precio de cada computadora es de U$500.
 */
public class EjercicioUno {
    public static void main(String[] args) {
        int cantidad = 10;
        double precio = 500;
        double total = cantidad * precio;
        double descuento = 0;

        if (cantidad < 5) {
            descuento = total * 0.10;
        } else if (cantidad < 10) {
            descuento = total * 0.20;
        } else {
            descuento = total * 0.40;
        }

        System.out.println("El total a pagar es: " + (total - descuento));
    }
    }

