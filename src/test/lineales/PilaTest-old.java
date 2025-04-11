
package test.lineales;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lineales.estaticas.Pila;

/**
 *
 * @author Catedra EDAT - FAI - UNCOMA
 *         Ultima modificación: 17/03/2025
 *
 */

 /*
  * Se asume que la salida de toString() para Pila devuelve 
  * un texto del tipo [3,2,1] donde 3 es el tope y 1 la base de la pila,
  * para una pila donde los elemenos apilados fueron 1, 2 y 3 en ese orden.
  * 
  * jre linux 1.8
  * julian.monsalves@aula3-cpu15:~/Code/tp2estdat$ java -version
  * java version "1.8.0_201"
  * Java(TM) SE Runtime Environment (build 1.8.0_201-b09)
  * Java HotSpot(TM) 64-Bit Server VM (build 25.201-b09, mixed mode)  
  */
  
/*public class PilaTest {

    private static boolean isSubstring(String s, String rx){
        Pattern pattern = Pattern.compile(rx);
        Matcher matcher = pattern.matcher(s);
        boolean findSubstring = false;
        while (matcher.find()) {
            System.out.println(s.substring(matcher.start(), matcher.end()));
            findSubstring = true;
        }
        return findSubstring;
    }

    private static Pila load_stack(String elements, char separator) {
        Pila p = new Pila();
        int lengthElements = elements.length();
        char d = ' ';
        String number = "";
        for (int i = 0; i < lengthElements; i++) {
            d = elements.charAt(i);
            if ((d == separator) || (i + 1) == lengthElements) {
                if ((i + 1) == lengthElements)
                    number += d;
                p.apilar(Integer.parseInt(number));
                number = "";
            } else {
                number += d;
            }
        }
        //System.out.println(p.toString());
        return p;
    }

    @Test
    public void testCreateEmptyStack() {
        Pila p = new Pila();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ev,true);
        assertEquals(t, null);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testStackFirstElement() {
        Pila p=new Pila();
        boolean ap = p.apilar(1);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[1\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 1);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testStackElementInNonEmptyStack() {
        Pila p=load_stack("1,2",',');
        boolean ap = p.apilar(3);
        System.out.println(p.toString());
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        System.out.println(t);
        String s = p.toString();
        String rx="\\[3,2,1\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 3);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testUnstackStackWithOnlyOneElement() {
        Pila p=load_stack("1",',');
        p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(ev,true);
        assertEquals(t, null);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testUnstackStackWithMoreThanOneElement() {
        Pila p=load_stack("1,2,3",',');
        boolean des=p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[2,1\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(des,true);
        assertEquals(ev,false);
        assertEquals(t, 2);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testUnstackEmptyStack() {
        Pila p=new Pila();
        boolean des = p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s, rx);
        assertEquals(des,false);
        assertEquals(ev,true);
        assertEquals(t, null);
        assertEquals(findSubstring,true);
    };

}
*/