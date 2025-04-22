package GarajeDeVehiculos.Garaje;

import GarajeDeVehiculos.vehiiculos.Vehiculo;

public interface IGarage {
    public interface IGaraje {
        double calcularIngresos();
        int calcularOcupacionPorTipoVehiculo(Vehiculo v);


    }

}
