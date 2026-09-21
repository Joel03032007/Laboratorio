# Laboratorio

Gestor de Impresiones - Laboratorio de Estructuras de Datos
Este proyecto consiste en la implementación de un sistema gestor de colas e historial de impresiones desarrollado en Java, aplicando los conceptos de Pilas (Stack / LIFO) y Colas (Queue / FIFO) mediante la interfaz estandarizada Deque<E> y su implementación ArrayDeque.
📋 Descripción del Sistema
El Gestor de Impresiones simula el comportamiento de una cola de impresión en un entorno operativo, gestionando dos flujos de trabajo principales:
Gestión de Pendientes (Cola / FIFO): Los documentos registrados entran al final de la cola y son procesados en el orden estricto de llegada (el primero en entrar es el primero en imprimirse).
Gestión de Historial (Pila / LIFO): Los documentos ya impresos se almacenan en una pila. Esto permite realizar operaciones de cancelación/recuperación donde el último documento impreso es el primero en ser rescatado y reubicado al frente de la cola de impresión.
🏗️ Estructura del Código
El proyecto está organizado dentro del paquete laboratorio y consta de dos clases principales:
1. GestorImpresiones.java
Es la clase lógica que administra el estado y las operaciones del sistema.
Atributos:
pendientes: Deque<String> — Estructura que opera como Cola (FIFO) para almacenar los nombres de los documentos que esperan ser impresos.
historial: Deque<String> — Estructura que opera como Pila (LIFO) para almacenar el registro de los documentos ya impresos.
Métodos principales:
registrarDocumento(String nombre): Añade un documento al final de la cola usando offerLast().
imprimirSiguiente(): Retira y procesa el primer documento de la cola usando pollFirst(), registrándolo automáticamente en el historial.
guardarImpresion(String nombre): Método privado auxiliar que inserta un documento impreso en la cima del historial usando push().
recuperarUltima(): Saca el último documento procesado del historial mediante pop() y lo reinserta al principio de la cola de pendientes con addFirst().
mostrarEstado(): Muestra por consola el contenido actual tanto de la cola de pendientes como del historial.
2. Main.java
Clase de prueba encargada de ejecutar un flujo continuo de operaciones combinadas (mínimo 6) para validar el comportamiento correcto de ambas estructuras, verificando casos límite como el intento de extracción en colecciones vacías.
📐 Diagrama de Clases (PlantUML)
El diseño del software responde a la siguiente estructura de clases orientada a objetos:
@startuml Gestor_de_Impresiones

title Diagrama de Clases - Gestor de Impresiones

class Main {
  + {static} main(args: String[]) : void
}

class GestorImpresiones {
  - pendientes: Deque<String>
  - historial: Deque<String>
  + GestorImpresiones()
  + registrarDocumento(nombre: String): void
  + imprimirSiguiente(): void
  - guardarImpresion(nombre: String): void
  + recuperarUltima(): void
  + mostrarEstado(): void
}

interface "Deque<E>" as Deque <<java.util>> {
  + offerLast(e: E): boolean
  + pollFirst(): E
  + push(e: E): void
  + pop(): E
  + addFirst(e: E): void
}

class "ArrayDeque<E>" as ArrayDeque <<java.util>> implements Deque {
}

Main ..> GestorImpresiones : usa
GestorImpresiones o-- "2" Deque : contiene >
GestorImpresiones ..> ArrayDeque : instancia >

@enduml



🔄 Mapeo de Operaciones y Estructuras
Acción en el Negocio
Estructura Usada
Operación de Deque
Comportamiento
Registrar documento
pendientes
offerLast(nombre)
Entra al final de la cola.
Imprimir siguiente
pendientes
pollFirst()
Sale el más antiguo (frente).
Guardar impresión
historial
push(nombre)
Entra en la cima de la pila.
Recuperar última
historial y pendientes
pop() y addFirst()
Sale de la cima y entra al frente de la cola.

🚀 Requisitos e Instalación
Prerrequisitos
JDK: Java Development Kit 8 o superior.
IDE / Compilador: Cualesquiera compatible con Java (VS Code, IntelliJ IDEA, Eclipse, NetBeans) o línea de comandos.
Compilación y Ejecución desde Terminal
Clonar/Guardar el código: Asegúrate de colocar los archivos en la estructura de carpetas correspondiente al paquete laboratorio/.
Compilar:
javac laboratorio/GestorImpresiones.java laboratorio/Main.java



Ejecutar:
java laboratorio.Main



🧪 Validaciones Implementadas
Manejo de subdesbordamiento (Underflow): Métodos como imprimirSiguiente() y recuperarUltima() incluyen validaciones previas (isEmpty()) para evitar excepciones como NoSuchElementException cuando las colecciones están vacías.
Integridad del flujo: Los documentos recuperados mediante recuperarUltima() no se pierden ni se duplican; se transfieren de forma atómica de la pila al frente de la cola para ser reimpresos con máxima prioridad.
