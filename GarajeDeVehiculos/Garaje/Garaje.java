package GarajeDeVehiculos.Garaje;
import GarajeDeVehiculos.vehiiculos.Moto;
import GarajeDeVehiculos.vehiiculos.Vehiculo;


public class Garaje implements IGarage {
    private static final int MAX_PLAZAS = 10;
    private Vehiculo[] plazas = new Vehiculo[MAX_PLAZAS];

    public boolean alquilarPlaza(Vehiculo vehiculo) {
        if (vehiculo.getMatricula() == null) return false;

        int ocupadas = 0;
        int motos = 0;

        for (Vehiculo v : plazas) {
            if (v != null) {
                ocupadas++;
                if (v instanceof Moto) motos++;
            }
        }

        if (ocupadas >= MAX_PLAZAS) return false;
        if (vehiculo instanceof Moto && ((double) motos / MAX_PLAZAS) >= 0.8) return false;

        for (int i = 0; i < MAX_PLAZAS; i++) {
            if (plazas[i] == null) {
                plazas[i] = vehiculo;
                return true;
            }
        }
        return false;
    }

    public boolean bajaAlquiler(String matricula) {
        for (int i = 0; i < MAX_PLAZAS; i++) {
            if (plazas[i] != null && matricula.equals(plazas[i].getMatricula())) {
                plazas[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public double calcularIngresos() {
        double total = 0;
        for (Vehiculo v : plazas) {
            if (v != null) {
                total += v.getCuotaMesGarage();
            }
        }
        return total;
    }

    @Override
    public int calcularOcupacionPorTipoVehiculo(Class<?> tipo) {
        int contador = 0;
        for (Vehiculo v : plazas) {
            if (v != null && tipo.isInstance(v)) {
                contador++;
            }
        }
        return contador;
    }

    public void listarVehiculos() {
        for (Vehiculo v : plazas) {
            if (v != null) {
                System.out.println("Matricula: " + v.getMatricula() +
                        ", Cuota: " + v.getCuotaMesGarage() +
                        ", Tipo: " + v.getClass().getSimpleName());
            }
        }
    }
}
