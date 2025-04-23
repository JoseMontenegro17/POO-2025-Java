package GarajeDeVehiculos.Garaje;

import GarajeDeVehiculos.vehiiculos.Vehiculo;

public interface IGarage {
    double calcularIngresos();

    int calcularOcupacionPorTipoVehiculo(Class<?> tipo);

    public interface IGaraje {
        double calcularIngresos();
        int calcularOcupacionPorTipoVehiculo(Vehiculo v);


    }

}
