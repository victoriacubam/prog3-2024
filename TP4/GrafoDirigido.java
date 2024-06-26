package TP4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private Integer cantidadVertices, cantidadArcos;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
		this.cantidadVertices = 0;
		this.cantidadArcos = 0;
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!this.contieneVertice(verticeId)){
			this.vertices.put(verticeId, new ArrayList<>());
			this.cantidadVertices++;
		}
	}

	//Borrar el vertice y borrar las posibles conexiones que tiene con otros vertices
	//(o sea, los arcos donde verticeId es destino)
	//Para cada vertice buscar todos sus arcos y para cada arco preguntar si verticeId es destino y borrarlo
	@Override
	public void borrarVertice(int verticeId) {
		if (this.contieneVertice(verticeId)){
			for(Integer v:this.vertices.keySet()){
				ArrayList<Arco<T>> arcos = this.vertices.get(v);
				for (Arco<T> a : arcos){
					if (a.getVerticeDestino()==verticeId)
						this.borrarArco(v, verticeId);
				}
			}
			this.vertices.remove(verticeId);
			this.cantidadVertices--;
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (this.contieneVertice(verticeId1)&&this.contieneVertice(verticeId2)){
			this.vertices.get(verticeId1).add(new Arco<>(verticeId1, verticeId2, etiqueta));
			this.cantidadArcos++;
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if (this.existeArco(verticeId1, verticeId2)){
			ArrayList<Arco<T>> arcos = this.vertices.get(verticeId1);
			int i=0;
			while (arcos.get(i).getVerticeDestino()!=verticeId2 && i<arcos.size())
				i++;
			arcos.remove(i);
			this.cantidadArcos--;
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if (contieneVertice(verticeId1) && contieneVertice(verticeId2)){
			ArrayList<Arco<T>> arcos = this.vertices.get(verticeId1);
			if (!arcos.isEmpty()){
				//Con for, cortar un for es pecado capital?
				for (Arco<T> a : arcos){
					if (a.getVerticeDestino()==verticeId2)
						return true;
				}

				//Con while arcos.get(i) tiene complejidad O(1)
				int i = 0;
				while (arcos.get(i).getVerticeDestino()!=verticeId2 && i<arcos.size()){
					i++;
				}
				if (arcos.get(i).getVerticeDestino()==verticeId2)
					return true;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		ArrayList<Arco<T>> arcos = this.vertices.get(verticeId1);
		if (!arcos.isEmpty()){
			//Con for, cortar un for es pecado capital?
			for (Arco<T> a : arcos){
				if (a.getVerticeDestino()==verticeId2)
					return new Arco<>(a.getVerticeOrigen(), a.getVerticeDestino(), a.getEtiqueta());
			}
			//Con while, tiene mas complejidad?
			int i = 0;
			while (arcos.get(i).getVerticeDestino()!=verticeId2 && i<arcos.size()){
				i++;
			}
			if (arcos.get(i).getVerticeDestino()==verticeId2)
				return new Arco<>(verticeId1, verticeId2, arcos.get(i).getEtiqueta());
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.cantidadVertices;
	}

	@Override
	public int cantidadArcos() {
		return this.cantidadArcos;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> arcos = this.vertices.get(verticeId);
		ArrayList<Integer> adyacentes = new ArrayList<>();
		for (Arco<T> a : arcos){
			adyacentes.add(a.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for(Integer v:this.vertices.keySet())
            arcos.addAll(this.vertices.get(v));
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return this.vertices.get(verticeId).iterator();
	}

}
