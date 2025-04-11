package test.lineales;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import TDA.Alumno;
import lineales.dinamicas.Cola;

/**
 *
 * @author julian.monsalves
 * tests de cola estatica: 9/9
 * tests de cola dinamica: 9/9
 */
public class MyTestCola {

    public static void main(String[] args) {
        Cola c1 = new Cola();
        Cola c2 = new Cola();
        
        // tests debugging
        testAddFirstElement();
        testAddElementInNonEmptyQueue();
        testCloneEmptyQueue();
        
        
        
        Alumno alumno1 = new Alumno(1234);
        alumno1.setNombre("Julian");
        c1.poner("pepe1");
        c1.poner("pepe2");
        c1.poner("pepe2.5");
        c1.poner("pepe2.6");
        c1.poner("pepe2.7");
        c1.vaciar();
        c1.toString();
        //c1.sacar();
        c1.poner("pepe3");
        c1.poner("pepe4");
        c1.poner("pepe4.5");
        //c1.sacar();
        c1.poner("pepe5");
        c1.poner(alumno1);
        c2 = c1.clone();
        alumno1.setNombre("Julianito");
        c2.poner(999);
        c1.poner("pepe6");
        c1.sacar();
        c1.poner("pepe7");
        c1.poner("pepe8");
        c1.sacar();
        c1.sacar();
        c1.sacar();
        c1.poner("pepe9");
        c1.poner("pepe10");
        c1.poner("pepe11");
        c1.sacar();
        c1.sacar();
        c1.sacar();
        c1.poner("pepe12");
        c1.poner("pepe13");
        c1.poner("pepe14");
        c1.poner("pepe15");
        c1.poner("pepe16");
        c1.poner("pepe17");
        c1.poner("pepe18");
        c1.poner("pepe19");

        System.out.println( c1.toString() );

    }



    
    public static void testAddFirstElement() {
        Cola c=new Cola();
        boolean po = c.poner(1);
        boolean ev = c.esVacia();
        Object f = c.obtenerFrente();
        String s = c.toString();
        //assertEquals(po,true);
        //assertEquals(ev,false);
        //assertEquals(f, 1);
        String rx="\\[1\\]";
        System.err.println(s);
        //assertEquals(s.matches(rx),true);

    };

    public static void testAddElementInNonEmptyQueue() {
        //Cola c=loadQueue("1,2",',');
        Cola c= new Cola();
        c.poner(1);
        c.poner(2);
        boolean po = c.poner(3);
        boolean ev = c.esVacia();
        int f =(int) c.obtenerFrente();
        String s = c.toString();
        assertEquals(po,true);
        assertEquals(ev,false);
        assertEquals(f, 1);
        String rx="\\[1,2,3\\]";
        assertEquals(s.matches(rx),true);
    };

    

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

    public static void testCloneEmptyQueue(){
        Cola c=new Cola();
        Cola cClone=c.clone();
        boolean ev = c.esVacia();
        boolean evClone = cClone.esVacia();
        Object f = c.obtenerFrente();
        Object fClone = cClone.obtenerFrente();
        String s = c.toString();
        String sClone = cClone.toString();
        String rx="\\[\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,true);
        assertEquals(evClone,true);
        assertEquals(f, null);
        assertEquals(fClone,null);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(cClone,c);
        assertEquals(s,sClone);
        
    }
    
}
