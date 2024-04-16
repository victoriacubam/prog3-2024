package TP2;

public class Recursion {
    //Ejercicio 1
    //Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado

    public static boolean estaOrdenadoAsc (int[] arr, int pos, int value){
        // Si ya llego al final del arreglo retorna true pq recorrio todo el arreglo y estaba ordenado
        if (pos > arr.length-1)
            return true;
        // Si todavia no llegué al final del arreglo y el valor anterior es menor o igual al valor actual sigue preguntando
        else if (pos<= arr.length-1 && value <= arr[pos])
            return estaOrdenadoAsc(arr,pos+1 ,arr[pos]);
        // No esta ordenado
        else
            return false;
    }

    public static boolean estaOrdenadoDesc (int[] arr, int pos, int value){
        // Si ya llego al final del arreglo retorna true pq recorrio todo el arreglo y estaba ordenado
        if (pos > arr.length-1)
            return true;
            // Si todavia no llegué al final del arreglo y el valor anterior es mayor o igual al valor actual sigue preguntando
        else if (pos<= arr.length-1 && value >= arr[pos])
            return estaOrdenadoDesc(arr,pos+1 ,arr[pos]);
            // No esta ordenado
        else
            return false;
    }

    //Ejercicio 2
    //Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado ascendentemente
    public static int existe (int[] arr, int elemento, int pos) {
        //Si encontre el elemento en la posicion actual, la retorno
        if (arr[pos]==elemento)
            return pos;
        //Si el elemento en la posicion actual es menor al elemento buscado y todavia no llegue al final del arreglo
        else if (arr[pos]<elemento && pos <= arr.length-1)
            return existe(arr, elemento,pos+1);
        return -1;
    }

    //Ejercicio 3
    //Implemente un algoritmo recursivo que convierta un número en notación decimal a su equivalente en notación binaria

    public static String equivalenciaBinaria (int valor){
        if (valor==1)
            return "1";
        else if (valor==0)
            return "0";
        else
            return equivalenciaBinaria(valor/2)+ valor%2;
    }
}
