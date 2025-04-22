package GarajeDeVehiculos.vehiiculos;

public class Vehiculo {
    private String matricula;
    private String marca;
    private double precio;
    private int cilindrada;
    private double impuestoCirculacion;
    private double cuotaMesGarage;

    // Constante para la cuota mensual por defecto
    public static final double CUOTA_MES_DEFAULT = 100.0;

    // Constructor
    public Vehiculo(String marca, double precio, int cilindrada) {
        this.marca = marca;
        this.precio = precio;
        this.cilindrada = cilindrada;
        this.matricula = null;
        this.cuotaMesGarage = CUOTA_MES_DEFAULT;
        calcularImpuestoCirculacion();
    }

    // Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public boolean matricular(String matricula) {
        if (matricula.length() == 7) {
            this.matricula = matricula;
            return true;
        }
        return false;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getImpuestoCirculacion() {
        return impuestoCirculacion;
    }

    public double getCuotaMesGarage() {
        return cuotaMesGarage;
    }


    public void setCuotaMesGarage(double cuotaMesGarage) {
        if (cuotaMesGarage < 0) {
            System.out.println("La cuota mensual no puede ser negativa.");
        } else {
            this.cuotaMesGarage = cuotaMesGarage;
        }
    }

    // Metodo para calcular el impuesto de circulacion
    public void calcularImpuestoCirculacion() {
        this.impuestoCirculacion = 0.02 * this.precio;
    }
}
