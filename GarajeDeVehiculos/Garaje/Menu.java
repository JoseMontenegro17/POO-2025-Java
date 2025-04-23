package GarajeDeVehiculos.Garaje;

import GarajeDeVehiculos.vehiiculos.Coche;
import GarajeDeVehiculos.vehiiculos.Moto;
import GarajeDeVehiculos.vehiiculos.Vehiculo;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Garaje garaje = new Garaje();
        boolean salir = false;

        while (!salir) {
            System.out.println("----- MENU -----");
            System.out.println("1.- Alquilar una plaza");
            System.out.println("2.- Baja de alquiler");
            System.out.println("3.- Consulta de ingresos mensuales");
            System.out.println("4.- Consulta proporción coches / motos");
            System.out.println("5.- Listado de matriculas y cuota mensual y tipo vehículo");
            System.out.println("6.- Salir");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("1 = Coche, 2 = Moto");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cilindrada: ");
                    int cilindrada = sc.nextInt();
                    sc.nextLine();

                    Vehiculo v;
                    if (tipo == 1) {
                        System.out.print("¿Tiene radio? (true/false): ");
                        boolean radio = sc.nextBoolean();
                        System.out.print("¿Tiene navegador? (true/false): ");
                        boolean navegador = sc.nextBoolean();
                        v = new Coche(marca, precio, cilindrada, radio, navegador);
                    } else {
                        System.out.print("¿Tiene sidecar? (true/false): ");
                        boolean sidecar = sc.nextBoolean();
                        v = new Moto(marca, precio, cilindrada, sidecar);
                    }
                    sc.nextLine();

                    System.out.print("Matrícula (7 caracteres): ");
                    String mat = sc.nextLine();
                    if (v.matricular(mat)) {
                        if (garaje.alquilarPlaza(v)) {
                            System.out.println("Vehículo alquilado con éxito.");
                        } else {
                            System.out.println("No se pudo alquilar la plaza (garage lleno o límite de motos).");
                        }
                    } else {
                        System.out.println("Matrícula inválida.");
                    }
                }

                case 2 -> {
                    System.out.print("Introduce la matrícula del vehículo a dar de baja: ");
                    String mat = sc.nextLine();
                    if (garaje.bajaAlquiler(mat)) {
                        System.out.println("Vehículo eliminado.");
                    } else {
                        System.out.println("Vehículo no encontrado.");
                    }
                }

                case 3 -> {
                    double ingresos = garaje.calcularIngresos();
                    System.out.println("Ingresos mensuales totales: " + ingresos);
                }

                case 4 -> {
                    int coches = garaje.calcularOcupacionPorTipoVehiculo(Coche.class);
                    int motos = garaje.calcularOcupacionPorTipoVehiculo(Moto.class);
                    System.out.println("Coches: " + coches + " | Motos: " + motos);
                }

                case 5 -> garaje.listarVehiculos();

                case 6 -> {
                    salir = true;
                    System.out.println("Saliendo del programa...");
                }

                default -> System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
