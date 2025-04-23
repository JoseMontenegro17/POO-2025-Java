package GarajeDeVehiculos.vehiiculos;

public class Vehiculo {
    protected String matricula;
    protected String marca;
    protected double precio;
    protected int cilindrada;
    protected double impuestoCirculacion;
    protected double cuotaMesGarage;

    protected static final double CUOTA_BASE = 100;

    public Vehiculo(String marca, double precio, int cilindrada) {
        this.marca = marca;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.cuotaMesGarage = CUOTA_BASE;
        this.matricula = null;
        calcularImpuestoCirculacion();
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public double getPrecio() { return precio; }
    public int getCilindrada() { return cilindrada; }
    public double getImpuestoCirculacion() { return impuestoCirculacion; }
    public double getCuotaMesGarage() { return cuotaMesGarage; }

    public void setCuotaMesGarage(double cuota) {
        if (cuota >= 0) {
            this.cuotaMesGarage = cuota;
        }
    }

    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = this.precio * 0.02;
    }

    public boolean matricular(String matricula) {
        if (matricula != null && matricula.length() == 7) {
            this.matricula = matricula;
            return true;
        }
        return false;
    }
}

