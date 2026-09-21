package laboratorio;

import java.util.ArrayDeque;
import java.util.Deque;

public class GestorImpresiones {

    private Deque<String> pendientes;
    private Deque<String> historial;

    public GestorImpresiones() {
        pendientes = new ArrayDeque<>();
        historial = new ArrayDeque<>();
    }

    public void registrarDocumento(String nombre) {
        pendientes.offerLast(nombre);
        System.out.println("Registrado: " + nombre);
    }

    public void imprimirSiguiente() {
        if (pendientes.isEmpty()) {
            System.out.println("No hay documentos pendientes para imprimir");
            return;
        }
        String nombre = pendientes.pollFirst();
        System.out.println("Imprimiendo: " + nombre);
        guardarImpresion(nombre);
    }

    private void guardarImpresion(String nombre) {
        historial.push(nombre);
    }

    public void recuperarUltima() {
        if (historial.isEmpty()) {
            System.out.println("No hay impresiones en el historial para recuperar");
            return;
        }
        String nombre = historial.pop();
        pendientes.addFirst(nombre);
        System.out.println("Recuperado al frente: " + nombre);
    }

    public void mostrarEstado() {
        System.out.println("Pendientes: " + pendientes);
        System.out.println("Historial : " + historial);
        System.out.println();
    }
}
