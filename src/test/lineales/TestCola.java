package test.lineales;

import lineales.dinamicas.Cola;

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
        //c1.sacar();
        c1.poner("pepe3");
        c1.poner("pepe4");
        c1.sacar();
        c1.poner("pepe5");
        c2 = c1.clonar();
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

        System.out.println( c1.toString() );
    }
    
}
