package test.lineales;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import lineales.dinamicas.Pila;

/**
 *
 * @author Catedra EDAT - FAI - UNCOMA
 *         Ultima modificacion: 17/03/2025
 *
 */

public class PilaTest {

    public static Pila load_stack(String elements, char separator) {
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
        System.err.println(p.toString());
        return p;
    }

    @Test
    public void testCreateEmptyStack() {
        Pila p = new Pila(); 
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        assertEquals(ev,true);
        assertEquals(t, null);
        //String rx="\\[\\]";
        //assertEquals(s.matches(rx),true);
    };

    @Test
    public void testStackFirstElement() {
        Pila p=new Pila();
        boolean ap = p.apilar(1);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 1);
        //String rx="\\[1\\]";
        //assertEquals(s.matches(rx),true);

    };

    @Test
    public void testStackElementInNonEmptyStack() {
        Pila p=load_stack("1,2",',');
        boolean ap = p.apilar(3);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        assertEquals(ap,true);
        assertEquals(ev,false);
        assertEquals(t, 3);
        //String rx="\\[1,2,3\\]";
        //assertEquals(s.matches(rx),true);
    };

    @Test
    public void testUnstackStackWithOnlyOneElement() {
        Pila p=load_stack("1",',');
        p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        assertEquals(ev,true);
        assertEquals(t, null);
        //String rx="\\[\\]";
        //assertEquals(s.matches(rx),true);

    };

    @Test
    public void testUnstackStackWithMoreThanOneElement() {
        Pila p=load_stack("1,2,3",',');
        boolean des=p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        assertEquals(des,true);
        assertEquals(ev,false);
        assertEquals(t, 2);
        //String rx="\\[1,2\\]";
        //assertEquals(s.matches(rx),true);

    };

    @Test
    public void testUnstackEmptyStack() {
        Pila p=new Pila();
        boolean des = p.desapilar();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        assertEquals(des,false);
        assertEquals(ev,true);
        assertEquals(t, null);
        //String rx="\\[\\]";
        //assertEquals(s.matches(rx),true);

    };

}