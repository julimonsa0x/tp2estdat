package jerarquicas;

public class NodoGen{
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    /**
     * Unico constructor con 2 parametros!
     * @param unElem
     * @param hijoIzq
     * @param broDer
     */
    public NodoGen(Object unElem, NodoGen hijoIzq, NodoGen broDer) {
        this.elem = unElem;
        this.hijoIzquierdo = hijoIzq;
        this.hermanoDerecho = broDer;
    }


    public Object getElem() {
        return this.elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoGen getHijoIzquierdo() {
        return this.hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoGen hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho() {
        return this.hermanoDerecho;
    }

    public void setHermanoDerecho(NodoGen hermanoDerecho) {
        this.hermanoDerecho = hermanoDerecho;
    }

}