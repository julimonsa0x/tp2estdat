package lineales.dinamicas;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-3023
 * @author Julian Nuñez, Legajo FAI-3931
 */
public class Nodo {
    private Object elem;
    private Nodo enlace;
    
    public Nodo(Object elem, Nodo enlace) {
        this.elem = elem;
        this.enlace = enlace;
    }
    
    public void setElem(Object elem) {
        this.elem = elem;
    }
    
    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }
    
    public Object getElem(){
        return elem;
    }
    
    public Nodo getEnlace(){
        return enlace;
    }
}
