package alfombra;

public class Mansion {
    private Habitacion[] arrayHabitaciones;
    private int contador;

    public Mansion(int capacidad) {
        this.arrayHabitaciones = new Habitacion[capacidad];
        this.contador = 0;
    }

    public boolean agregarHabitacion(Habitacion hab) {
        if (contador < arrayHabitaciones.length) {
            arrayHabitaciones[contador++] = hab;
            return true;
        }
        return false;
    }

    public double calcularPrecioTotalMansion() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += arrayHabitaciones[i].calcularPrecioTotal();
        }
        return total;
    }

    public double calcularPrecioCuadradasMansion() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += arrayHabitaciones[i].calcularPrecioCuadradas();
        }
        return total;
    }
}


