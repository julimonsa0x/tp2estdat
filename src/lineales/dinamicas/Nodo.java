package lineales.dinamicas;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-????
 * @author Julian, Legajo FAI-????
 */
public class Nodo {
    private Object elem;
    private Nodo enlace;
    
    public Nodo(Object elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }
    
    // setters
    public void setElem(Object elem) {
        this.elem = elem;
    }
    
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
    //getters
    public Object getElem(){
        return elem;
    }
    
    public Nodo getEnlace(){
        return enlace;
    }
}
