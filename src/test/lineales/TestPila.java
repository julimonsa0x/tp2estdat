package test.lineales;

import TDA.Alumno;
import java.util.Scanner;
import lineales.dinamicas.Pila;

/**
 *
 * @author julian.monsalves
 */
@Deprecated(since = "27-03-2025", forRemoval = true)
public class TestPila {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();
        Pila pila3, pila4;
        
        // test metodo apilar()
        System.out.println("==== RUNNING test.lineales.TestPila.java ====");

        System.out.println("debugging test1");
        Pila p = new Pila();
        boolean ev = p.esVacia();
        Object t = p.obtenerTope();
        String s = p.toString();
        
        
        System.out.println("Apilando: 5");
        pila1.apilar(5);
        System.out.println("Apilando: 6");
        pila1.apilar(6);
        
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
        pila4 = pila2.clonarRec();
        System.out.println("Clonando pila2 a pila3 con .clonar1() de juli N.");
        pila3 = pila2.clonar1();
        
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
