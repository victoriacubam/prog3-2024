#Trabajos Prácticos Programacion III 2024

## Trabajo práctico N° 1 - Estructuras de datos

`Ejercicio 1`

Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (void insertFront(T), T extractFront(), boolean isEmpty(), int size(), String toString). Agregar también el método: T get(index).


`Ejercicio 2`

Considerando la implementación de la lista vinculada realizada en el ejercicio anterior, comparar la complejidad computacional contra un array en las siguientes operaciones:
1. Insertar al principio.
2. Buscar un elemento en una posición.
3. Determinar la cantidad de elementos.
4. Borrar un elemento de una posición determinada.


`Ejercicio 3`

A la implementación de la clase Lista realizada en el ejercicio 1, agregue un métodoint indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese elemento, o -1 si el elemento no existe en la lista.


`Ejercicio 4`

A partir de la clase Lista implementada en el ejercicio 1, implemente el patróniterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la hora de recorrer la lista de principio a fin si se cuenta con un iterador?


`Ejercicio 5`

Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,suponiendo que: 

* a) Las listas están desordenadas y la lista resultante debe quedar ordenada. 

* b)Las listas están ordenadas y la lista resultante debe mantenerse ordenada.


`Ejercicio 6`

Escriba una función que dadas dos listas construya otra con los elementos que están en laprimera pero no en la segunda.


`Ejercicio 7`

Considerando la implementación de Lista del ejercicio 1, realice una Lista doblemente vinculada. ¿Podemos ahora revisar la implementación inicial de nuestra lista para extender su funcionalidady/o bajar la complejidad de los métodos ya implementados

***

## Trabajo práctico N° 2 -  Recursión y ordenamiento
### Primera parte

`Ejercicio 1`

Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado y responda:
1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?

   
`Ejercicio 2`

Implemente un algoritmo recursivo para buscar un elemento en un arreglo ordenado ascendentemente.


`Ejercicio 3`

Implemente un algoritmo recursivo que convierta un número en notación decimal a su equivalente en notación binaria. Recordatorio, por ejemplo convertir el 26 a binario:


`Ejercicio 4`

Implemente un algoritmo recursivo que presente los primeros N términos de la secuencia de Fibonacci. 

Por ej. los 6 primeros términos son: 0 1 1 2 3 5


`Ejercicio 5`

Dado un arreglo ordenado de números distintos A se desea construir un algoritmo que determine si alguno de los elementos de dicho arreglo contiene un valor igual a la posición en la cuál se encuentra, es decir, A[i] = i.
1. Construir un algoritmo recursivo que responda a dicha verificación.
2. Mostrar la pila de ejecución para la invocación algoritmo([-3, -1, 0, 2, 4, 6, 10])

   
`Ejercicio 6`

Implemente un algoritmo de ordenamiento por selección en un arreglo.
Implemente un algoritmo de ordenamiento por burbujeo en un arreglo.
● ¿Qué complejidad big-O tienen estos algoritmos?


`Ejercicio 7`

Implemente un algoritmo de ordenamiento mergesort para un arreglo de tamaño N.
Implemente un algoritmo de ordenamiento quicksort para un arreglo de tamaño N.
● ¿Cuál es su complejidad en el peor caso?
● ¿Cuál es su complejidad promedio?


`Ejercicio 8`

Investigar cómo está implementado el algoritmo Collection.Sort de Java y qué características
deben cumplir los elementos almacenados dentro de la colección a ordenar
