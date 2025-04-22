package GarajeDeVehiculos.vehiiculos;

public class Coche extends Vehiculo {
    private boolean tieneRadio;
    private boolean tieneNavegador;

    public boolean tieneRadio() {
        return tieneRadio;
    }

    public void setTieneRadio(boolean tieneRadio) {
        this.tieneRadio = tieneRadio;
    }

    public boolean TieneNavegador() {
        return tieneNavegador;
    }

    public void setTieneNavegador(boolean tieneNavegador) {
        this.tieneNavegador = tieneNavegador;
    }

    public Coche(String marca, double precio, int cilindrada, boolean tieneRadio, boolean tieneNavegador) {
        super(marca, precio, cilindrada);
        this.tieneRadio = tieneRadio;
        this.tieneNavegador = tieneNavegador;
        if (cilindrada > 2999) {
            this.setCuotaMesGarage(this.getCuotaMesGarage() * 1.2);  // Aumento de cuota por cilindrada
        }
        calcularImpuestoCirculacion();
    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
        if (tieneRadio) {
            this.setCuotaMesGarage(this.getCuotaMesGarage() * 1.01);  // Incremento por radio
        }
        if (tieneNavegador) {
            this.setCuotaMesGarage(this.getCuotaMesGarage() * 1.02);  // Incremento por navegador
        }
    }
}
