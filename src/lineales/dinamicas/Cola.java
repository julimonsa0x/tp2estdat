package lineales.dinamicas;

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elemento) {
        Nodo nuevoNodo = new Nodo(elemento, null);
        // caso especial: cola vacia
        if ( this.esVacia() ) {
            this.fin = nuevoNodo;
            this.frente = nuevoNodo;
        // caso general: cola no vacia
        } else {

            this.fin.setEnlace(nuevoNodo);
            this.fin = nuevoNodo;
        }
        return true; // siempre pone un elemento
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.frente == null) {
            //  La cola está vacía, no se puede sacar un elemento
            exito = false;
        } else {
            // hay almenos un elemento
            // quita el 1er elemento y actualiza frente ( y fin si queda vacia )
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        return (this.frente != null) ? this.frente.getElem() : null;
    }

    public boolean esVacia() {
        return this.frente == null;
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
        // consider force garbage collection ???
        // System.gc();
    }

    public Cola clonar() {
        Cola clon = new Cola();
        Nodo aux1 = this.frente;
        clon.frente = new Nodo(aux1.getElem(), null);
        aux1 = aux1.getEnlace();
        Nodo aux2 = clon.frente;
        while (aux1 != null) {

            aux2.setEnlace(new Nodo(aux1.getElem(), null));
            aux2 = aux2.getEnlace();
            aux1 = aux1.getEnlace();            
        }
        clon.fin = aux2;
        return clon;
    }

    @Override
    public String toString() {
        String colaString = "[";
        Nodo auxString = this.frente;
        // avoid infinite loop 
        while ( auxString != null) {
            // uso el String.valueOf por si algun nodo tiene algun objeto con toString() definido, e.g: Alumno.
            colaString += String.valueOf(auxString.getElem()) + String.valueOf(auxString.getEnlace() != null ? ", " : "");
            auxString = auxString.getEnlace();
        }
        return colaString + "]";
    }
}