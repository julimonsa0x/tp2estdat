package test.jerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;

public class MyTestArbolBin {
    
    public static void main(String[] args) throws InterruptedException {
        /*
        * Arbolito a testear (mismo del pdf apunte 3)
        * PREORDEN: A B D H E C F I J G
        * INORDEN: D H B E A I F J C G
        * POSTORDEN: H D E B I J F G C A 
        * ALTURA: 3
        *    
        *                __('A')__
        *               /         \  
        *           ('B')          ('C')
        *          /     \         /     \
        *      ('D')     ('E')   ('F')   ('G')
        *          \             /    \
        *         ('H')       ('I')  ('J')         
        *                                 
        * 
        */
        ArbolBin arbol1 = new ArbolBin();
        Lista recorridos = new Lista();
        Object objetoPadre = null;

        // tests con arbol vacio
        System.out.println("Arbol vacio: " + arbol1.toString()); // --> 
        recorridos = arbol1.listarPreorden();
        System.out.println("Listado en Preorden: " + recorridos.toString()); // --> []
        System.out.println("Altura del arbol nongpt: " + arbol1.altura()); // --> -1
        System.out.println("Nivel del arbol: " + arbol1.nivelDe("xyz")); //  --> -1

        // lleno arbol con los nodos del javadoc
        System.out.println("Insertando raiz: (A)" + arbol1.insertar('A', null, 'D'));
        System.out.println("Insertando 2do nodo: (A).HI: " + arbol1.insertar('B', 'A', 'I'));
        System.out.println("Insertando 3er nodo: (A).HD: " + arbol1.insertar('C', 'A', 'D'));
        System.out.println("Raiz infiltrada: " + arbol1.insertar(69, 1, 'I'));
        System.out.println("Insertando 4to nodo: (B).HI: " + arbol1.insertar('D', 'B', 'I'));
        System.out.println("Insertando 5to nodo: (B).HD: " + arbol1.insertar('E', 'B', 'D'));
        System.out.println("Insertando 6to nodo: (C).HI: " + arbol1.insertar('F', 'C', 'I'));
        System.out.println("Insertando 7mo nodo: (C).HD: " + arbol1.insertar('G', 'C', 'D'));
        System.out.println("Altura del arbol gpt: " + arbol1.altura());
        System.out.println("Altura del arbol nongpt: " + arbol1.altura());
        System.out.println("Insertando 8vo nodo: (D).HD: " + arbol1.insertar('H', 'D', 'D'));
        System.out.println("Insertando 9no nodo: (F).HI: " + arbol1.insertar('I', 'F', 'I'));
        System.out.println("Insertando 10mo nodo (F).HD: " + arbol1.insertar('J', 'F', 'D'));
        
        soutFacha("======== test de altura() ========", 20);
        recorridos = arbol1.listarPreorden();
        System.out.println("Listado en Preorden: " + recorridos.toString());
        recorridos = arbol1.listarInorden();
        System.out.println("Listado en Inorden: " + recorridos.toString());
        recorridos = arbol1.listarPosorden();
        System.out.println("Listado en Postorden: " + recorridos.toString());
        recorridos = arbol1.listarPorNiveles();
        System.out.println("Listado por niveles: " + recorridos.toString());

        soutFacha("======== test de padre() ========", 20);
        objetoPadre =  arbol1.padreDe('H'); // --> 'D'
        System.out.println("Padre de 'H': " + objetoPadre);
        objetoPadre =  arbol1.padreDe('A'); // --> null
        System.out.println("Padre de 'A': " + objetoPadre);
        objetoPadre =  arbol1.padreDe('J'); // --> 'F'
        System.out.println("Padre de 'J': " + objetoPadre);

        soutFacha("======== test de altura() ========", 20);
        System.out.println("Altura del arbol: " + arbol1.altura());

        soutFacha("======== test de nivel() ========",30);
        System.out.println("Nivel de xyz: " + arbol1.nivelDe("xyz")); //  --> -1
        System.out.println("Nivel de B: " + arbol1.nivelDe('B'));  // -->  1
        System.out.println("Nivel de F: " + arbol1.nivelDe('F'));  // -->  2
        System.out.println("Nivel de H: " + arbol1.nivelDe('H'));  // -->  3

        soutFacha("======== test de insertarPorPosicion() ========", 20);
        boolean insertPos1 = arbol1.insertarPorPosicion('x', 1, 'I'); // --> false
        System.out.println("Insertando x como HI en 1 (ocupado por raiz A): "+insertPos1);
        boolean insertPos2 = arbol1.insertarPorPosicion('y', 2, 'I'); // --> false
        System.out.println("Insertando y como HI en 2 (ocupado por D): " + insertPos2);
        boolean insertPos3 = arbol1.insertarPorPosicion('x', 3, 'I'); // --> true
        System.out.println("Insertando x como HI en 3 (libre): " + insertPos3);

        soutFacha("======== test de clone() y equals() ========", 20);
        ArbolBin arbol2 = arbol1.clone();
        soutFacha("arbol2 Clonado de arbol1: \n" + arbol2.toString(), 10);
        soutFacha("deepcopy o shallowcopy? \n(arbol1 == arbol2)  --> " + (arbol1 == arbol2), 20);
        soutFacha("arbol1 hashCode() --> " + arbol1.hashCode(), 30);
        soutFacha("arbol2 hashCode() --> " + arbol2.hashCode(), 30);
        soutFacha("arbol1.equals(arbol2) --> " + arbol1.equals(arbol2), 30);
        System.out.println("Insertando 12vo nodo (G).HD: " + arbol1.insertar('Z', 'G', 'I'));
        soutFacha("arbol1.equals(arbol2) --> " + arbol1.equals(arbol2), 30);
        System.out.println(arbol1.toString());
        System.out.println(arbol2.toString());

        ArbolBin arbol3 = new ArbolBin();
        System.out.println("Insertando raiz: (X)" + arbol3.insertar('X', null, 'D'));
        System.out.println("Insertando 2do nodo: (X).HI: " + arbol3.insertar('Y', 'X', 'I'));
        System.out.println("Insertando 3er nodo: (X).HD: " + arbol3.insertar('Z', 'X', 'D'));
        ArbolBin arbol4 = new ArbolBin();
        System.out.println("Insertando raiz: (X)" + arbol4.insertar('X', null, 'D'));
        System.out.println("Insertando 2do nodo: (X).HI: " + arbol4.insertar('T', 'X', 'I'));
        System.out.println("Insertando 3er nodo: (X).HD: " + arbol4.insertar('Z', 'X', 'D'));
        boolean equals = arbol3.equals(arbol4);
        soutFacha("arbol3.equals(arbol4) --> " + equals, 30);

        /*
         * Si hacemos:
         *      original = new NodoArbol("A");
         *      NodoArbol copia = original; // apuntan al MISMO objeto
         * 
         * Entonces: 
         *      System.out.println(original == copia); // true -> misma direccion de memoria
         * 
         * Pero al hacer una copia profunda:
         *      NodoArbol copia = original.clone();
         *      System.out.println(original == copia); // false -> distinto objeto
         */

        //soutFacha(arbol1.toString(), 30);

        soutFacha("======== Ejercicios de parciales viejos ========",75);
        soutFacha("======== test de frontera() ========",30);
        Lista listaHojas = arbol1.frontera();
        soutFacha("Lista de hojas: \n" + listaHojas.toString(), 30);
        soutFacha("Corroboremos... \n" + arbol1.toString(), 10);

        soutFacha("======== test de getAncestros() ========",30);
        Lista ancestros = arbol1.obtenerAncestrosDe('H');
        soutFacha("Ancestros de 'H': " + ancestros.toString(), 30); // -->  [D, B, A] o [A, B, D] ???
        ancestros = arbol1.obtenerAncestrosDe('J');
        soutFacha("Ancestros de 'J': " + ancestros.toString(), 30); // -->  [F, C, A] o [A, C, F] ???
        ancestros = arbol1.obtenerAncestrosDe('A');
        soutFacha("Ancestros de 'A': " + ancestros.toString(), 30); // -->  [F, C, A] o [A, C, F] ???

        soutFacha("======== test de getDescendientes() ========", 30);
        Lista descendientes = arbol1.obtenerDescendientesDe('B');
        soutFacha("Descendientes de 'B': " + descendientes.toString(), 30); // --> [D, H, E] o [E, H, D] ???
        descendientes = arbol1.obtenerDescendientesDe('F');
        soutFacha("Descendientes de 'F': " + descendientes.toString(), 30); // --> [D, H, E] o [E, H, D] ???
        descendientes = arbol1.obtenerDescendientesDe('H');
        soutFacha("Descendientes de 'H': " + descendientes.toString(), 30); // --> [D, H, E] o [E, H, D] ???
        descendientes = arbol1.obtenerDescendientesDe('A');
        soutFacha("Descendientes de 'A': " + descendientes.toString(), 30); // --> [D, H, E] o [E, H, D] ???

        soutFacha("======== Fin de la prueba ========", 50);

    }

    /**
     * @param texto el texto a imprimir
     * @param delay el tiempo de espera entre cada caracter en milisegundos
     */
    public static void soutFacha(String texto, int delay) throws InterruptedException {
        for (char c : texto.toCharArray()) {
            System.out.print(c);
            System.out.flush();
            Thread.sleep(delay);
        }   
        System.out.println();
    }

}
