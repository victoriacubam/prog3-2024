package TP4;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		GrafoDirigido<Integer> grafito = new GrafoDirigido<>();
		
		// Agrego los vertices 1 y 2
		grafito.agregarVertice(1);
		grafito.agregarVertice(2);
		grafito.agregarVertice(3);
		grafito.agregarVertice(4);

		// Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
		grafito.agregarArco(1, 2, 3);
		grafito.agregarArco(1,3,null);
		grafito.agregarArco(3,4,null);
		grafito.agregarArco(4,1,null);
		
		// Obtengo el arco entre 1 y 2, y le pido la etiqueta
		Integer etiqueta = grafito.obtenerArco(1, 2).getEtiqueta();
		
		//System.out.println(etiqueta); // Deber�a imprimir 3
		grafito.borrarVertice(3);
		//grafito.borrarArco(1,3);

		Iterator<Integer> itVertices = grafito.obtenerVertices();
		while (itVertices.hasNext()){
			Integer i = itVertices.next();
			System.out.println(i);
		}

		Iterator<Arco<Integer>> itArcos = grafito.obtenerArcos();
		while (itArcos.hasNext()){
			Arco<Integer> i = itArcos.next();
            System.out.println(i);
        }

		grafito.borrarVertice(3);
		//System.out.println(grafito.obtenerVertices());
	}



}
