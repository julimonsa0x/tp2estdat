package lineales.dinamicas;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-????
 * @author Julian, Legajo FAI-????
 */
public class Lista {
    private Nodo cabecera;

    public Lista() {
        cabecera = null;
    }

    /**
     * Caso 1:          ( pos < 1 || pos > longitud() + 1 ) -> false <br>
     * Caso especial 2: ( pos == 1 ) -> true <br>
     * Caso general 3:  ( 2 <= pos <= longitud() + 1 )  -> true
     * @param obj elObjeto a insertar: Object
     * @param pos laPosicion: int 1~n
     * @return true si se inserta correctamente, false si la posición es inválida
     */
    public boolean insertar(Object obj, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > longitud()+1) {
            exito = false;  // caso 1
        }

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

}
