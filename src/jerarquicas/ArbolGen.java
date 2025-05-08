package jerarquicas;
import lineales.dinamicas.Lista;


public class ArbolGen {
    private NodoGen raiz;

    public ArbolGen(){
        this.raiz = null;
    }

    public boolean insertar(Object newElem, Object dadElem) {
        boolean result = false;
        NodoGen hijoInsertado;
        if (this.raiz != null) {
            NodoGen nodoPadre = findPadre(this.raiz, dadElem);
            if (nodoPadre != null) {
                hijoInsertado = new NodoGen(newElem, null, null);
                nodoPadre.setHijoIzquierdo(hijoInsertado);
                result = true;
            } 
        } else {
            this.raiz = new NodoGen(newElem,null,null);
            result = true;
        }
        return result;
    }

    private NodoGen findPadre(NodoGen n, Object dadElem) {
        //boolean found = false;
        NodoGen nodoPadre;
        if ( n != null && n.getElem().equals(dadElem) ) {
            nodoPadre = new NodoGen(n.getElem(), null, null);

        } else {
            nodoPadre = findPadre(n.getHijoIzquierdo(), dadElem);
            if ( nodoPadre != null && nodoPadre.getElem().equals(dadElem) ) {
                nodoPadre = new NodoGen(n.getElem(), null, null);
            } else {
                nodoPadre = findPadre(n.getHermanoDerecho(), dadElem);
            }
        }
        return nodoPadre;
    }



    public Lista listarPreorden() {
        Lista result = new Lista();
        listarPreordenAux(this.raiz, result);
        return result;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {
        if ( n != null ) {
            // visito nodo n
            ls.insertar(n.getElem(), ls.longitud()+1);

            // llamados recursivos con los hijos de n
            NodoGen hijo = n.getHijoIzquierdo();
            while( hijo != null ) {
                listarPreordenAux(hijo, ls);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }


    public boolean esHoja(NodoGen n) {
        return n.getHijoIzquierdo() == null;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            // visita del nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            // comienza recorrido de los hijos de n llamando recursivamente
            // para que cada hijo agregue su subcadena a la general.
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s +=  "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }  
        }
        return s;
    }
    
}