package lineales.dinamicas;

/**
 *
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-????
 * @author Julian, Legajo FAI-????
 */
public class Pila {
    private Nodo tope;
    
    public Pila() {
        this.tope = null;
    }
    
    public boolean apilar(Object newElem){
        // crea nuevo nodo delante de la cabecera previa
        Nodo nuevo = new Nodo(newElem, this.tope);
        // actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;
        //nunca hay error de pila llena, siempre devuelve true
        return true;
    }
    
    public boolean desapilar() {
        boolean exito;
        // error: tope de pila nulo
        if (this.tope == null) {
            exito = false;
        } else {
            this.tope = tope.getEnlace();
            exito = true;
        } 
        return exito;
    }
    
    public Object obtenerTope() {
        Object elemTope;
        if ( !this.esVacia() ) {
            elemTope = this.tope.getElem();
        } else {
            // error: el tope es nulo porque la pila esta vacia
            elemTope = null;
        }
        return elemTope;
    } 
    
    public boolean esVacia() {
        return this.tope == null;
    }
    
    public void vaciar() {
        this.tope = null;
    }
    
    public Pila clonar1() {
        Pila topeClon = new Pila();
        Nodo nodoClon = new Nodo(this.tope.getElem(), this.tope.getEnlace());
        topeClon.tope = nodoClon;
        return topeClon;
    }
    
    
    @Override
    public Pila clone(){
        Pila clonPila = new Pila();
        clonPila.tope = clonarRecursivo(this.tope);
        return clonPila;
    }
    private Nodo clonarRecursivo(Nodo proxNodo) {
        /*Nodo nuevoNodo;
        if( proxNodo == null ){
            nuevoNodo = null;
        } else {
            nuevoNodo = new Nodo(proxNodo.getElem(), clonarRecursivo( proxNodo.getEnlace() ));
        }*/
        Nodo nuevoNodo = ( proxNodo == null ) ? null : new Nodo(proxNodo.getElem(), clonarRecursivo( proxNodo.getEnlace() ));
        return nuevoNodo;
    }
    
    
    @Override
    public String toString() {
        String s = "";
        
        if ( this.tope == null ){
            //s = "Pila dinamica vacia"; rompe el @Test --> testCreateEmptyStack()
            s = "[]";
        } else {
            Nodo aux = this.tope;
            s = "[";
            
            while (aux != null) {
                s += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ",";
                }
            }
            s += "]";
        }
        return s;
    }
    
    
}
