package TP1;

public class Main {
    public static void main (String[]args){
        MySimpleLinkedList<Integer> listaOrdenadaA = new MySimpleLinkedList<>();

        listaOrdenadaA.insertFront(25);
        listaOrdenadaA.insertFront(10);
        listaOrdenadaA.insertFront(9);
        listaOrdenadaA.insertFront(6);
        listaOrdenadaA.insertFront(5);
        listaOrdenadaA.insertFront(1);

//        System.out.println("Esta vacia: " + listaOrdenadaA.isEmpty());
//        System.out.println("Tamaño: " + listaOrdenadaA.size());
//        System.out.println("Posicion de "+ 1 + ": " + listaOrdenadaA.indexOf(1));
//        System.out.println("Nodo en posicion 2: " + listaOrdenadaA.get(2));
//        System.out.println("Lista: " + listaOrdenadaA);
//
//        Iterator<Integer> it = listaOrdenadaA.iterator();
//
//        while (it.hasNext()){
//            Integer i = it.next();
//            System.out.println(i);
//        }

        MySimpleLinkedList<Integer> listaOrdenadaB = new MySimpleLinkedList<>();
        listaOrdenadaB.insertFront(25);
        listaOrdenadaB.insertFront(17);
        listaOrdenadaB.insertFront(11);
        listaOrdenadaB.insertFront(7);
        listaOrdenadaB.insertFront(6);
        listaOrdenadaB.insertFront(5);
        listaOrdenadaB.insertFront(1);

        MySimpleLinkedList<Integer> listaDesordenadaA = new MySimpleLinkedList<>();
        listaDesordenadaA.insertFront(7);
        listaDesordenadaA.insertFront(1);
        listaDesordenadaA.insertFront(9);
        listaDesordenadaA.insertFront(25);
        listaDesordenadaA.insertFront(5);

        MySimpleLinkedList<Integer> listaDesordenadaB = new MySimpleLinkedList<>();
        listaDesordenadaB.insertFront(5);
        listaDesordenadaB.insertFront(4);
        listaDesordenadaB.insertFront(9);
        listaDesordenadaB.insertFront(11);
        listaDesordenadaB.insertFront(1);

        System.out.println("Ejercicio 5");
        System.out.println("a- Las listas están desordenadas y la lista resultante debe quedar ordenada.");

        System.out.println("Lista Desordenada A: " + listaDesordenadaA);
        System.out.println("Lista Desordenada B: " + listaDesordenadaB);
        System.out.println("Resultado: " + listaDesordenadaA.getElementosComunesListasDesordenadas(listaDesordenadaB));

        System.out.println("\nb- Las listas están ordenadas y la lista resultante debe mantenerse ordenada.");

        System.out.println("Lista Ordenada A: " + listaOrdenadaA);
        System.out.println("Lista Ordenada B: " + listaOrdenadaB);
        System.out.println("Resultado: " + listaOrdenadaA.getElementosComunesListasOrdenadas(listaOrdenadaB));

        System.out.println("--------------------------------------- \n" );

        System.out.println("Ejercicio 6 -- Escriba una función que dadas dos listas construya otra con los elementos que están en la primera pero no en la segunda.");
        System.out.println("Lista Ordenada A: " + listaOrdenadaA);
        System.out.println("Lista Ordenada B: " + listaOrdenadaB);
        System.out.println("Resultado: " + listaOrdenadaA.diferenciarLista(listaOrdenadaB));

    }
}