package test.jerarquicas;
import jerarquicas.ArbolBin;
import jerarquicas.NodoArbol;
import lineales.dinamicas.Lista;

public class TestArbolBin {
    
public static void main(String[] args) {
    ArbolBin arbol1 = new ArbolBin();
    Lista lista1 = new Lista();
    System.out.println("Insertando 1ra raiz: " + arbol1.insertar(1, null, 'I'));
    System.out.println("Insertando 2da raiz: (1)HI " + arbol1.insertar(2, 1, 'I'));
    System.out.println("Insertando 3ra raiz: (1)HD " + arbol1.insertar(3, 1, 'D'));
    System.out.println("Raiz infiltrada: " + arbol1.insertar(69, 1, 'I'));
    System.out.println("Insertando 4ta raiz (2)HI: " + arbol1.insertar(4, 2, 'I'));
    System.out.println("Insertando 5ta raiz (2)HD: " + arbol1.insertar(5, 2, 'D'));
    System.out.println("Insertando 6ta raiz (3)HI: " + arbol1.insertar(6, 3, 'I'));
    System.out.println("Insertando 7ma raiz (3)HD: " + arbol1.insertar(7, 3, 'D'));
    lista1 = arbol1.listarPreorden();
    arbol1.altura();
    System.out.println("Altura del arbol: " + arbol1.altura());
    //System.out.println(arbol.toString());
}

}
