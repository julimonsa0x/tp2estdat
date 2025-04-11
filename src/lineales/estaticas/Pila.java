package lineales.estaticas;

/**
 *
 * @author julian.monsalves
 */
public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int size = 20; 
    
    public Pila() {
        this.arreglo = new Object[size];
        this.tope = -1;
    }
    
    public boolean apilar(Object nuevoElem){
        boolean exito;
        
        if (this.tope+1 >= this.size) {
            // error: pila llena
            exito = false;
        } else {
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }
    
    public boolean desapilar() {
        boolean exito;
        if (this.tope > -1) {
            this.arreglo[tope] = null;
            tope--;
            exito = true;
        } else {
            // error: pila vacia (tope -1)
            exito = false;
        } 
        return exito;
    }
    
    public Object obtenerTope() {
        Object pepe;
        if ( !this.esVacia() ) {
            pepe = this.arreglo[tope];
        } else {
            // error: el tope es nulo porque la pila esta vacia
            pepe = null;
        }
        return pepe;
    } 
    
    /**
     * 
     * @return true si esta vacia, false caso contrario.
     */
    public boolean esVacia() {
        return this.tope == -1;
    }
    
    public void vaciar() {
        arreglo = new Object[size];
        this.tope = -1;
    }
    
    public Pila clone() {
        Pila pilaClone = new Pila();
        pilaClone.arreglo = this.arreglo;
        pilaClone.tope = this.tope;
        return pilaClone; 
    }
    
    @Override
    public String toString() {
        String cadenaPila = "{ ";
        int recorrido = 0;
        if ( !this.esVacia() ) {
            while ( recorrido <= tope ) {
                cadenaPila += ( String.valueOf( this.arreglo[recorrido] )) + ", ";
                recorrido++;
            }
        } else {
            cadenaPila = "Pila estatica vacia}";
        }
        return ( cadenaPila + " }" );
    }
    
}

