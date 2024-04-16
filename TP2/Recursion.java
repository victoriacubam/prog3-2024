package TP2;

public class Recursion {
    //Ejercicio 1
    //Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado

    public static boolean estaOrdenado (int[] arr, int pos, int value){
        // Si ya llego al final del arreglo retorna true pq recorrio todo el arreglo y estaba ordenado
        if (pos > arr.length-1)
            return true;
        // Si todavia no llegué al final del arreglo y el valor anterior es menor o igual al valor actual sigue preguntando
        else if (pos<= arr.length-1 && value <= arr[pos])
            return estaOrdenado(arr,pos+1 ,arr[pos]);
        // No esta ordenado
        else
            return false;
    }


}
