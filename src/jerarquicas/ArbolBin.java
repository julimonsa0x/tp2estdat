package jerarquicas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    /**
     * 
     * @param objNew el objeto a ingresar en el nodo
     * @param elemPadre nodo padre
     * @param lugar 'I' hijo izq, 'D' hijo der, else {@code returns false}
     * @return {@code true} al insertar con exito, {@code false} caso contrario
     */
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
        } 
        return exito;
    }

    /**
     * @see <code> insertar() </code>
     * @param elNodo
     * @param objBuscado
     * @return {@code NodoArbol} contenedor del Object buscado o {@code null} si no existe (arbol vacio)
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

    public Lista listarInorden() {
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO xq su param nodo es de tipo NodoArbol
        if(nodo != null) {
            // sigo en inorden (I->R->D)
            listarInordenAux(nodo.getLeftChild(), lis);

            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1); // if lis empty -> inserto en la pos: 0+1

            listarInordenAux(nodo.getRightChild(), lis);
        }
    }

    public Lista listarPostorden() {
        Lista lis = new Lista();
        listarPostordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPostordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO xq su param nodo es de tipo NodoArbol
        if(nodo != null) {
            // sigo en postorden (I->D->R)
            listarPostordenAux(nodo.getLeftChild(), lis);
            listarPostordenAux(nodo.getRightChild(), lis);

            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud()+1); // if lis empty -> inserto en la pos: 0+1
        }
    }

    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    /**
     * @see <code> listarPreorden() </code>
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

	/**
	 * TESTED & DEBUGGED
	 * @return Lista con los elementos del arbol en orden por niveles BFS (Breadth First Search)
	 */
    public Lista listarPorNiveles(){
        Lista lis = new Lista();
        listarPorNivelesAux(this.raiz, lis);
        return lis;
    }

    private void listarPorNivelesAux(NodoArbol nodo, Lista list) {
        Cola lvlQueue = new Cola();
        if (nodo != null) {
            lvlQueue.poner(this.raiz);
            while( ! lvlQueue.esVacia() ) {
                NodoArbol nodoActual = (NodoArbol) lvlQueue.obtenerFrente();
                lvlQueue.sacar();
                list.insertar(nodoActual.getElem(), list.longitud()+1); // if lis empty -> inserto en la pos: 0+1
                if ( nodoActual.getLeftChild() != null ) {
                    lvlQueue.poner(nodoActual.getLeftChild());
                }
                if ( nodoActual.getRightChild() != null ) {
                    lvlQueue.poner(nodoActual.getRightChild());
                }
            }
        }
    }

    /**
     * 
     * @return altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja
     */
    public int altura() {
        return alturaRec(this.raiz);
    }

    // temporal method !!!
    public int alturaGpt(){
        return alturaRecGpt(this.raiz);
    }

    private int alturaRecGpt(NodoArbol nodo) {
        int altura;
        if (nodo == null) {
            altura = -1; // altura de un arbol vacio
        } else {
            int alturaIzquierda = alturaRecGpt(nodo.getLeftChild());
            int alturaDerecha = alturaRecGpt(nodo.getRightChild());
            altura = Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
        return altura;
    }

    /**
	 * @TESTED & DEBUGGED
     * Resumen estructuras pdf del drive
     * @param n
     * @return altura int
     */
    private int alturaRec(NodoArbol nodo) {
        int altura = -1, r1, r2;
        if ( nodo != null ) {
            if (nodo.getLeftChild() == null &&  nodo.getRightChild() == null) {
                altura = 0; // hoja
            } else {
                r1 = alturaRec(nodo.getLeftChild());
                r2 = alturaRec(nodo.getRightChild());
                if (r1 > r2) {
                    altura = r1 + 1;
                } else {
                    altura = r2 + 1;
                }
            }
        }
        return altura; // arbol vacio -> altura -1, caso contrario altura >= 0
    }

    /**
     *  Dado un Object elemNuevo y la posición (1~n) numérica de su padre en el árbol en preorden, agrega
     *  elemNuevo como hijo izquierdo o derecho del elemento cuya posición en preorden dentro del árbol sea la
     *  dada, y según lo indique el parámetro posHijo. Para que la operación termine con éxito debe existir un
     *  nodo en el árbol cuya posición en preorden sea válida y ese nodo debe tener libre su hijo posHijo. Esta
     *  operación devuelve verdadero cuando se pudo agregar elemNuevo a la estructura y falso en caso contrario.
     * @param elemNuevo el hijo a agregar.
     * @param posPadre la posicion en preorden del padre (1~n).
     * @param posHijo 'I' o 'D' para hijo izq., o der., respectivamente.
     * @return
     */
    public boolean insertarPorPosicion(Object elemNuevo, int posPadre, char posHijo){
        boolean exito = false;
        if (this.raiz == null) {
            // arbol vacio -> piso raiz
            this.raiz = new NodoArbol(elemNuevo, null,null);
            exito = true;
        } else {
            // arbol no vacio -> busco padre
            // si posPadre esta dentro del rango de la lista en preorden --> no sera null
            NodoArbol nPadre = obtenerNodoPorPos(this.raiz, posPadre);

            if (nPadre != null) {
                // entro solo si el nPadre fue encontrado, lo que implica que posPadre sea valido!
                if( posHijo == 'I' && nPadre.getLeftChild() == null ){
                    nPadre.setLeftChild(new NodoArbol(elemNuevo,null,null));
                    exito = true;
                } else if ( posHijo == 'D' && nPadre.getRightChild() == null ) {
                    nPadre.setRightChild(new NodoArbol(elemNuevo,null,null));
                    exito = true;
                } 
            }
        } return exito;
    }

    private NodoArbol obtenerNodoPorPos(NodoArbol elNodo, int posBuscada) {
        NodoArbol resultado = null;
        // implementacion a) decrementar n hasta llegar a 1 mientras recorro en preorden, en el caso base se llega al nodo buscado
        if (elNodo != null) {
            if (posBuscada == 1) {
                // n es el buscado -> devuelvo n
                resultado = elNodo;
            } else {
                // caso contrario -> busco 1ro el HI
                resultado = obtenerNodoPorPos(elNodo.getLeftChild(), posBuscada - 1);
                if (resultado == null) {    // HI not found -> busco HD
                    resultado = obtenerNodoPorPos(elNodo.getRightChild(), posBuscada - 1);
                }
            }
        }
		return resultado;
    }


    /**
     * @return el nivel de elem en el árbol. Si elem no existe en árbol --> -1
     */
    public int nivel(Object elem) {
        int nivel = -1;
        if (this.raiz != null) {
            nivel = nivelRec(this.raiz, elem, 0);
        }
        return nivel;
    }

    /**
     * 
     * @param nodo para avanzar en los subarboles
     * @param elem Object a buscar
     * @param nivel int nivel acumulado cada que bajo a un hijo (subarbol)
     * @see <code> nivel() </code>
     */
    private int nivelRec(NodoArbol nodo, Object elem, int nivel) {
        int resultado = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                resultado = nivel; // el elemento fue encontrado
            } else {
                // busco en HI y HD (subarboles izquierdo y derecho respectivamente)
                resultado = nivelRec(nodo.getLeftChild(), elem, nivel + 1);
                if (resultado == -1) { // no lo encontre en HI
                    resultado = nivelRec(nodo.getRightChild(), elem, nivel + 1);
                }
            }
        }
        return resultado;
    }



    public void vaciar(){
        this.raiz = null;
    }

	
    @Override
    public String toString() {
		String result = " ";
		Lista listNodos = this.listarPorNiveles();
		
		for (int i = 1; i <= listNodos.longitud(); i++) {
			NodoArbol nodoActual = this.raiz;
			if ( nodoActual != null ) {
				nodoActual = this.obtenerNodo(nodoActual, listNodos.recuperar(i));
				result += 	(nodoActual != null ? nodoActual.getElem() : "_") 
							+ " --> HI: " + (nodoActual.getLeftChild() != null ? nodoActual.getLeftChild().getElem() : "_") 
							+ " | HD: " + (nodoActual.getRightChild() != null ? nodoActual.getRightChild().getElem() : "_") + "\n ";
			}
		}
		return result;
    }

    /* Metodos propios para testear */


}
