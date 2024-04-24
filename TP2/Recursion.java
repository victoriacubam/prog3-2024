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

    //Ejercicio 4
    //Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de Fibonacci.
    // 0 1 1 2 3 5 8 13 21
   /* public static int secuenciaFibo (int n, int a, int b){ // 0 1   1 2  3 5
        if() {
            return;
        } else {

        }
    }*/

    //Ejercicio 5
    //Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que
    //determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la
    //cuál se encuentra, es decir, A[i] = i.

    public static int posicionValorIgual (int [] arr, int pos){
        if (arr[pos]==pos){ //[-1,-2,(2),3,4],
            return pos;
        } else if (arr[pos]<pos && arr.length>pos+1){
            return posicionValorIgual(arr, pos+1);
        } else {
            return -1;
        }
    }

    //Ejercicio 6
    //Implemente un algoritmo de ordenamiento por selección en un arreglo.
    //Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.

    public static int [] ordenamientoBurbujeo (int [] arr){
        // 8 4 7 5 1 9
        for (int i=0 ; i<arr.length-1; i++){
            for (int j=0 ; j<arr.length-1; j++){
                if (arr[i]>arr[i+1]){
                    int aux = arr[i];
                    arr[i] = arr[i+j];
                    arr[i +j] = aux;
                }
            }

        }
       return arr;
    }

    //Ejercicio 7
    //Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
    //Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
    

}
