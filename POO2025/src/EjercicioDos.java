

/*
 * En una serviteca se ha establecido una promoción de las llantas marca “Pinchadas”, que consiste
en lo siguiente:
• Si se compran menos de cinco llantas el precio es de U$100 cada una, de U$75 si se
compran de cinco a 10 y de U$50 si se compran más de 10.
• Obtener la cantidad de dinero que una persona tiene que pagar por cada una de las llantas
que compra y la que tiene que pagar por el total de la compra.
 */
public class EjercicioDos {

    public static void main(String[] args) {
        int cantidad = 10;
        double precio = 100;
        double total = cantidad * precio;
        double descuento = 0;

        if (cantidad < 5) {
            precio = 100;
        } else if (cantidad < 10) {
            precio = 75;
        } else {
            precio = 50;
        }

        System.out.println("El total a pagar es: " + (total));
        System.out.println("El total a pagar por cada llanta es: " + (precio));
    }
}
