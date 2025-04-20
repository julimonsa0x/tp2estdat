package test.jerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;

public class MyTestArbolBin {
    
public static void main(String[] args) {
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

    // tests con arbol vacio
    System.out.println("Arbol vacio: " + arbol1.toString()); // --> 
    recorridos = arbol1.listarPreorden();
    System.out.println("Listado en Preorden: " + recorridos.toString()); // --> []
    System.out.println("Altura del arbol nongpt: " + arbol1.altura()); // --> -1
    System.out.println("Altura del arbol gpt: " + arbol1.alturaGpt()); // --> -1
    System.out.println("Nivel del arbol: " + arbol1.nivel("xyz")); //  --> -1

    // lleno arbol
    System.out.println("Insertando raiz: (A)" + arbol1.insertar('A', null, 'D'));
    System.out.println("Insertando 2do nodo: (A).HI: " + arbol1.insertar('B', 'A', 'I'));
    System.out.println("Insertando 3er nodo: (A).HD: " + arbol1.insertar('C', 'A', 'D'));
    System.out.println("Raiz infiltrada: " + arbol1.insertar(69, 1, 'I'));
    System.out.println("Insertando 4to nodo: (B).HI: " + arbol1.insertar('D', 'B', 'I'));
    System.out.println("Insertando 5to nodo: (B).HD: " + arbol1.insertar('E', 'B', 'D'));
    System.out.println("Insertando 6to nodo: (C).HI: " + arbol1.insertar('F', 'C', 'I'));
    System.out.println("Insertando 7mo nodo: (C).HD: " + arbol1.insertar('G', 'C', 'D'));
    System.out.println("Altura del arbol nongpt: " + arbol1.altura());
    System.out.println("Altura del arbol gpt: " + arbol1.alturaGpt());
    System.out.println("Insertando 8vo nodo: (D).HD: " + arbol1.insertar('H', 'D', 'D'));
    System.out.println("Insertando 9no nodo: (F).HI: " + arbol1.insertar('I', 'F', 'I'));
    System.out.println("Insertando 10mo nodo (F).HD: " + arbol1.insertar('J', 'F', 'D'));
    

    recorridos = arbol1.listarPreorden();
    System.out.println("Listado en Preorden: " + recorridos.toString());
    recorridos = arbol1.listarInorden();
    System.out.println("Listado en Inorden: " + recorridos.toString());
    recorridos = arbol1.listarPostorden();
    System.out.println("Listado en Postorden: " + recorridos.toString());
    recorridos = arbol1.listarPorNiveles();
    System.out.println("Listado por niveles: " + recorridos.toString());

    System.out.println("Altura del arbol nongpt: " + arbol1.altura());
    System.out.println("Altura del arbol gpt: " + arbol1.alturaGpt());


    System.out.println("Nivel del arbol: " + arbol1.nivel("xyz")); //  --> -1
    System.out.println("Nivel del arbol: " + arbol1.nivel('B'));  // -->  1
    System.out.println("Nivel del arbol: " + arbol1.nivel('F'));  // -->  2
    System.out.println("Nivel del arbol: " + arbol1.nivel('H'));  // -->  3

    System.out.println("Ahora test de insertarPorPosicion()");
    boolean boo = arbol1.insertarPorPosicion('x', 1, 'I'); // --> false
    System.out.println(boo);
    boo = arbol1.insertarPorPosicion('x', 3, 'I'); // --> true
    System.out.println(boo);
    System.out.println(arbol1.toString());


    //System.out.println(arbol.toString());
}

}
