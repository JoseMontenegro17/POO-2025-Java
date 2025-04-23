package GarajeDeVehiculos.vehiiculos;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindrada, boolean tieneSidecar) {
        super(marca, precio, cilindrada);
        this.tieneSidecar = tieneSidecar;

        if (tieneSidecar) {
            this.impuestoCirculacion += this.precio * 0.10;
            this.cuotaMesGarage *= 1.5;
        }
    }

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }
}


