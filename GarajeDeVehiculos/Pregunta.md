8.b.2. Garage de vehículos

Se trata de gestionar un garage con diversas plazas que ocupan polimórficamente varios vehículos:

a) Se debe crear la clase Vehículo con estos atributos:
String matricula
String marca
double precio
int cilindrada
double impuestoCirculacion
double cuotaMesGarage

b) Hay que hacer un constructor con todos los atributos menos:

• la matricula (se inicia por defecto con valor null),

• la cuotaMesGarage (que coge por defecto el valor de una constante de clase -static- que por
ahora tenga el valor 100),

• la matricula y

• el impuestoCirculacion (éste ultimo se calcula en el constructor con el método de clase indicado
más adelante)

c) Incluir los setters y getters pertinentes. En el caso del setCuotaMesGarage, no se puede indicar
una cuota negativa.

d) Escribir estos métodos:

‣ void calcularImpuestoCirculacion() , que es el 2% importe del coche

‣ boolean matricular(String matricula) , que da valor al campo matricula, siempre que el
parámetro matricula tenga 7 caracteres. Devuelve si ha podido dar valor a la matrícula.

e) Crear clase Moto que hereda de Vehiculo. Esta clase tiene además un atributo
‣ boolean tieneSidecar que se asigna en el constructor
‣ Además para una moto, el impuestoCirculacion se incrementa en :
- un 10% más al precio de la cuota normal de moto si tiene sidecar
- El atributo cuotaMesGarage se aumenta en 50 % si tiene sidecar.

f) Crear clase Coche que hereda de Vehiculo. Esta clase tiene además los atributos:
  ‣ boolean tieneRadio , que se asigna en el constructor
  ‣ boolean tieneNavegador , que se asigna en el constructor
  ‣ Además para un coche, el impuestoCirculacion se incrementa en
- un 1% más al precio de la cuota normal de vehículo si tiene radio
- un 2% más al precio de la cuota normal de vehículo si tiene navegador
  ‣ El atributo cuotaMesGarage se aumenta en 20 % si la cilindrada del coche es mayor de 2999.

g) Crear una clase Garaje que tiene una colección de plazas de Vehículos. El número de plazas es
una constante de la clase. Esta clase debe cumplir con la interfaz iGarage, que tiene estos
métodos definidos:

‣ double calcularIngresos(); - Debe calcular la suma de ingresos mensuales de todos los
vehículos existentes en el garage

‣ int calcularOcupacionPorTipoVehiculo(Vehículo v); - Indica cuantos vehículos hay del tipo
pasado por parámetro en el garage

h) Hacer un menú para la gestión del Garaje, con estas opciones;

1.- Alquilar una plaza

2.- Baja de alquiler

3.- Consulta de ingresos mensuales

4.- Consulta proporción coches / motos

5.- Listado de matriculas y couta mensual y tipo vehículo

i) Se debe siempre controlar que:

‣ no se puedan alquilar más plazas de las existentes.

‣ no haya más del 80% de plazas ocupadas por motos.

‣ no se puede alquilar un vehículo si no tiene matricula.

MEJORA 1: Añadir opciones al menu

• 6.- Guardar vehículos en fichero (binario)

• 7.- Recuperar vehículos de fichero (binario)

MEJORA 2:
• Añadir excepciones personalizadas que controlen las siguientes situaciones:

• Intentar alquilar un vehículo que no tiene matricula (SinMatriculaException)

• Intentar asignar en el método setCuotaMesGarage un importe negativo
(CuotaNegativaException)

• En el calculo de ingresos mensuales, cuando el importe de la suma mensual sea menor de
400 euros (VamosALaQuiebraException)

MEJORA 3:

• Mostrar el listado dela opción 5 ordenado alfabéticamente

Crea una clase llamada CajaRegistradora que implemente la siguiente interfaz:

public interface ICajaRegistradora

{

/* @return Nombre de la caja registradora */

public String getNombre();

/* @return Número de tipos de moneda que hay en la caja. */

public int getNumTipoMonedas();

/**
* @param tipo
* @return Devuelve el número de unidades del tipo de moneda pasado como
* parámetro.
* -1 en el caso en el que el tipo de moneda no sea válido.
  */
  public int getUnidadesTipoMoneda(double tipo);
  /**
* Ingresa el número de monedas indicado y del tipo indicado. * @param tipo
* @param unidades
* @return true si los parÃ¡metros son vÃ¡lidos, false si no
  */
  public boolean meterMonedas(double tipo, int unidades);



/**
* Valida un tipo de moneda
* @param tipo
* @return true si es válida, false si no */
  public boolean monedaValida(double tipo);
  /**
* Extrae de la caja el número de unidades del tipo de moneda especificado
* @param tipo
* @param unidades

* @return true si ha sido posible, false en caso contrario.
  */
* 
  public boolean sacarMonedas(float tipo, int unidades); 
/*
* Vacía la caja registradora. */

  public void vaciarCajaRegistradora();

  /*@return Devuelve un array con los tipos de monedas que tiene. */

  public double[] getTiposDeMonedas();
* 
  /* @return Devuelve el saldo actual de la caja */

  public double getSaldo();

  }
 
* Crear una clase Prueba e instanciar una caja registradora probar su funcionamiento con el siguiente
  menú:


  1.­ Ingresar monedas (Pedirá por teclado tipo y unidad)

  2.­ Listar Contenido ( Por cada tipo de monedas, decir cuantas unidades hay)

  3.­ Mostrar saldo.

  4.­ Extraer monedas. (Pedirá por teclado tipo y número)

  5.­ Salir.