package alfombra;

public class Main {
    public static void main(String[] args) {
        // Crear alfombras con precioMetro NO cero
        AlfombraRedonda alfombraR = new AlfombraRedonda("Azul", 15, 3); // superficie: ~28.27
        AlfombraCuadrada alfombraC1 = new AlfombraCuadrada("Rojo", 12, 4); // superficie: 16
        AlfombraCuadrada alfombraC2 = new AlfombraCuadrada("Verde", 10, 5); // superficie: 25

        // Crear habitaciones
        Habitacion hab1 = new Habitacion("Habitación 1");
        hab1.agregarAlfombra(alfombraR);
        hab1.agregarAlfombra(alfombraC1);

        Habitacion hab2 = new Habitacion("Habitación 2");
        hab2.agregarAlfombra(alfombraC2);

        // Crear mansión
        Mansion mansion = new Mansion(3);
        mansion.agregarHabitacion(hab1);
        mansion.agregarHabitacion(hab2);

        // Mostrar precios
        System.out.printf("Precio total de todas las alfombras de la mansión: %.2f\n", mansion.calcularPrecioTotalMansion());
        System.out.printf("Precio total de alfombras cuadradas de la mansión: %.2f\n", mansion.calcularPrecioCuadradasMansion());
    }
}


