
/*
 * Un proveedor de reproductores de música ofrece un descuento del 10% sobre el precio sin IVA,
de algún aparato, si esta cuesta U$500 o más. Además, independientemente de esto, ofrece un
5% de descuento si la marca es “NOSY”. Determinar cuánto pagara, con IVA incluido, un cliente
cualquiera por la compra de su aparato. El IVA es del 19%.
 */
public class EjercicioTres {
    public static void main(String[] args) {
        double precio = 500;
        double descuento = 0;
        double iva = 0.19;
        double total = 0;
        String marca = "NOSY";

        if (precio >= 500) {
            descuento = precio * 0.10;
        }

        if (marca.equals("NOSY")) {
            descuento += precio * 0.05;
        }

        total = precio - descuento;
        total += total * iva;

        System.out.println("El total a pagar es: " + (total));
    }
}
