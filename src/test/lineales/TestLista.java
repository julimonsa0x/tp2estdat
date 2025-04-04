package test.lineales;

import lineales.dinamicas.Lista;

public class TestLista {
    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();

        l1.insertar("pepe1", 1);
        int len =  l1.longitud();
        l1.eliminar(1);
        len =  l1.longitud();
        l1.insertar(1111111,1);

        try {
            l1.insertar("pepeException", 9);
        } catch (NullPointerException exc) {
            System.out.println("debug print null pointer exception as expected: " + exc.getMessage());
        }
        l1.insertar("pepe2", 2);
        l1.insertar("pepe3", 3);
        l1.insertar("pepe4", 4);
        l1.insertar("pepe5", 5);

        l1.eliminar(1);
        int locate = l1.localizar("pepe3");
        System.out.println("Localizar pepe3: " + locate);
        Object obj4 = l1.recuperar(4);
        System.out.println("Recuperar 4: " + obj4);

        l1.insertar("pepeInfiltrado", 2);

        boolean isEmpty1 = l1.esVacia();
        System.out.println("Lista vacia: " + isEmpty1);
        boolean isEmpty2 = l2.esVacia();
        System.out.println("Lista vacia: " + isEmpty2);

        int length =  l1.longitud();
        System.out.println("Longitud: " + length);

        l1.insertar("pepe6", 6);
        l1.insertar("pepe7", 7);
        l1.insertar("pepe8", 8);
        l1.insertar("pepe9", 9);
        l1.insertar("pepe10", 10);

        l2 = l1.clonar();
        int leng2=l2.longitud();
        System.out.println("Longitud de l2: " + leng2);
        l2.toString();
        System.out.println(l1.toString());

        l2.eliminar(1);
        l2.eliminar(2);
        l2.eliminar(3);
        l2.eliminar(1);
        System.out.println(l2.toString());
        l2.insertar(69, 1);

    }

}
