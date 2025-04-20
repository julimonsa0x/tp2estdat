package lineales.estaticas;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-3023
 * @author Julian Nuñez, Legajo FAI-3931
 */
public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int size = 10; 
    
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
        if(this.tope == -1) {
            //Error de pila vacia
            exito = false;
        } else {
            //pone el elemento tope en nulo y baja el tope al espacio anterior
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }
    
    public Object obtenerTope() {
        Object pepe;
        if ( !this.esVacia() ) {
            pepe = this.arreglo[tope];
        } else {
            // error: el tope es nulo --> pila vacia
            pepe = null;
        }
        return pepe;
    } 

    public boolean esVacia() {
        return this.tope == -1;
    }
    
    public void vaciar() {
        // arreglo = new Object[size]; --> es uno por uno el vaciado!!!
        int i;
        for (i = tope; i > -1; i--) {
            this.arreglo[i] = null;
        }
        this.tope = -1;
    }
    

    @Override
    public Pila clone() {
        Pila pilaClone = new Pila();
        pilaClone.arreglo = this.arreglo.clone(); // segun el javadoc de Array.clone(): x.clone() != x :)
        pilaClone.tope = this.tope;
        return pilaClone; 
    }
    
    @Override
    public String toString() {
        String cadena = "[";
        for(int i=tope; i>=0;i--) {
            cadena += this.arreglo[i];
            if(i>0) {
                cadena += ",";
            }
        }
        return cadena + "]";
    }
    
}

