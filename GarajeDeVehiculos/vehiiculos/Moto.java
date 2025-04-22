package GarajeDeVehiculos.vehiiculos;

public class Moto extends Vehiculo {
    private boolean tieneSidecar;

    public Moto(String marca, double precio, int cilindrada, boolean tieneSidecar) {
        super(marca, precio, cilindrada);
        this.tieneSidecar = tieneSidecar;
        if (tieneSidecar) {
            this.setCuotaMesGarage(this.getCuotaMesGarage() * 1.5);  // Aumento del 50% para la cuota mensual
        }
        calcularImpuestoCirculacion();
    }

    @Override
    public void calcularImpuestoCirculacion() {
        super.calcularImpuestoCirculacion();
        if (tieneSidecar) {
            double incrementoImpuesto = this.getImpuestoCirculacion() * 0.10;
            this.setCuotaMesGarage(this.getCuotaMesGarage() + incrementoImpuesto);
        }
    }
}

