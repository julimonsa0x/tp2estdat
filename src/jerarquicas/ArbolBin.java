package jerarquicas;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolBin {
    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }
    public ArbolBin(NodoArbol unaRaizPrecargada){
        this.raiz = unaRaizPrecargada;
    }

    /**
     * Dado un elemento elemNuevo y un elemento elemPadre, inserta elemNuevo como hijo izquierdo o
     * derecho de la primer aparición de elemPadre, según lo indique el parámetro posHijo. 
     * Para que la operación termine con éxito debe existir un nodo en el árbol con elemento = elemPadre
     * y ese nodo debe tener libre su hijo posHijo.
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
                if( lugar == 'I' && nPadre.getHI() == null ){
                    nPadre.setHI( new NodoArbol(objNew, null, null) );
                    exito = true;
                } else if ( lugar == 'D' && nPadre.getHD() == null ) {
                    nPadre.setHD( new NodoArbol(objNew, null, null) );
                    exito = true;
                } 
            }
        } 
        return exito;
    }

    /**
     * @see <code> insertar() </code>
     * @param elNodo debe ser this.raiz (o alguna raiz de un subarbol) para buscar.
     * @param objBuscado el elemento a buscar en el arbol
     * @return {@code NodoArbol} contenedor del Object buscado o {@code null} si no existe (arbol vacio)\
     * @implNote Complejidad O(n) en el peor de los casos
     * @recorrido preorden
     */
    private NodoArbol obtenerNodo(NodoArbol elNodo, Object objBuscado) {
        NodoArbol resultado = null;
        if (elNodo != null) {
            if (elNodo.getElem().equals(objBuscado)) {
                // caso base: n es el buscado -> devuelvo n
                resultado = elNodo;
            } else {
                // caso contrario -> busco 1ro el HI
                resultado = obtenerNodo(elNodo.getHI(), objBuscado);
                if (resultado == null) {    // HI not found -> busco HD
                    resultado = obtenerNodo(elNodo.getHD(), objBuscado);
                }
            }
        }
        return resultado;
    } 

    /**
     * ¿Cuándo conviene listar Inorden?<br>
     * 📊 Para obtener los elementos ordenados si el árbol es un árbol binario de búsqueda (ABB).<br>
     * 🧠 Útil cuando te importa el orden natural o alfabético de los datos.<br>
     * 🔄 También se usa para evaluar expresiones matemáticas infix (como {@code (2 + 3) * 4}).<br>
     * @return {@code Lista dinamica (I->R->D)} if arbol !vacio, {@code Lista vacia} [] else.
     */
    public Lista listarInorden() {
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO xq su param nodo expone la estructura interna de la clase.
        if(nodo != null) {
            listarInordenAux(nodo.getHI(), lis); // subarbol izq ([I] -> R -> D) en inorden.
            // logica sobre el nodo (I -> [R] -> D)
            lis.insertar(nodo.getElem(), lis.longitud()+1);
            listarInordenAux(nodo.getHD(), lis); // subarbol der (I -> R -> [D]) en inorden.
        }
    }

    /**
     * ¿Cuando conviene listar en posorden?<br>
     * 🧹 Para eliminar, liberar o limpiar un árbol, ya que borra los hijos antes que el nodo padre.<br> 
     * 🧮 Para evaluar expresiones posfijas (como 2 3 + 4 *, notación posfija).<br>
     * 📄 Para listar los elementos completamente procesados, cuando cada nodo depende de sus hijos.<br>
     * @return {@code Lista dinamica (I->D->R)} if arbol !vacio, {@code Lista vacia} [] else.
     */
    public Lista listarPosorden() {
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        // Metodo recursivo PRIVADO xq su param. NodoArbol expone la estructura de la clase.
        if(nodo != null) {
            listarPosordenAux( nodo.getHI(), lis ); // subarbol izq ([I] -> D -> R) en posorden.
            listarPosordenAux( nodo.getHD(), lis ); // subarbol der (... -> [D] -> R) en posorden.

            // visito el elemento en el nodo tras finalizar el recorrido posorden de algún subarbol n (n-esima llamada recursiva).
            lis.insertar( nodo.getElem(), lis.longitud() + 1 );
        }
    }

    /**
     * ¿Cuándo conviene listar en preorden?<br>
     * 🔍 Para buscar un elemento si te interesa detectar rápido si existe, ya que se visita la raíz primero y puedes podar ramas.<br>
     * 📄 Para clonar o copiar un árbol (porque se necesita procesar el nodo antes de sus hijos).<br>
     * 💾 Para serializar un árbol (guardar su estructura en texto).<br>
     * @return {@code Lista dinamica (R->I->D)} if arbol !vacio, {@code Lista vacia} [] else.
     */
    public Lista listarPreorden() {
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        // Metodo recursivo PRIVADO xq su param. NodoArbol expone la estructura de la clase.
        if(nodo != null) {
            // visita el elemento en el nodo, osea la raiz
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarPreordenAux(nodo.getHI(), lis); // subarbol izq (.. -> [I] -> D) en preorden.
            listarPreordenAux(nodo.getHD(), lis); // subarbol der (.. -> [D] ) en preorden.
        }
    }

	/**
	 * @return {@code Lista orden por niveles (BFS)} if arbol !vacio, {@code Lista vacia []} else.
	 */
    public Lista listarPorNiveles() {
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
                if ( nodoActual.getHI() != null ) {
                    lvlQueue.poner(nodoActual.getHI());
                }
                if ( nodoActual.getHD() != null ) {
                    lvlQueue.poner(nodoActual.getHD());
                }
            }
        }
    }

    /**
     * @return true if arbol vacio, false else
     * @see <code> vaciar() </code>
     */
    public boolean esVacio() {
        return ( this.raiz == null );
    }

    public void vaciar(){
        this.raiz = null;
    }

    /**
     * Util recordar el concepto de nivel, voy de raiz (lvl0) a hoja (lvl n).
     * @return altura del árbol, es decir la longitud del camino más largo desde la raíz hasta una hoja
     */
    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoArbol nodo) {
        int altura;
        if (nodo == null) {
            altura = -1; // altura de un arbol vacio
        } else {
            int alturaIzquierda = alturaAux( nodo.getHI() );
            int alturaDerecha = alturaAux( nodo.getHD() );
            altura = Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
        return altura;
    }

    /**
	 * @TESTED & DEBUGGED
     * Resumen estructuras pdf del drive
     
    private int alturaRec(NodoArbol nodo) {
        int altura = -1, r1, r2;
        if ( nodo != null ) {
            if (nodo.getHI() == null &&  nodo.getHD() == null) {
                altura = 0; // caso base - hoja
            } else {
                r1 = alturaRec(nodo.getHI());
                r2 = alturaRec(nodo.getHD());
                altura = Math.max(r1, r2) + 1;
            }
        }
        return altura; // arbol vacio -> altura -1, caso contrario altura >= 0
    }*/

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
        posHijo = Character.toUpperCase(posHijo); // para evitar problemas con minusculas
        if (this.raiz == null) {
            // caso base o especial: arbol vacio -> piso raiz
            this.raiz = new NodoArbol(elemNuevo, null,null);
            exito = true;
        } else {
            // cualquier otro caso -> busco al padre
            // si posPadre esta dentro del rango de la lista en preorden --> no sera null
            NodoArbol nPadre = obtenerNodoPorPos(this.raiz, posPadre);

            if (nPadre != null) {
                // entro solo si el nPadre fue encontrado, lo que implica que posPadre sea valido!!
                if( posHijo == 'I' && nPadre.getHI() == null ){
                    nPadre.setHI(new NodoArbol(elemNuevo,null,null));
                    exito = true;
                } else if ( posHijo == 'D' && nPadre.getHD() == null ) {
                    nPadre.setHD(new NodoArbol(elemNuevo,null,null));
                    exito = true;
                } 
            }
        } return exito;
    }

    private NodoArbol obtenerNodoPorPos(NodoArbol elNodo, int posBuscada) {
        NodoArbol resultado = null;
        // decrementar n hasta llegar a 1 mientras recorro en preorden, en el caso base se llega al nodo buscado
        if (elNodo != null) {
            if (posBuscada == 1) {
                // n es el buscado -> devuelvo n. en caso que el nodo buscado no exista en el arbol, esto nunca se triggerea y en el else retorno un null.
                resultado = elNodo;
            } else {
                // caso contrario -> busco 1ro el HI
                resultado = obtenerNodoPorPos(elNodo.getHI(), posBuscada - 1);
                if (resultado == null) {    // HI not found -> busco HD
                    resultado = obtenerNodoPorPos(elNodo.getHD(), posBuscada - 1);
                }
            }
        }
		return resultado;
    }


    /**
     * Def. recursiva de Nivel:<br>
     * |_ Nivel raiz = 0<br>
     * |_ Nivel hijos = 1 + nivel de su padre<br>
     * @return el nivel de elem en el árbol. Si elem no existe en árbol --> -1
     */
    public int nivelDe(Object elem) {
        int nivel = -1;
        if (this.raiz != null) {
            nivel = nivelAux(this.raiz, elem, 0);
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
    private int nivelAux(NodoArbol nodo, Object elem, int nivel) {
        int resultado = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                resultado = nivel; // si lo encuentro no sumo mas niveles
            } else {
                // busco en HI y HD (subarboles izquierdo y derecho respectivamente) y sumo 1 al nivel
                resultado = nivelAux(nodo.getHI(), elem, nivel + 1);
                if (resultado == -1) { // no lo encontre en HI
                    resultado = nivelAux(nodo.getHD(), elem, nivel + 1); // lo busco en HD
                }
            }
        }
        return resultado;
    }

    /**
     * @recorrido preorden
     * @param elemHijo el elemento hijo
     * @return el {@code Object padre} del elemento hijo, o null si no existe o es la raiz.
     */
    public Object padreDe(Object elemHijo) {
        Object resultado = null;
        if ( this.raiz != null && this.raiz.getElem().equals(elemHijo) ) {
            resultado = null; // caso especial: la raiz no tiene padre
        } else if ( this.raiz != null ) {
            resultado = padreDeAux(this.raiz, elemHijo);
        }
        return resultado;
    }
    
    private Object padreDeAux(NodoArbol nActual, Object elemHijo) {
        Object resultado = null;
        if (nActual != null) {
            if ( nActual.getHI() != null && nActual.getHI().getElem().equals(elemHijo) ) { //  si el HI existe y coincide
                resultado = nActual.getElem();  // el padre es el nodo actual
            } else if ( nActual.getHD() != null && nActual.getHD().getElem().equals(elemHijo) ) { // sino, si el HD existe y coincide
                resultado = nActual.getElem();
            }
    
            if (resultado == null) {
                resultado = padreDeAux( nActual.getHI(), elemHijo ); // busco en subarbol izq. si no encontre
            }
            if (resultado == null) {
                resultado = padreDeAux( nActual.getHD(), elemHijo ); // busco en subarbol der. si sigo sin encontrar
            }
            // System.out.println("resultado: "+ resultado);
        }
        return resultado;
    }
    
    @Override
    /**
     * @recorrido preorden (primero raiz, luego hijos)
     * @implNote Complejidad O(n) siempre (clono 1:1 los n nodos que existan)
     */
    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }
    
    private NodoArbol cloneAux(NodoArbol nodoOriginal) {
        NodoArbol nodoClonado;
        if (nodoOriginal == null) {
            nodoClonado = null;
        } else {
            nodoClonado = new NodoArbol( nodoOriginal.getElem(), null, null );
            nodoClonado.setHI( cloneAux( nodoOriginal.getHI() ) ); 
            nodoClonado.setHD( cloneAux( nodoOriginal.getHD() ) );
        }
        return nodoClonado;
    }
    
    public boolean equals(ArbolBin otroArbol) {
        boolean iguales = false;
        if ( otroArbol != null ) {
            if ( this.raiz == null && otroArbol.raiz == null ) {
                iguales = true; // ambos nulos
            } else if ( this.raiz != null && otroArbol.raiz != null ) {
                iguales = equalsAux(this.raiz, otroArbol.raiz);
            }   
        }
        return iguales;
    }

    private boolean equalsAux(NodoArbol n1, NodoArbol n2) {
        boolean iguales = false;
        if (n1 != null && n2 != null) {
            if ( n1.getElem().equals(n2.getElem()) ) {
                iguales = equalsAux( n1.getHI(), n2.getHI() );
            }
            if ( iguales ) {
                iguales = equalsAux( n1.getHD(), n2.getHD() );
            }
        } else if (n1 == null && n2 == null) {
            iguales = true; // caso base: ambos son null (hojas)
        }
        return iguales;
    }

    /**
     * @recorrido por niveles (BFS)
     * @return String con la representacion del arbol por niveles (BFS)
     */
    public String toString() {
        /*
        Esta logica hacia casi lo mismo, usando una lista BFS del arbol
        pero reutilizaba el obtenerNodo() el cual, dentro de un for,
        me parece que hace O(n^2) en el peor de los casos.
        Por ejemplo, el toString() al querer mostrar el tercer nodo (C en BFS)
        que estaba en el 1er subarbol derecho, al llamar  obtenerNodo() recorria
        los n nodos que mi subarbol izquierdo hubiera tenido, y eso no me gusta.

		String result = " ";
		Lista listNodos = this.listarPorNiveles();
		// formatear esta chanchada de string 
		for (int i = 1; i <= listNodos.longitud(); i++) {
            NodoArbol nodoActual = this.raiz;
            nodoActual = this.obtenerNodo(nodoActual, listNodos.recuperar(i));
            if ( nodoActual != null ) {
				result += 	(nodoActual != null ? nodoActual.getElem() : "_") 
							+ " --> HI: " + (nodoActual.getLeftChild() != null ? nodoActual.getLeftChild().getElem() : "_") 
							+ " | HD: " + (nodoActual.getRightChild() != null ? nodoActual.getRightChild().getElem() : "_") + "\n ";
			}
		}
		return result;
        */
        String result = " ";
        Cola colaNodos = new Cola();

        if (this.raiz != null) {
            colaNodos.poner(this.raiz);
        }

        while ( !colaNodos.esVacia() ) {
            NodoArbol nodoActual = (NodoArbol) colaNodos.obtenerFrente(); // simulo el .poll() o el .pop() de python.
            colaNodos.sacar(); // simulo el .poll() de java o el .pop() de python.

            // "visito" --> logica del toString()
            Object objActual = nodoActual.getElem();
            result += (objActual) 
                    + " --> HI: " + (nodoActual.getHI() != null ? nodoActual.getHI().getElem() : "_") 
                    + " | HD: " + (nodoActual.getHD() != null ? nodoActual.getHD().getElem() : "_") + "\n ";

            if ( nodoActual.getHI() != null ) {
                colaNodos.poner( nodoActual.getHI() );
            }
            if ( nodoActual.getHD() != null ) {
                colaNodos.poner( nodoActual.getHD() );
            }
        }
        
        return result;
    }

    /* ========== Metodos Extras ========== */
    /* ========== Metodos Extras ========== */
    /* ========== Metodos Extras ========== */
    /* ========== Metodos Extras ========== */

    /**
     * @recorrido posorden
     * @return Lista con los elementos de las hojas de izquierda a derecha.
     */
    public Lista frontera()  {
        Lista listaHojas = new Lista();
        fronteraAux(this.raiz, listaHojas);
        return listaHojas;
    }

    private void fronteraAux(NodoArbol nodo, Lista listaHojas) {
        if (nodo != null) {
            fronteraAux(nodo.getHI(), listaHojas);
            fronteraAux(nodo.getHD(), listaHojas);
            if ( nodo.getHI() == null && nodo.getHD() == null ) { // si nodo es hoja entonces...
                listaHojas.insertar(nodo.getElem(), listaHojas.longitud() + 1);
            }
        }
    }

    /**
     * @param elem el elemento a buscar
     * @recorrido posorden (pareciera que es preorden por el caso base ...equals().. pero solo se triggerea una vez)
     * @implNote Complejidad O(n) en el peor de los casos
     * @return Lista todos los ancestros, [] si elem no esta
     */
    public Lista obtenerAncestrosDe(Object elem) {
        Lista listaAncestros = new Lista();
        obtenerAncestrosAux(this.raiz, listaAncestros, elem);
        return listaAncestros;
    }
    
    private boolean obtenerAncestrosAux(NodoArbol nodoActual, Lista listaAncestros, Object buscado) {
        boolean nodoEncontrado = false;
        if (nodoActual != null) { // caso base --> llegue a alguna hoja
            if ( nodoActual.getElem().equals(buscado) ) {
                nodoEncontrado = true;
            } else {
                // Agregamos el nodoActual actual como posible ancestro
                // listaAncestros.insertar( nodoActual.getElem(), listaAncestros.longitud() + 1 ); esto me carga los elementos en la lista a la ida --> la lista queda invertida []..., bis., abue., padre, actual]
  
                // recorro subarbol izquierdo del nodoActual
                nodoEncontrado = obtenerAncestrosAux( nodoActual.getHI(), listaAncestros, buscado );
                if ( !nodoEncontrado ) {    // si no esta en subarbol izq. busco en el derecho
                    nodoEncontrado = obtenerAncestrosAux( nodoActual.getHD(), listaAncestros, buscado );
                }
                if ( !nodoEncontrado ) {
                    // Si no encontramos el nodoActual, no es ancestro válido
                    //listaAncestros.eliminar( listaAncestros.longitud() ); // eliminamos el último insertado
                } else {  // con este cambio de linea agrego los elementos a la vuelta y no a la ida!!!
                    listaAncestros.insertar( nodoActual.getElem(), listaAncestros.longitud() + 1 ); // aca SI cargo "a la vuelta", en caso de querer ver como cargaba "a la ida", quitar este else y descomentar las lineas 475 y 484 
                } 
            }
        }
        return nodoEncontrado;
    }

    /**
     * @recorrido preorden
     * @return una lista todos los descendientes del elemento pasado por parámetro (si elem no esta, devuelve lista vacia)
     * @param elem el elemento de algun nodo del cual listaremos sus descendientes
     */
    public Lista obtenerDescendientesDe(Object elem) {
        Lista listaDescendientes = new Lista();
        if ( this.raiz != null ) {
            if ( this.raiz.getElem().equals(elem) ) {
                // Si llamo con la raíz, se agregan todos los descendientes.
                //      estaria bueno en el futuro agregarle un parametro para cambiar como listarlo
                //      podria ser en DFS: listarInorden() o listarPosorden() o listarPreorden()
                listaDescendientes = listarPorNiveles(); 
            } else {
                // sino buscamos el nodo y sus descendientes
                NodoArbol nodoBuscado = obtenerNodo(this.raiz, elem);
                obtenerDescendientesAux(nodoBuscado, listaDescendientes);
            }
        }
        return listaDescendientes;
    }

    private void obtenerDescendientesAux(NodoArbol nodoActual, Lista lista) {
        if (nodoActual != null) {
            if ( nodoActual.getHI() != null ) {
                lista.insertar( nodoActual.getHI().getElem(), lista.longitud() + 1 );
                obtenerDescendientesAux( nodoActual.getHI(), lista );
            }
            if ( nodoActual.getHD() != null ) {
                lista.insertar( nodoActual.getHD().getElem(), lista.longitud() + 1 );
                obtenerDescendientesAux( nodoActual.getHD(), lista );
            }
        }
    }

    /**
     * Verifica si el patrón coincide exactamente con algún camino desde la raíz hasta una hoja.
     * 
     * @param patron lista de elementos que representan un posible camino.
     * @return true si el patrón coincide exactamente con un camino del árbol; false en caso contrario.
     * @implNote un patron vacio coincide con un árbol vacío -> retorna true, esta bien? 
     */
    public boolean verificarPatron(Lista patron) {
        boolean patronValido;
        int posActual = 1; // rango lista 1~n
        if ( this.esVacio() && patron.esVacia() ) { // --> seria comparar  [] contra [] hace falta???
            patronValido = true;
        } else {
            patronValido = verificarPatronAux(this.raiz, patron, posActual);
        }
        return patronValido;
    }
    private boolean verificarPatronAux(NodoArbol nActual, Lista elPatron, int posNodoPatron) {
        boolean mismoNodoActual = false;
        if ( nActual != null ) { // caso base corto recursion
            if ( nActual.getElem().equals( elPatron.recuperar( posNodoPatron ) ) ) { // si son iguales...
                if ( nActual.getHI() != null && elPatron.recuperar( posNodoPatron + 1 ) != null ) { // si los siguientes son ambos iguales...
                    mismoNodoActual = verificarPatronAux( nActual.getHI(), elPatron, posNodoPatron+1 ); // bajo a la izq., recursivamente.
                    if ( !mismoNodoActual ) { // no encontre en subarbol izq...
                        mismoNodoActual = verificarPatronAux( nActual.getHD(), elPatron, posNodoPatron+1 ); // entonces busco subarbol der...
                    }
                } else if ( nActual.getHI() == null && nActual.getHD() == null && elPatron.recuperar( posNodoPatron + 1 ) == null ) { // solo si llegue a una hoja y el proximo en la lista es null, corto.
                    mismoNodoActual = true;
                }
            }
        }
        return mismoNodoActual;
    }

    public ArbolBin clonarInvertido() {
        ArbolBin nuevo = new ArbolBin();
        nuevo.raiz = clonarInvertidoAux(raiz);
        return nuevo;
    }
    
    private NodoArbol clonarInvertidoAux(NodoArbol nodoActual) {
        NodoArbol nodoMirrored;
        if (nodoActual == null) {
            nodoMirrored = null;
        } else { 
            // Create a new node with the same data
            nodoMirrored = new NodoArbol( nodoActual.getElem(), null, null );
            // Clono de manera recursiva el subarbol izquierdo actual y lo asigno a la derecha
            nodoMirrored.setHD(clonarInvertidoAux( nodoActual.getHI() ));
            // lo mismo con subarbol izquierdo actual, lo asigno a la izquierda
            nodoMirrored.setHI(clonarInvertidoAux( nodoActual.getHD() ));
        }
        return nodoMirrored;
    }
    
    /**
     * @implNote dificil de testear puesto que requiere un arbol bien construido, ideal pedirle a chatgpt una creacion de arbol a partir de un unico NodoArbol, puesto que insertar nodos repetidos pisa las referencias y crea arboles feos que no se condicen con lo deseado!!!
     * @param elem elemento repetido a buscar
     * @return true if elem esta 2 o mas veces en el arbol
     */
    public boolean estaRepetido(Object elem) {
        return estaRepetidoAux(elem, this.raiz, 0);
    }
    private boolean estaRepetidoAux(Object buscado, NodoArbol nodoActual, int repes) {
        boolean masDeDosVeces = false;
        int cont = repes;
        if ( nodoActual != null ) {
            if ( nodoActual.getElem().equals(buscado) ) {
                cont++;
                if ( cont > 1 ) {
                    masDeDosVeces = true;
                }
            }
            if ( !masDeDosVeces ) {
                masDeDosVeces = estaRepetidoAux(buscado, nodoActual.getHI(), cont);
            }
            if ( !masDeDosVeces ) {
                masDeDosVeces = estaRepetidoAux(buscado, nodoActual.getHD(), cont);
            }
        }
        return masDeDosVeces;
    }

    /**
     * Ejercicio de parcial 2018
     * @param nodoInicial de tipo entero y no Object porque se asume {@code this.class() ArbolBin <int>}
     * @return lista inorden del subarbol que tiene como raiz a nodoInicial
     */
    public Lista armarListaInordenDesde(Object nodoInicial) {
        Lista lisDesde = new Lista();
        NodoArbol newRaiz = obtenerNodo(this.raiz, nodoInicial);
        armarListaInordenDesdeAux(newRaiz, lisDesde);
        return lisDesde;
    }
    private void armarListaInordenDesdeAux( NodoArbol start, Lista laLista ){
        if ( start != null ) {
            armarListaInordenDesdeAux(start.getHI(), laLista);
            laLista.insertar(start.getElem(), laLista.longitud() + 1);
            armarListaInordenDesdeAux(start.getHD(), laLista);

        }
    }

}