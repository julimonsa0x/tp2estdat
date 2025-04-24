package lineales.dinamicas;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-3023
 * @author Julian Nuñez, Legajo FAI-3931
 */
public class Lista {
    private Nodo cabecera;

    public Lista() {
        cabecera = null;
    }

    /**
     * Caso out of range:      ( pos < 1 || pos > longitud() + 1 ) -> false <br>
     * Caso especial 2: ( pos == 1 ) -> true <br>
     * Caso general 3:  ( 2 <= pos <= longitud() + 1 )  ->  true <br>
     * Para insertar siempre considerar {@code int pos = lis.longitud() + 1 } ( similar a .append() de python )
     * @param obj elObjeto a insertar: Object
     * @param pos laPosicion: int 1~n
     * @return true si se inserta correctamente, false si la posición es inválida
     */
    public boolean insertar(Object obj, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > longitud()+1) {
            exito = false;  // caso 1
        } else {
            Nodo nuevoNodo = new Nodo(obj, null);
            if (pos == 1) { // Insertar al principio
                nuevoNodo.setEnlace(cabecera);
                cabecera = nuevoNodo; // caso especial 2
            } else {
                Nodo aux = cabecera;
                for (int i = 1; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                nuevoNodo.setEnlace(aux.getEnlace()); // linkeo actual -> next
                aux.setEnlace(nuevoNodo); // linkeo  b4 -> actual
            }
        }
        return exito;
    }
    
    /**
     * Caso 1:          ( pos < 1 || pos > longitud() ) -> false <br>
     * Caso especial 2: ( pos == 1 ) -> true <br>
     * Caso general 3:  ( 2 <= pos <= longitud() )  -> true
     * @param pos: int 1~n
     * @return true si se elimina correctamente, false si la posición es inválida
     */
    public boolean eliminar(int pos) {
        boolean exito = false;
        if ( !this.esVacia() ){ 
            if (pos < 1 || pos > longitud()) {
                exito = false;  // caso invalido
            }

            if (pos == 1) { // Eliminar al principio
                cabecera = cabecera.getEnlace(); // caso especial 2
            } else {
                Nodo aux = cabecera;
                for (int i = 1; i < pos - 1; i++) {
                    aux = aux.getEnlace();
                }
                aux.setEnlace(aux.getEnlace().getEnlace()); // linkeo anterior -> next
            }
            exito = true;
        }
        return exito;
    }

    /**
     * @param pos: int posicion de rango 1~n.
     * @return objeto en la posicion buscada, recuperar un n fuera de rango 1~n devuelve Object null.
     * @implNote Complejidad O(n) sin el atributo longitud puesto que para buscar el j-esimo Object entre 1~n tengo que hacer j iteraciones.
     */
    public Object recuperar(int pos) {
        Object elObj; 
        if (pos < 1 || pos > longitud()) {
            elObj = null; // caso invalido
        } else {
            Nodo aux = cabecera;
            for (int i = 1; i < pos; i++) {
                aux = aux.getEnlace();
            }
            elObj = aux.getElem();
        }
        return elObj;
    }

    public int localizar(Object obj) {
        boolean found = false;
        int resultado = 1;
        Nodo aux = cabecera;
        while ( !found && aux != null) {
            if (aux.getElem().equals(obj)) {
                found = true;
            } else {
                aux = aux.getEnlace();
                resultado++;
            }

        }
        if (aux == null) {
            resultado = -1;
        }
        return resultado;
    }

    /**
     * @return 0 if empty list
     * @version 1.0: sin atributo longitud
     */
    public int longitud() {
        int longitud = 0;
        Nodo aux = cabecera;
        while (aux != null) {
            longitud++;
            aux = aux.getEnlace();
        }
        return longitud;
    }

    /**
     * @return true if unico atributo cabecera is null, false otherwise.
     */
    public boolean esVacia() {
        return cabecera == null;
    }

    public void vaciar() {
        cabecera = null;
    }

    @Override
    public Lista clone() {
        Lista clon = new Lista();
        Nodo aux1 = this.cabecera;
        Nodo aux2 = null;
        while (aux1 != null) {
            if (clon.cabecera == null) {
                clon.cabecera = new Nodo(aux1.getElem(), null);
                aux2 = clon.cabecera;
            } else {
                aux2.setEnlace(new Nodo(aux1.getElem(), null));
                aux2 = aux2.getEnlace();
            }
            aux1 = aux1.getEnlace();
        }
        return clon;
    }

    @Override
    public String toString() {
        String cadena = "[";
        Nodo aux = cabecera;
        while (aux != null) {
            cadena += aux.getElem().toString();
            aux = aux.getEnlace();
            if (aux != null) {
                cadena += ",";
            }
        }
        return cadena + "]";
    }

    /***********************************************
     * Metodos extras para ejercitacion de parcial *
     ***********************************************/


    /**
     * @param l una Lista a multiplicar
     * @param mult cantidad de multiplicaciones
     * @return Lista<Object> multilpicada. ejemplo: invocar {@codemultSec([1,2,3], 3) devuelve [1,2,3,1,2,3,1,2,3]}.
     */
    public Lista multSec(int mult) {
        Lista newL = new Lista();
        for ( int i = 1; i <= mult; i++ ) {
            int j = 1;
            while ( this.recuperar(j) != null ) { 
                newL.insertar( this.recuperar(j), j); // Lista.recuperar(n) seria como List[n-1] en python.
                j++;
            }
        }
        return newL;
    }

    /**
     * a this le agrego al final 1 por 1 los elementos de otra lista
     * e.g {@code [a,b,c].append([x,y,z]) retorna [a,b,c,x,y,z]} ✅
     * seria incorrecto agregarle directamente la segunda lista a
     * la primera en la ultima posicion, e.g -> {@code [a,b,c,[x,y,z]]} ❌
     */
    public void append(Lista listaFrom) {
        int pos = 1;
        while ( listaFrom.recuperar(pos) != null ) {
            this.insertar( listaFrom.recuperar(pos), this.longitud()+1 );
            pos++;
        }
    }
    // mas eficiente
    public void append2(Lista listaFrom) {
        Nodo aux = this.cabecera;
        while ( aux.getEnlace()!=null ) {
            aux = aux.getEnlace();
        }
        aux.setEnlace(listaFrom.cabecera);
        Lista result = new Lista();
        result.cabecera = aux;
    }

    


}
