package test.jerarquicas;
import jerarquicas.ArbolBin;
import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

public class MyTestArbolBin {
    
    public static void main(String[] args) throws InterruptedException {
        /*
        * Arbolito a testear (mismo del pdf apunte 3 jerarquicas 2025)
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
        arbol1 = crearArbolDelPdf();
        
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
        soutFacha("arbol1 hashCode() --> " + arbol1.hashCode(), 20);
        soutFacha("arbol2 hashCode() --> " + arbol2.hashCode(), 20);
        soutFacha("arbol1.equals(arbol2) --> " + arbol1.equals(arbol2), 20);
        System.out.println("Insertando 12vo nodo (G).HD: " + arbol1.insertar('Z', 'G', 'I'));
        soutFacha("arbol1.equals(arbol2) --> " + arbol1.equals(arbol2), 20);
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
        soutFacha("arbol3.equals(arbol4) --> " + equals, 20);

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

        soutFacha("======== Ejercicios de parciales viejos ========",40);
        
        soutFacha("======== test de frontera() ========",20);
        Lista listaHojas = arbol1.frontera();
        soutFacha("Lista de hojas: \n" + listaHojas.toString(), 20);
        soutFacha("Corroboremos... \n" + arbol1.toString(), 10);

        soutFacha("======== test de getAncestros() ========",20);
        Lista ancestros = arbol1.obtenerAncestrosDe('H');
        soutFacha("Ancestros de 'H': " + ancestros.toString(), 20); // -->  [D, B, A] o [A, B, D] ???
        ancestros = arbol1.obtenerAncestrosDe('J');
        soutFacha("Ancestros de 'J': " + ancestros.toString(), 20); // -->  [F, C, A] o [A, C, F] ???
        ancestros = arbol1.obtenerAncestrosDe('A');
        soutFacha("Ancestros de 'A': " + ancestros.toString(), 20); // -->  [F, C, A] o [A, C, F] ???

        soutFacha("======== test de getDescendientes() ========", 20);
        Lista descendientes = arbol1.obtenerDescendientesDe('B');
        soutFacha("Descendientes de 'B': " + descendientes.toString(), 20); // --> [D, H, E] o [E, H, D] ???
        descendientes = arbol1.obtenerDescendientesDe('F');
        soutFacha("Descendientes de 'F': " + descendientes.toString(), 20); // --> [D, H, E] o [E, H, D] ???
        descendientes = arbol1.obtenerDescendientesDe('H');
        soutFacha("Descendientes de 'H': " + descendientes.toString(), 20); // --> [D, H, E] o [E, H, D] ???
        descendientes = arbol1.obtenerDescendientesDe('A');
        soutFacha("Descendientes de 'A': " + descendientes.toString(), 20); // --> [D, H, E] o [E, H, D] ???


        soutFacha("======== test de verificarPatron() ========",20);
        Lista patronTest1 = new Lista();
        patronTest1.insertar('A', patronTest1.longitud()+1);
        patronTest1.insertar('C', patronTest1.longitud()+1);
        patronTest1.insertar('F', patronTest1.longitud()+1);
        patronTest1.insertar('J', patronTest1.longitud()+1);
        soutFacha("Lista a testear: " +patronTest1.toString(), 20);
        boolean exitoPatron = arbol1.verificarPatron(patronTest1);
        System.out.println(exitoPatron);
        soutFacha("Sobre el arbol" + arbol1.toString(),10);

        soutFacha("arbol2.toString(): "+arbol2.toString(), 10);
        soutFacha("arbol2.clonarInvertido().toString(): "+arbol2.clonarInvertido().toString(), 10);

        soutFacha("======== test de estaRepetido() ========", 15);
        /*
        ver crearArbolDelParcial5_5_2023()

        ArbolBin arbol9 = new ArbolBin();
        arbol9.insertar(14, null, 'I');  // raiz
        arbol9.insertar(4, 14, 'I');
        arbol9.insertar(15, 14, 'D');
        arbol9.insertar(7, 4, 'I');
        arbol9.insertar(9, 4, 'D');
        arbol9.insertar(5, 15, 'I');
        arbol9.insertar(18, 15, 'D');
        arbol9.insertar(7, 9, 'I');
        arbol9.insertar(5, 7, 'I');
        arbol9.insertar(16, 18, 'I');
        arbol9.insertar(15, 18, 'D');
        arbol9.insertar(4, 5, 'I');
        arbol9.insertar(5, 5, 'D');
        arbol9.insertar(7, 15, 'D');
        soutFacha("arbol9(mal): "+arbol9.toString(), 15);

        ArbolBin arbol10 = new ArbolBin();
        arbol10.insertarPorPosicion(14, 1, 'I');    // raiz
        arbol10.insertarPorPosicion(4, 1, 'I');     // pos 2
        arbol10.insertarPorPosicion(15, 1, 'D');    // pos 3
        arbol10.insertarPorPosicion(7, 2, 'I');     // pos 4
        arbol10.insertarPorPosicion(9, 2, 'D');     // pos 5
        arbol10.insertarPorPosicion(7, 4, 'I');     // pos 6
        arbol10.insertarPorPosicion(5, 5, 'I');     // pos 7
        arbol10.insertarPorPosicion(4, 6, 'I');    // pos 8
        arbol10.insertarPorPosicion(5, 6, 'D');     // pos 9
        arbol10.insertarPorPosicion(5, 9, 'I');    // pos 10
        arbol10.insertarPorPosicion(18, 9, 'D');    // pos 11
        arbol10.insertarPorPosicion(16, 11, 'I');     // pos 12
        arbol10.insertarPorPosicion(7, 12, 'D');    // pos 14
        arbol10.insertarPorPosicion(15, 11, 'D');     // pos 13
        soutFacha("arbol10: "+arbol10.toString(), 15);

        soutFacha("arbol9 equals arbol10?", 20);
        System.out.println( arbol9.equals(arbol10) );


        NodoArbol arbolRoot = new NodoArbol(14, null, null);  // raiz
        NodoArbol nodo2 = new NodoArbol(4, null, null);   // HI de 14
        NodoArbol nodo3 = new NodoArbol(7, null, null);   // HI de 4
        NodoArbol nodo4 = new NodoArbol(9, null, null);   // HD de 4
        NodoArbol nodo5 = new NodoArbol(7, null, null);   // HI de 9
        NodoArbol nodo6 = new NodoArbol(5, null, null);   // HI de 7
        NodoArbol nodo7 = new NodoArbol(4, null, null);   // HI de 5
        NodoArbol nodo8 = new NodoArbol(5, null, null);   // HD de 5
        NodoArbol nodo9 = new NodoArbol(15, null, null);  // HD de 14
        NodoArbol nodo10 = new NodoArbol(5, null, null);  // HI de 15
        NodoArbol nodo11 = new NodoArbol(18, null, null); // HD de 15
        NodoArbol nodo12 = new NodoArbol(16, null, null); // HI de 18
        NodoArbol nodo13 = new NodoArbol(7, null, null);  // HD de 16
        NodoArbol nodo14 = new NodoArbol(15, null, null); // HD de 18
    
        // Armo subarbol                                                                                         
        arbolRoot.setHI(nodo2); //  (4) <- (14) -> (null)                                14
        arbolRoot.setHD(nodo9); //  (4) <- (14) ->  (15)                              /      \
        nodo2.setHI(nodo3); // (7) <- (4) -> ()                                     4         15
        nodo2.setHD(nodo4); // (7) <- (4) -> (9)                                  /   \      /   \
        nodo4.setHI(nodo5); // (7) <- (9) -> ()                                  7     9    5     18
        nodo5.setHD(nodo6); // (5) <- (7) -> ()                                       /          /  \
        nodo6.setHD(nodo7); // (4) <- (5) -> ()                                      7          16  15
        nodo6.setHD(nodo8); // (4) <- (5) -> (5)                                    /            \
        nodo9.setHD(nodo10); // (5) <- (15) -> ()                                  5              7
        nodo9.setHD(nodo11); // (5) <- (15) -> (18)                              /  \
        nodo11.setHD(nodo12); // (16) <- (18) -> ()                             4    5
        nodo11.setHD(nodo14); // (16) <- (15) -> (15)
        nodo12.setHD(nodo13); // () <- (16) -> (7)
        ArbolBin pepe = new ArbolBin( arbolRoot );
        soutFacha("pepe:" + pepe.toString(), 10);
        */
        

        ArbolBin pepe2 = crearArbolDelParcial5_5_2023();
        soutFacha("pepe2 definitivo: "+pepe2.toString(), 15);
        boolean objRepetidos = pepe2.estaRepetido(1);
        soutFacha("esta repetido el 1?: "+objRepetidos, 10);
        objRepetidos = pepe2.estaRepetido(9);
        soutFacha("esta repetido el 9?: "+objRepetidos, 10);
        objRepetidos = pepe2.estaRepetido(7);
        soutFacha("esta repetido el 7?: "+objRepetidos, 10); // --> este deberia ser true, el 7 esta 3 veces !!!
        objRepetidos = pepe2.estaRepetido(5);
        soutFacha("esta repetido el 5?: "+objRepetidos, 10);
        objRepetidos = pepe2.estaRepetido(15);
        soutFacha("esta repetido el 15?: "+objRepetidos, 10);

        soutFacha("======== test de listarInordenDesde() ========",10);
        Lista inordenDesde = arbol1.armarListaInordenDesde('C'); // --> as default: [I F J G] ✅ with prev. inserts: [I,F,J,C,Z,G] ✅
        soutFacha("Inorden desde el nodo C: "+inordenDesde.toString(), 10);
        inordenDesde = arbol1.armarListaInordenDesde('B'); // --> as default: [D H B E] ✅ w/ prev. inserts: [x,D,H,B,E] ✅
        soutFacha("Inorden desde el nodo B: "+inordenDesde.toString(), 10);






        soutFacha("...",50);
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

    /**
     * <pre>
     *                           14
     *                        /      \
     *                      4         15
     *                    /   \      /   \
     *                   7     9    5     18
     *                        /          /  \
     *                       7          16  15
     *                      /            \
     *                     5              7
     *                   /  \
     *                  4    5
     * </pre>
     * @return
     */
    public static ArbolBin crearArbolDelParcial5_5_2023() {
        NodoArbol mainRoot = new NodoArbol(14,
            new NodoArbol(4,
                new NodoArbol(7, null, null),
                new NodoArbol(9,
                    new NodoArbol(7,
                        new NodoArbol(5,
                            new NodoArbol(4, null, null),
                            new NodoArbol(5, null, null)
                        ),
                        null
                    ),
                    null
                )
            ),
            new NodoArbol(15,
                new NodoArbol(5, null, null),
                new NodoArbol(18,
                    new NodoArbol(16,
                        null,
                        new NodoArbol(7, null, null)
                    ),
                    new NodoArbol(15, null, null)
                )
            )
        );
        return new ArbolBin(mainRoot);
    }

    /**
     * <pre>                                             
     *                  __('A')__
     *                 /         \  
     *             ('B')          ('C')
     *            /     \         /     \
     *        ('D')     ('E')   ('F')   ('G')
     *            \             /    \
     *           ('H')       ('I')  ('J')                            
     *</pre>                                                                                                                                              
     *                                                                             
     */
    public static ArbolBin crearArbolDelPdf(){
        ArbolBin result = new ArbolBin();
        System.out.println("Insertando raiz: (A)" + result.insertar('A', null, 'D'));
        System.out.println("Insertando 2do nodo: (A).HI: " + result.insertar('B', 'A', 'I'));
        System.out.println("Insertando 3er nodo: (A).HD: " + result.insertar('C', 'A', 'D'));
        //System.out.println("Raiz infiltrada: " + result.insertar(69, 1, 'I'));
        System.out.println("Insertando 4to nodo: (B).HI: " + result.insertar('D', 'B', 'I'));
        System.out.println("Insertando 5to nodo: (B).HD: " + result.insertar('E', 'B', 'D'));
        System.out.println("Insertando 6to nodo: (C).HI: " + result.insertar('F', 'C', 'I'));
        System.out.println("Insertando 7mo nodo: (C).HD: " + result.insertar('G', 'C', 'D'));
        System.out.println("Altura del arbol: " + result.altura());
        System.out.println("Insertando 8vo nodo: (D).HD: " + result.insertar('H', 'D', 'D'));
        System.out.println("Insertando 9no nodo: (F).HI: " + result.insertar('I', 'F', 'I'));
        System.out.println("Insertando 10mo nodo (F).HD: " + result.insertar('J', 'F', 'D'));
        return result;
    }

}
