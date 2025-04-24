package test.lineales;


import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Lista;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-3023
 * @author Julian Nuñez, Legajo FAI-3931
 */
public class MyTestLista {
    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();

        // tests 8/10 faltan:
        //testFindFirstElement(); 
        //testFindLastElementInTheList();
        // tests 10/10:
        // tests arreglados moviendo Ln87 a Ln91 --> acumulo cuando NO encuentro, no cuando encuentro... caso contrario siempre retornaba 2

        //[1,2,3,10,5,6,7,8,9,10]

        l1.localizar(10); // 10 no existe --> devuelve -1

        l1.insertar(1,1);
        l1.insertar(2,2);
        l1.insertar(3,3);
        l1.insertar("pepe4",4);
        l2 = l1.clone();
        l1.insertar(5,5);
        l2.toString();
        l2.insertar(6,6);
        
        l1.insertar(7,7);
        l1.insertar(8,8);
        l1.insertar(10,9);
        
        l1.localizar(10);


        l1.insertar("pepe1", 1);
        int len =  l1.longitud();
        l1.eliminar(1);
        len =  l1.longitud();
        l1.insertar(1111111,1);

        try {
            l1.insertar("pepeException", 99);
        } catch (NullPointerException exc) {
            System.out.println("debugeo null pointer exception: " + exc.getMessage());
        }

        l1.insertar("pepe2", 2);
        l1.insertar("pepe3", 3);
        l1.insertar("pepe4", 4);
        l1.insertar("pepe5", 5);

        l1.eliminar(1);
        int locate = l1.localizar("pepe3");
        System.out.println("Localizar pepe3: " + locate);
        Object obj4 = l1.recuperar(4);
        System.out.println("Recuperar 4 de l1: " + obj4);

        l1.insertar("pepeInfiltrado", 2);

        boolean isEmpty1 = l1.esVacia();
        System.out.println("Lista l1 vacia? : " + isEmpty1);
        boolean isEmpty2 = l2.esVacia();
        System.out.println("Lista l2 vacia? : " + isEmpty2);

        int length =  l1.longitud();
        System.out.println("Longitud de l1: " + length);

        l1.insertar("pepe6", 6);
        l1.insertar("pepe7", 7);
        l1.insertar("pepe8", 8);
        l1.insertar("pepe9", 9);
        l1.insertar("pepe10", 10);

        l2 = l1.clone();
        int leng2=l2.longitud();
        System.out.println("Longitud de l2: " + leng2);
        l2.toString();
        System.out.println("l1.toString() es: " + l1.toString());

        l2.eliminar(1);
        l2.eliminar(2);
        l2.eliminar(3);
        l2.eliminar(1);
        System.out.println(l2.toString());
        l2.insertar(69, 1);

        int locateNew = l2.localizar(69);
        System.out.println("El objeto 69 esta en pos: " + locateNew);
        System.out.println("y l2 es: " + l2.toString());
        

        int multip = 2;
        Lista listaTest = new Lista();
        listaTest.insertar(1, 1);
        listaTest.insertar('x', 2);
        listaTest.insertar(5, 3);
        Lista listaTest2 = new Lista();
        listaTest2.insertar(9, 1);
        listaTest2.insertar('x', 2);
        listaTest2.insertar('z', 3);
        Lista listaTest3 = new Lista();
        listaTest3.insertar(6, 1);
        listaTest3.insertar('x', 2);
        listaTest3.insertar(9, 3);
        Lista listaTest4 = new Lista();
        listaTest4.insertar('j', 1);
        listaTest4.insertar('k', 2);
        listaTest4.insertar('l', 3);
        //Lista listDuplic =  l1.multSec(multip);
        //System.out.println("l1.multSec("+multip+") resulta: "+ listDuplic.toString());
        listaTest =  listaTest.multSec(multip);
        System.out.println("listaTest.multSec("+multip+") resulta: "+ listaTest.toString());
        listaTest.append(listaTest2);
        System.out.println("listaTest.append(listaTest2): "+ listaTest.toString());
        listaTest4.append(listaTest3);
        System.out.println("listaTest4.append2(listaTest3): "+ listaTest4.toString());


        System.out.println("=========== test invertirVocalesDuplicarSinVocales ===========");
        Cola testQ = new Cola();
        testQ.poner('a');
        testQ.poner('b');
        testQ.poner('c');
        testQ.poner('d');
        testQ.poner('e');
        testQ.poner('f');
        testQ.poner('#');
        testQ.poner('a');
        testQ.poner('b');
        testQ.poner('c');
        testQ.poner('d');
        testQ.poner('#');
        testQ.poner('q');
        testQ.poner('w');
        testQ.poner('r');
        testQ.poner('t');
        testQ.poner('y');
        testQ.poner('#');
        testQ.poner('s');
        testQ.poner('a');
        Lista listFromTestQ = invertirVocalesDuplicarSinVocales(testQ);
        System.out.println("listFromTestQ es: "+listFromTestQ.toString());

    }

    /**
     * generics not implementados! -> pueden haber casteos...
     * @param q se asume Cola<char> 
     * @return tamo viendo todavia en principio una lista
     */
    public static Lista invertirVocalesDuplicarSinVocales( Cola q ) {
        Lista listDuplicar= new Lista(); 
        Lista listaFinal = new Lista();
        Cola qAux = q.clone(); 
        Pila pilaInvertir = new Pila();
        //int i = 1;
        boolean deboInvertir = false;
        // FIX! ultimo bloque se hace nullpero queda pendiente pasarlo a listaFinal
        while ( !qAux.esVacia() || !listDuplicar.esVacia() && !pilaInvertir.esVacia()) {
            char charActual = (char) qAux.obtenerFrente(); // casteo necesario puesto que mi TDA cola no implementa generics y no tengo Cola<char>!!!
            if ( !deboInvertir ) { // si no encontre vocales...
                if ( charActual == '#' ) { // cierro bloque  

                    // si cierro un bloque sin vocales entonces
                    // duplico a listDuplicar y luego la muevo a listaFinal  1-1
                    // y por ultimo agrego un #
                    listDuplicar = listDuplicar.multSec(2);
                    listaFinal.append2(listDuplicar);
                    listaFinal.insertar('#', listaFinal.longitud()+1);



                    listDuplicar = new Lista(); // reseteo lista para prox a-sub-i
                    pilaInvertir = new Pila();  // reseteo pila para prox a-sub-i
                    deboInvertir = false; // reseteo booleano para vocal tras cerrar bloque sin vocales
                }   
                if ( esVocal( (char) charActual ) ) { // si encuentro vocal...
                    deboInvertir = true;
                    pilaInvertir.apilar(charActual);
                }
                if ( !deboInvertir && charActual != '#' ) { // si no es vocal ni cierro bloque...
                    listDuplicar.insertar( charActual, listDuplicar.longitud()+1 );
                }

            } else {
                if ( !listDuplicar.esVacia() ) {
                    listDuplicar = new Lista(); // purgo lista para next bloque a-sub-i, me concentro en la Pila de vocales
                }
                if ( charActual == '#' ) { // va aca o deberia intercambiar de nivel los if con (!deboInvertir) ?
                    // si cierro un bloque con vocales
                    // invierto pilaInvertir hacia listaResultado 1-1
                    // al desapilar se invierte por naturaleza de pila LIFO
                    
                    // poco eficiente? deberia ir por nodos? como apunto de lista a pila si pila.tope es privado?
                    while ( !pilaInvertir.esVacia() ) {
                        listaFinal.insertar( pilaInvertir.obtenerTope(), listaFinal.longitud()+1 );
                        pilaInvertir.desapilar();
                    }
                    listaFinal.insertar( '#', listaFinal.longitud()+1 );
                    
                    pilaInvertir = new Pila();  // reseteo pila para prox a-sub-i
                    deboInvertir = false; // reseteo booleano para vocal tras cerrar bloque con vocales

                } else if ( esVocal(charActual) ) {
                    pilaInvertir.apilar(charActual);
                }
            }
            qAux.sacar();
        }
        return listaFinal;
    }

    public static boolean esVocal(char x) {
        x = Character.toUpperCase(x);
        return x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U';
    }

}
