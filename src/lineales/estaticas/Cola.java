package lineales.estaticas;

/**
 *
 * @author julian.monsalves
 */
public class Cola {
    private int frente;
    private int fin;
    private static final int SIZE = 10; // tamanio fijo estatico circular
    private Object[] arreglo;
    
    public Cola() {
        this.arreglo = new Object[this.SIZE];
        this.frente = 0;
        this.fin = 0;
    }
    
    public boolean poner(Object obj) {
        boolean exito;
        // si se desborda al acceder arreglo
        if (this.fin+1 == SIZE) {

            this.fin = (this.fin+1)%SIZE;
            this.arreglo[fin] = obj;
            //this.fin++;
            exito = true;
        }
        // si no esta llena
        if ( !(this.fin + 1 == this.frente) ) {
            this.arreglo[fin] = obj;
            this.fin++;
            exito = true;
        } else {
            exito = false;
        }
        return exito;
    }
    
    public boolean sacar() {
        boolean exito = true;
        
        if ( this.esVacia() ) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.SIZE;

        }
        return exito;
    }
    
    public Object getObjFrente() {
        Object theObject;
        if ( !this.esVacia() ) {
            theObject = this.arreglo[frente];
        } else {
            theObject = null;
        }
        return theObject;
    }
    
    public boolean esVacia() {
        return ( this.frente == this.fin);
    }
    
    public void vaciar() {
        this.arreglo = new Object[SIZE];
        this.frente = 0;
        this.fin = 0;
                
    }
    
    public Cola clonar() {
        
    }
    
    @Override
    public String toString(){
        String cadenaCola = "{ ";
        int visitados = 0, i;
        if ( !this.esVacia() ) {
            // visito SIZE-1 elementos (incluyo nulos)
            // voy de frente a fin considerando el desborde con MOD
            for ( i = 0; i < SIZE; i++ ) {
                if ( !(this.fin+1 == SIZE) ) {
                    visitados = this.frente;
                    cadenaCola += ( String.valueOf( this.arreglo[visitados] )) + ", ";
                    visitados++;

                } else {
                    this.fin = (this.fin+1)%SIZE;
                    visitados = this.fin;
                    cadenaCola += ( String.valueOf( this.arreglo[visitados] )) + ", ";
                    
                }
            }
        } else {
            cadenaCola = "Pila estatica vacia}";
        }
        return ( cadenaCola + " }" );
    }
    
}
