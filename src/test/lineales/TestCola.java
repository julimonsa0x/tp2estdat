package test.lineales;

import lineales.estaticas.Cola;

/**
 *
 * @author julian.monsalves
 */
public class TestCola {

    public static void main(String[] args) {
        Cola c1 = new Cola();
        Cola c2 = new Cola();
        c1.poner("pepe1");
        c1.poner("pepe2");
        c1.poner("pepe3");
        c1.poner("pepe4");
        c1.poner("pepe5");
        c1.poner("pepe6");
        c1.poner("pepe7");
        c1.poner("pepe8");
        c1.toString();
    }
    
}
