# Java 8 Notes


## Lambda

Otra forma de escribir la implementación de una interfaz menos verbosa, más concisa y fácil de leer. 

El tipo donde se usen tiene que ser una Functional Interface.

En lugar de usar una clase anonima se puede usar una expresión lambda y si en ésta sólo se llama a un método entonces se puede usar
la referencia al método.

Como referencia a un método se puede usar, en la forma Class::instanceMethod, un método de instancia
de la misma clase que se recibe como parámetro en el método de la functional interface, siempre que retornen el mismo tipo. 

(obj, arg) -> obj.doSomething(arg) 


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


### kind of Streams