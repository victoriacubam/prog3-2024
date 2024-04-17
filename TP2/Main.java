package TP2;
import java.sql.SQLOutput;
import java.util.Arrays;

import static TP2.Recursion.*;

public class Main {
    public static void main (String[]args){

        //Ejercicio 1
        int [] arr1 = {1,1,3,4,6};
        System.out.println("Esta ordenado ASCENDENtE: " + Arrays.toString(arr1) + " - "
                + estaOrdenadoAsc(arr1, 0, arr1[0]));
        int [] arr2 = {10,9,5,4,1};
        System.out.println("Esta ordenado DESCENDENTE: " + Arrays.toString(arr2) + " - "
                + estaOrdenadoDesc(arr2, 0, arr2[0]));


        //Ejercicio 2
        int [] arr3 = {4,5,7,9};
        System.out.println("Existe el elemento 5: " + existe(arr3, 5, 0));

        //Ejercicio 3
        System.out.println("Binario de 255: " + equivalenciaBinaria(255));

        //Ejercicio 5
        int [] arr4 = {-1,-2,2,3,4,5,7,9};
        System.out.println(posValorIgual(arr4, 0));
    }
}
