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
    public NodoArbol getLeftChild() {
        return this.izquierdo;
    }
    public NodoArbol getRightChild() {
        return this.derecho;
    }
    public void setRightChild(NodoArbol unHijo) {
        this.derecho = unHijo;
    }
    public void setLeftChild(NodoArbol unHijo) {
        this.izquierdo = unHijo;
    }
}
