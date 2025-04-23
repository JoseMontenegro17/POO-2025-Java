package GarajeDeVehiculos.vehiiculos;

public class Coche extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public Coche(String marca, double precio, int cilindrada, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindrada);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;

        if (tieneRadio) {
            this.impuestoCirculacion += this.precio * 0.01;
        }
        if (tieneNavegador) {
            this.impuestoCirculacion += this.precio * 0.02;
        }
        if (cilindrada > 2999) {
            this.cuotaMesGarage *= 1.2;
        }
    }

    public boolean isTieneRadio() {
        return tieneRadio;
    }

    public boolean isTieneNavegador() {
        return tieneNavegador;
    }
}
