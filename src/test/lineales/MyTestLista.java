package test.lineales;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lineales.dinamicas.Lista;

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-????
 * @author Julian, Legajo FAI-????
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
        l1.insertar(10,4);
        l1.insertar(5,5);
        l1.insertar(6,6);
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

        l2 = l1.clone();
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

        int locateNew = l2.localizar(69);
        System.out.println("Localizar 69: " + locateNew);
 
    }


    private static boolean isSubstring(String s, String rx){
        Pattern pattern = Pattern.compile(rx);
        Matcher matcher = pattern.matcher(s);
        boolean findSubstring = false;
        while (matcher.find()) {
            //System.out.println(s.substring(matcher.start(), matcher.end()));
            findSubstring = true;
        }
        return findSubstring;
    }

    public static void testFindFirstElement() {
        Lista l=loadList("3,2,1",',');
        int p1 = (int) l.localizar(1);
        boolean ev = l.esVacia();
        Object c = l.recuperar(1);
        String s = l.toString();
        assertEquals(p1,1);
        assertEquals(ev,false);
        assertEquals(c, 1);
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };

    public static void testFindLastElementInTheList() {
        Lista l=loadList("3,2,1",',');
        int lp = (int) l.localizar(3);
        boolean ev = l.esVacia();
        Object e = l.recuperar(3);
        String s = l.toString();
        assertEquals(lp,3);
        assertEquals(ev,false);
        assertEquals(e, 3);
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };

    private static Lista loadList(String elements, char separator) {
        Lista l = new Lista();
        int lengthElements = elements.length();
        char d = ' ';
        String number = "";
        for (int i = 0; i < lengthElements; i++) {
            d = elements.charAt(i);
            if ((d == separator) || (i + 1) == lengthElements) {
                if ((i + 1) == lengthElements)
                    number += d;
                l.insertar(Integer.parseInt(number),1);
                number = "";
            } else {
                number += d;
            }
        }
        return l;
    }

}
