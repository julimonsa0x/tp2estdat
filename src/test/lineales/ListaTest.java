//package lineales.tests.paraEstudiantes;
package test.lineales;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

import java.util.regex.Matcher;

import org.junit.Test;

import lineales.dinamicas.Lista;
import lineales.estaticas.Cola;

/**
 *
 * @author Catedra EDAT - FAI - UNCOMA
 *         Ultima modificación: 10/04/2025
 *
 */

public class ListaTest {

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

    @Test
    public void testCreateEmptyList() {
        Lista l = new Lista();
        boolean ev = l.esVacia();
        Object e = l.recuperar(1);
        String s = l.toString();
        assertEquals(ev,true);
        assertEquals(e, null);
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testInsertFirstElementInEmptyList() {
        Lista l=new Lista();
        boolean ins = l.insertar(1,1);
        boolean ev = l.esVacia();
        int e = (int) l.recuperar(1);
        String s = l.toString();
        assertEquals(ins,true);
        assertEquals(ev,false);
        assertEquals(e, 1);
        String rx="\\[1\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testInsertLastElementInNonEmtpyList() {
        Lista l=loadList("3,2,1", ',');
        boolean ins = l.insertar(4,4);
        boolean ev = l.esVacia();
        int e = (int) l.recuperar(4);
        String s = l.toString();
        assertEquals(ins,true);
        assertEquals(ev,false);
        assertEquals(e, 4);
        String rx="\\[1,2,3,4\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testInsertElementInTheMiddleOfList() {
        Lista l=loadList("4,2,1", ',');
        boolean ins = l.insertar(3,3);
        boolean ev = l.esVacia();
        int e = (int) l.recuperar(3);
        String s = l.toString();
        assertEquals(ins,true);
        assertEquals(ev,false);
        assertEquals(e, 3);
        String rx="\\[1,2,3,4\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };



    @Test
    public void testRemoveElementFromListWithOnlyOneElement() {
        Lista l=loadList("1",',');
        boolean elim = l.eliminar(1);
        boolean ev = l.esVacia();
        Object e = l.recuperar(1);
        String s = l.toString();
        assertEquals(elim,true);
        assertEquals(ev,true);
        assertEquals(e, null);
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testRemoveElementInTheMiddleOfList() {
        Lista l=loadList("3,2,1",',');
        boolean elim = l.eliminar(2);
        boolean ev = l.esVacia();
        int e = (int) l.recuperar(2);
        String s = l.toString();
        assertEquals(elim,true);
        assertEquals(ev,false);
        assertEquals(e, 3);
        String rx="\\[1,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testRemoveElementAtLastOfNonEmptyList() {
        Lista l=loadList("3,2,1",',');
        boolean elim = l.eliminar(3);
        boolean ev = l.esVacia();
        Object e1 = l.recuperar(3);
        int e2 = (int) l.recuperar(2);
        String s = l.toString();
        assertEquals(elim,true);
        assertEquals(ev,false);
        assertEquals(e1, null);
        assertEquals(e2, 2);
        String rx="\\[1,2\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testRemoveFromEmptyList() {
        Lista l=new Lista();
        boolean sac = l.eliminar(1);
        boolean ev = l.esVacia();
        Object f = l.recuperar(1);
        String s = l.toString();
        assertEquals(sac,false);
        assertEquals(ev,true);
        assertEquals(f, null);
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);

    };

    @Test
    public void testEmptyList() {
        Lista l=loadList("3,2,1",',');
        l.vaciar();
        boolean ev = l.esVacia();
        Object f = l.recuperar(1);
        String s = l.toString();
        assertEquals(ev,true);
        assertEquals(f, null);
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };
    @Test
    public void testFindFirstElement() {
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

    @Test
    public void testFindElementInTheMiddleList() {
        Lista l=loadList("3,2,1",',');
        int pm = (int) l.localizar(2);
        boolean ev = l.esVacia();
        Object e = l.recuperar(2);
        String s = l.toString();
        assertEquals(pm,2);
        assertEquals(ev,false);
        assertEquals(e, 2);
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testFindLastElementInTheList() {
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

    @Test
    public void testFindElementNotInTheList() {
        Lista l=loadList("3,2,1",',');
        int lp = (int) l.localizar(4);
        boolean ev = l.esVacia();
        Object e = l.recuperar(4);
        String s = l.toString();
        assertEquals(lp,-1);
        assertEquals(ev,false);
        assertEquals(e, null);
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        assertEquals(findSubstring,true);
    };

    @Test
    public void testCloneNonEmptyList(){
        Lista l=loadList("3,2,1",',');
        Lista lClone=l.clone();
        boolean ev = l.esVacia();
        boolean evClone = lClone.esVacia();
        Object c = l.recuperar(1);
        Object cClone = lClone.recuperar(1);
        String s = l.toString();
        String sClone = lClone.toString();
        String rx="\\[1,2,3\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,false);
        assertEquals(evClone,false);
        assertEquals(c, 1);
        assertEquals(cClone,1);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(lClone,l);
        assertEquals(s,sClone);
    }

    @Test
    public void testCloneEmptyStack(){
        Lista l=new Lista();
        Lista lClone=l.clone();
        boolean ev = l.esVacia();
        boolean evClone = lClone.esVacia();
        Object c = l.recuperar(1);
        Object cClone = lClone.recuperar(1);
        String s = l.toString();
        String sClone = lClone.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,true);
        assertEquals(evClone,true);
        assertEquals(c, null);
        assertEquals(cClone,null);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(lClone,l);
        assertEquals(s,sClone);
        
    }

}
