package alfombra;

public class Habitacion {
        private String nombre;
        private Alfombra[] alfombras;
        private int contador; // para controlar cuántas alfombras hay

        public Habitacion(String nombre) {
            this.nombre = nombre;
            this.alfombras = new Alfombra[0];
            this.contador = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Alfombra[] getAlfombras() {
            return alfombras;
        }

        public boolean agregarAlfombra(Alfombra alf) {
            if (contador < alfombras.length) {
                alfombras[contador] = alf;
                contador++;
                return true;
            }
            return false; // no hay espacio
        }

        public double calcularPrecioTotal() {
            double total = 0;
            for (int i = 0; i < contador; i++) {
                total += alfombras[i].calcularPrecio();
            }
            return total;
        }

        public double calcularPrecioCuadradas() {
            double total = 0;
            for (int i = 0; i < contador; i++) {
                if (alfombras[i] instanceof AlfombraCuadrada) {
                    total += alfombras[i].calcularPrecio();
                }
            }
            return total;
        }
    }
