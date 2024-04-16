package TP2;

import java.util.Arrays;

import static TP2.Recursion.estaOrdenado;

public class Main {
    public static void main (String[]args){
        int [] arr = {1,1,3,4,6};
        System.out.println("Esta ordenado: " + Arrays.toString(arr) + " - "
                + estaOrdenado(arr, 0, arr[0]));
    }
}
