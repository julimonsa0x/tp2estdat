package lineales.estaticas;

/**
 *
 * @author julian.monsalves
 */
public class Cola {
    private int frente;
    private int fin;
    private static final int SIZE = 6; // tamanio fijo estatico circular
    private Object[] arreglo;
    
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
        // simplified if-else
        Object theObject;
        theObject = this.arreglo[frente];
        return theObject;
    }
    
    public boolean esVacia() {
        return ( this.frente == this.fin);
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
    
    public Cola clonar() {
        return new Cola();
    }
    
    @Override
    public String toString() {
        String cadenaCola = "[";
        if (!this.esVacia()) {
            int i = this.frente;
            while (i != this.fin) {
                cadenaCola += String.valueOf(this.arreglo[i]) + ", ";
                i = (i + 1) % SIZE; // Avanzo circularmente+
            }
        } else {
            return "[]";
        }
        return cadenaCola + "]";
    }
    
    
}
