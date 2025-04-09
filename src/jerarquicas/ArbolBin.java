package jerarquicas;
import lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object objNew, Object elemPadre, char lugar) {

        boolean exito = false;
        lugar = Character.toUpperCase(lugar);
        
        if (this.raiz == null) {
            // arbol vacio -> piso raiz
            this.raiz = new NodoArbol(objNew, null,null);
            exito = true;
        } else {
            // arbol not vacio -> busco padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            // padre existe y lugar disponible -> inserto 
            if (nPadre != null) {
                if( lugar == 'I' && nPadre.getLeftChild() == null ){
                    nPadre.setLeftChild(new NodoArbol(objNew,null,null));
                    exito = true;
                } else if ( lugar == 'D' && nPadre.getRightChild() == null ) {
                    nPadre.setRightChild(new NodoArbol(objNew,null,null));
                    exito = true;
                } 
            }
        } return exito;
    }

    /**
     * @see insertar().
     * @param elNodo
     * @param objBuscado
     * @return NodoArbol contenedor del Object buscado
     */
    private NodoArbol obtenerNodo(NodoArbol elNodo, Object objBuscado) {
        NodoArbol resultado = null;

        if (elNodo != null) {
            if (elNodo.getElem().equals(objBuscado)) {
                // n es el buscado -> devuelvo n
                resultado = elNodo;
            } else {
                // caso contrario -> busco 1ro el HI
                resultado = obtenerNodo(elNodo.getLeftChild(), objBuscado);
                if (resultado == null) {    // HI not found -> busco HD
                    resultado = obtenerNodo(elNodo.getRightChild(), objBuscado);
                }
            }
        }
        return resultado;
    } 

    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    /**
     * @see listarPreorden()
     */
    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO xq su param nodo es de tipo NodoArbol
        if(nodo != null) {
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1); // if lis empty -> inserto en la pos: 0+1

            // sigo en preorden (R->I->D)
            listarPreordenAux(nodo.getLeftChild(), lis);
            listarPreordenAux(nodo.getRightChild(), lis);
        }

    }

    public boolean esVacio(){
        return this.raiz == null;
    }

    public int altura() {
        return alturaRec(this.raiz);
    }

    private int alturaRecGpt(NodoArbol nodo) {
        if (nodo == null) {
            return -1; // altura de un arbol vacio
        } else {
            int alturaIzquierda = alturaRecGpt(nodo.getLeftChild());
            int alturaDerecha = alturaRecGpt(nodo.getRightChild());
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }

    private int alturaRec(NodoArbol n) {
        int r = -1, r1, r2;
        if ( n != null ) {
            if (n.getLeftChild() == null &&  n.getRightChild() == null) {
                r = 0; // hoja
            } else {
                r1 = alturaRec(n.getLeftChild());
                r2 = alturaRec(n.getRightChild());
                if (r1 > r2) {
                    r = r1 + 1;
                } else {
                    r = r2 + 1;
                }
            }
        }
        return r; // arbol vacio -> altura -1, caso contrario altura >= 0
    }

}
