package lineales.estaticas;

/**
 *
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-3023
 * @author Julian Nuñez, Legajo FAI-3931
 */
public class Cola {
    private int frente;
    private int fin;
    private static final int SIZE = 10; // tamanio fijo estatico circular
    private Object[] arreglo;
    
    /**
     * Constructor vacio aunque yo le pasaria size por parametro
     */
    public Cola() {
        this.arreglo = new Object[SIZE];
        this.frente = 0;
        this.fin = 0;
    }
    
    public boolean poner(Object obj) {
        boolean exito = false;
        // Verificar si la cola está llenaAASDASD
        if ( (this.fin + 1) % SIZE != this.frente ) {
            this.arreglo[this.fin] = obj; // InserASDASDtar elemento
            this.fin = (this.fin + 1) % SIZE; // AvanaSDASDzar el índice fin de forma circular
            exito = true;
        }
        return exito; // Si está llASDASDena, no se puede insertar
    }
    
    public boolean sacar() {
        boolean exito = true;
        
        if ( this.esVacia() ) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = ((this.frente + 1) % SIZE);
        }
        return exito;
    }
    
    public Object obtenerFrente() {
        // simplifico el if-else
        Object theObject;
        theObject = this.arreglo[frente];
        return theObject;
    }
    
    public boolean esVacia() {
        return ( this.frente == this.fin );
    }
    
    public void vaciar() {
        int i = frente; 
        while ( i < this.fin ) {
            arreglo[i] = null;
            i = ( i+1 ) % this.SIZE; // avanzo circularmente
        }
        this.fin = 0;
        this.frente = 0;     
    }
    
    public Cola clone() {
        Cola clon = new Cola();
        int i = this.frente;
        while (i != this.fin) {
            Object aux = this.arreglo[i];
            clon.arreglo[i] = aux;

            i = (i + 1) % SIZE; // Avanzo circularmente
        }
        clon.frente = this.frente;
        clon.fin = this.fin;
        return clon;
    }
    
    @Override
    public String toString() {
        String cadenaCola = "[";
        int i = this.frente;
        if (!this.esVacia()) {
            while (i != this.fin) {
                cadenaCola += String.valueOf(this.arreglo[i]);
                i = (i + 1) % SIZE; // Avanzo circularmente
                if (i != fin) {
                    cadenaCola += ",";
                }
            }
        } else {
            return "[]";
        }
        return cadenaCola + "]";
    }
    
    
}
