package jerarquicas;

public class NodoArbol {
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol() {
        this.elem = null;
        this.izquierdo = null;
        this.derecho = null;
    }

    public NodoArbol(Object elem, NodoArbol izquierdo, NodoArbol derecho) {
        this.elem = elem;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Object getElem() {
        return elem;
    }
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public NodoArbol getHI() {
        return this.izquierdo;
    }
    public NodoArbol getHD() {
        return this.derecho;
    }
    public void setHD(NodoArbol unHijo) {
        this.derecho = unHijo;
    }
    public void setHI(NodoArbol unHijo) {
        this.izquierdo = unHijo;
    }


    public String toString() {
        boolean leftNull = (this.izquierdo != null);
        boolean rightNull = (this.derecho != null);
        return "[HI: "+ ((leftNull) ? this.izquierdo.getElem() : "null") +"]<-(elem: "+this.elem+")->[HD: "+ ((rightNull) ? this.derecho.getElem() : "null") +"]";
    }
    

}
