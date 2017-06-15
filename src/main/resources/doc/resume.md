# Java 8 


##Lambda

Instead of using an anonymous class you can use a lambda expression and if this just calls one method, you can use a method reference.

Se puede usar como referencia a un método, en la forma Class::instanceMethod, un metodo de instancia
de la misma clase que se recibe como parámetro en el método de la functional interface, siempre que retornen el mismo tipo. 

(obj, arg) -> obj.doSomething(arg) 


##Streams

###Monad

Un decorator que obedece a ciertas reglas. Permite concatenar llamadas; procesar datos en una secuencia de pasos (tuberias informáticas). 
Han sido descritas como punto y comas programables. 
Se comportan como una línea de ensamblaje, en las que un objeto transporta datos entre unidades funcionales que hacen transformaciones en cada paso.
En programacion funcional es un patrón de diseño para construir tipos genéricos.

** En informática, una tubería (pipe, cauce o '|') consiste en una cadena de procesos conectados de forma tal que la salida de cada elemento
de la cadena es la entrada del próximo. Permiten la comunicació y sincronización entre procesos.


###¿Que son los Streams?


Los Stream en Java 8 son monadas. Un Stream representa una secuencia de elementos y diferentes tipos de operaciones a aplicar sobre estos elementos.

Pueden ser intermediate (return a stream) o terminal (void or return a non-stream result).


###kind of Streams




 