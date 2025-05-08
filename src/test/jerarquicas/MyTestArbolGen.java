package test.jerarquicas;
import jerarquicas.ArbolGen;
import jerarquicas.NodoGen;
import lineales.dinamicas.Lista;

public class MyTestArbolGen {

    public static void main (String[] args) {
        ArbolGen gen1 = new ArbolGen();

        gen1.insertar('a', 'x');
        gen1.insertar('a',null);
        gen1.insertar('b', 'a');

        System.out.println( gen1.toString() );
        
    }
}