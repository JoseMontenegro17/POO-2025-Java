package GarajeDeVehiculos.Garaje;

import GarajeDeVehiculos.vehiiculos.Coche;
import GarajeDeVehiculos.vehiiculos.Moto;
import GarajeDeVehiculos.vehiiculos.Vehiculo;

import java.util.Scanner;

public class Garaje implements IGarage {
    private Vehiculo[] plazas = new Vehiculo[NUM_PLAZAS];
    private int ocupacion = 0;  // Numero de plazas ocupadas
    private static final int NUM_PLAZAS = 10;  // Numero de plazas

    // Implementación del metodo calcularIngresos
    public double calcularIngresos() {
        double ingresos = 0;
        for (int i = 0; i < ocupacion; i++) {
            ingresos += plazas[i].getCuotaMesGarage();
        }
        if (ingresos < 400) {
            System.out.println("Los ingresos mensuales son menores de 400 euros.");
        }
        return ingresos;
    }

    // Implementacin del metodo calcularOcupacionPorTipoVehiculo
    public int calcularOcupacionPorTipoVehiculo(Vehiculo v) {
        int contador = 0;
        for (int i = 0; i < ocupacion; i++) {
            if (plazas[i].getClass().equals(v.getClass())) {
                contador++;
            }
        }
        return contador;
    }

    // Alquilar la plaza
    public void alquilarPlaza(Vehiculo vehiculo) {
        if (vehiculo.getMatricula() == null) {
            System.out.println("El vehiculo no tiene matricula.");
            return;
        }
        if (ocupacion >= NUM_PLAZAS) {
            System.out.println("No hay mas plazas disponibles.");
            return;
        }
        if (calcularOcupacionPorTipoVehiculo(new Moto(null, 0, 0, false)) > NUM_PLAZAS * 0.8) {
            System.out.println("No se pueden alquilar mas plazas para motos.");
            return;
        }
        plazas[ocupacion] = vehiculo;
        ocupacion++;
    }

    // Metodo para dar de baja el vehiculo
    public void darDeBaja(String matricula) {
        for (int i = 0; i < ocupacion; i++) {
            if (plazas[i].getMatricula().equals(matricula)) {

                for (int j = i; j < ocupacion - 1; j++) {
                    plazas[j] = plazas[j + 1];
                }
                plazas[ocupacion - 1] = null;  // Eliminar la ultima plaza
                ocupacion--;
                break;
            }
        }
    }

    // Consultar ingresos mensuales
    public void consultaIngresos() {
        System.out.println("Ingresos mensuales: " + calcularIngresos() + " euros.");
    }

    // Consultar proporcion coches, motos
    public void consultaProporcionVehiculos() {
        int coches = 0;
        int motos = 0;

        for (int i = 0; i < ocupacion; i++) {
            if (plazas[i] instanceof Coche) {
                coches++;
            } else if (plazas[i] instanceof Moto) {
                motos++;
            }
        }

        System.out.println("Cantidad de coches: " + coches);
        System.out.println("Cantidad de motos: " + motos);

        if (ocupacion > 0) {
            System.out.println("Proporción coches: " + ((double) coches / ocupacion) * 100 + "%");
            System.out.println("Proporción motos: " + ((double) motos / ocupacion) * 100 + "%");
        } else {
            System.out.println("No hay vehículos en el garaje.");
        }
    }


    // Listar matriculas
    public void listarMatriculas() {
        if (ocupacion == 0) {
            System.out.println("No hay vehículos en el garaje.");
            return;
        }

        System.out.println("Listado de vehiculos:");
        for (int i = 0; i < ocupacion; i++) {
            String tipo = (plazas[i] instanceof Coche) ? "Coche" : "Moto";
            System.out.println("- Matrícula: " + plazas[i].getMatricula() +
                    ", Cuota: " + plazas[i].getCuotaMesGarage() +
                    ", Tipo: " + tipo);
        }
    }


    // Meotodo principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Garaje garaje = new Garaje();

        //Var de control
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú de Gestion del Garaje");
            System.out.println("1. Alquilar una plaza");
            System.out.println("2. Baja de alquiler");
            System.out.println("3. Consulta de ingresos mensuales");
            System.out.println("4. Consulta proporción coches/motos");
            System.out.println("5. Listado de matriculas y cuota mensual");
            System.out.println("6. Salir");

            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el tipo de vehiculo (Coche/Moto): ");
                    String tipo = scanner.nextLine().toLowerCase();

                    Vehiculo vehiculo = null;

                    System.out.print("Ingrese la matricula (7 caracteres): ");
                    String matricula = scanner.nextLine();

                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Ingrese la cilindrada: ");
                    int cilindrada = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    if (tipo.equals("coche")) {
                        System.out.print("¿Tiene radio? (true/false): ");
                        boolean tieneRadio = scanner.nextBoolean();

                        System.out.print("¿Tiene navegador? (true/false): ");
                        boolean tieneNavegador = scanner.nextBoolean();
                        scanner.nextLine(); // Limpiar buffer

                        Coche coche = new Coche(marca, precio, cilindrada, tieneRadio, tieneNavegador);
                        if (coche.matricular(matricula)) {
                            vehiculo = coche;
                        } else {
                            System.out.println("Matrícula inválida.");
                        }

                    } else if (tipo.equals("moto")) {
                        System.out.print("¿Tiene sidecar? (true/false): ");
                        boolean tieneSidecar = scanner.nextBoolean();
                        scanner.nextLine(); // Limpiar buffer

                        Moto moto = new Moto(marca, precio, cilindrada, tieneSidecar);
                        if (moto.matricular(matricula)) {
                            vehiculo = moto;
                        } else {
                            System.out.println("Matricula inválida.");
                        }

                    } else {
                        System.out.println("Tipo de vehículo inválido.");
                    }

                    if (vehiculo != null) {
                        garaje.alquilarPlaza(vehiculo);
                        System.out.println("Vehiculo alquilado correctamente.");
                    }
                    break;

            }

        }
    }
}
