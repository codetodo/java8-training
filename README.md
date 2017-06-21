# Java 8 Notes


## Lambda

Otra forma de escribir la implementación de una interfaz menos verbosa, más concisa y fácil de leer. 

El tipo donde se usen tiene que ser una Functional Interface. Each functional interface has a single abstract method, 
called the functional method for that functional interface, to which the lambda expression's parameter and return
types are **matched or adapted**.

En lugar de usar una clase anonima se puede usar una expresión lambda y si en ésta sólo se llama a un método entonces se puede usar
la referencia al método.

Como referencia a un método se puede usar, en la forma Class::instanceMethod, un método de instancia
de la misma clase que se recibe como parámetro en el functional method. 

```
(obj, arg) -> obj.doSomething(arg) 
```


## Streams

### Monad

Un decorator que obedece a ciertas reglas. Permite concatenar llamadas; procesar datos en una secuencia de pasos (tuberias informáticas). 
Han sido descritas como punto y comas programables. 
Se comportan como una línea de ensamblaje, en las que un objeto transporta datos entre unidades funcionales que hacen transformaciones en cada paso.
En programacion funcional es un patrón de diseño para construir tipos genéricos.

** En informática, una tubería (pipe, cauce o '|') consiste en una cadena de procesos conectados de forma tal que la salida de cada elemento
de la cadena es la entrada del próximo. Permiten la comunicació y sincronización entre procesos.


### ¿Que son los Streams?

Los Stream en Java 8 son monadas. Un Stream representa una secuencia de elementos y diferentes tipos de operaciones a aplicar sobre estos elementos.

Pueden ser intermediate (return a stream) o terminal (void or return a non-stream result).


### Tipos de Streams

La instancia de un Stream se puede obtener a partir de varias fuentes de datos, principalmente de colecciones. A través de los métodos stream() y parallelStream() se puede crear un Stream secuencial o paralelo.

Para trabajar con los tipos primitivos int, long y double java trae los Stream: IntStream, LongStream y DoubleStream.

Utilizando IntStream.range() se puede remplazar el ciclo for:

```
IntStream.range(2, 5)
    .forEach(System.out::println);

// 2
// 3
// 4
```

Estos Stream de tipos primitivos soportan las operaciones finales: sum() y average().


### Operations

**Collect**

Con esta operación se puede recoger el resultado de la ejecución del Stream y almacenarlo en un tipo final. 
El collector es el paso final en la linea de ensamblaje y marca como va a quedar el producto final.
Es como implementarle un return al stream.

**FlatMap**

Transforma cada elemento del Stream en otro Stream de objetos.

**Reduce**

Combina todos los elementos del stream en un solo resultado.
















































































