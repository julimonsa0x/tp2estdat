package test.lineales;

import TDA.Alumno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Scanner;
import lineales.estaticas.Pila;
//import static test.lineales.PilaTest.load_stack; // private method!!!!

/**
 * @author Julian Monsalves, Legajo FAI-4479
 * @author Jazmin Elañei Vargas, Legajo FAI-3023
 * @author Julian Nuñez, Legajo FAI-3931
 */
@Deprecated()
public class MyTestPila {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();
        Pila pila3 = new Pila();
        //Pila pila3, pila4;
        
        // test metodo apilar()
        System.out.println("==== RUNNING test.lineales.MyTestPila.java ====");




        /*debugging test3: testStackElementInNonEmptyStack()
        Pila p=load_stack("1,2",',');
        
        p.obtenerTope();


        boolean ap = p.apilar(3);
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        */


        /*
        System.out.println("debugging test1");
        Pila p = new Pila();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        */
        
        System.out.println("Apilando: 5");
        pila1.apilar(5);
        System.out.println("Apilando: 6");
        pila1.apilar(6);
        pila2 = pila1.clone();
        
        System.out.println( pila1.toString() );
        
        // test metodo desapilar()
        System.out.println("Desapilando: 6");
        pila1.desapilar();
        
        System.out.println( pila1.toString() );
        
        // test metodo obtenerTope()
        System.out.println("obteniendo tope: deberia ser 5");
        System.out.println( pila1.obtenerTope() );
        
        // test metodo esVacia()
        System.out.println("metodo esVacia() deberia retornar  false");
        System.out.println(pila1.esVacia());
        
        //test metodo vaciar()
        System.out.println("Vaciando pila1");
        pila1.vaciar();
        
        
        pila2.apilar(2);
        pila2.apilar(5);
        pila2.apilar(4);
        pila2.apilar(6);
        pila2.apilar(8);
        pila2.apilar(1);
        
        
        //test metodo clonar
        System.out.println("Clonando pila2 a pila4 c/ recursion");
        //pila4 = pila2.clonarRec();
        System.out.println("Clonando pila2 a pila3 con .clonar1() de juli N.");
        //pila3 = pila2.clonar1();
        
        //System.out.println("Testeando metodo esPilaCapicua con los siguientes numeros: ");
        //System.out.println(pila3.toString());
        //boolean testeo = esPilaCapicua(pila3);
        //System.out.println(testeo);
        
        
        Alumno alumno1 = new Alumno(4479);
        pila3.apilar(alumno1);
        System.out.println(pila3.obtenerTope().toString());
        pila2.apilar(9);
        pila2.apilar('c');
        System.out.println(pila2.obtenerTope().toString());
        
        
    }
    

    public void testCloneNonEmptyStack(){
        Pila p=load_stack("1,2,3",',');
        Pila pClone=p.clone();
        boolean ev = p.esVacia();
        boolean evClone = pClone.esVacia();
        Object t = p.obtenerTope();
        Object tClone = pClone.obtenerTope();
        String s = p.toString();
        String sClone = pClone.toString();
        String rx="\\[3,2,1\\]";
        boolean findSubstring = isSubstring(s,rx);
        boolean findSubstringClone = isSubstring(sClone, rx);
        assertEquals(ev,false);
        assertEquals(evClone,false);
        assertEquals(t, 3);
        assertEquals(tClone,3);
        assertEquals(findSubstring,true);
        assertEquals(findSubstringClone,true);
        assertNotEquals(pClone,p);
        assertEquals(s,sClone);
    }


    // punto 3 //
    /**
     * 
     * @param laPila
     * @return verdadero si laPila contiene n enteros 
     * y componen un entero capicua
     * Emplea recursividad de DesAlg!
     */
    public static boolean esPilaCapicua(Pila laPila) {
        int cantDigitos = 0, finalNumber=0;
        // armo el numero desde la pila (pop, armo, acumdigit -> repeat)
        while ( !laPila.esVacia() ) {
            finalNumber = finalNumber * 10 + (int) laPila.obtenerTope();
            laPila.desapilar();
            cantDigitos++;
        }
        return esCapicua(finalNumber, cantDigitos);
    }
    
    public static boolean esCapicua(int numero, int digitos) {
        boolean result;
        if (numero < 10) {
            result = true;
        } else {
            int divisor = (int) Math.pow(10, digitos-1);
            
            if (numero/divisor != numero %10) {
                result = false;
            } else {
                int nuevoNumero = (numero % divisor) / 10;
                result = esCapicua(nuevoNumero, digitos -2);
            }
        }
        return result;
    }
    
    public static int contarDigitosLog(int numero) {
        int cantDigits = 0;
        if (numero == 0) {
            cantDigits = 1;
        } else {
            cantDigits = (int) Math.log10(Math.abs(numero)) +1;
        } 
        return cantDigits;
    }
    // fin punto 3 //
    
    
    
    
}
