package laboratorio;

public class Main {
    public static void main(String[] args) {
        GestorImpresiones gestor = new GestorImpresiones();

        gestor.imprimirSiguiente();
        gestor.recuperarUltima();
        gestor.mostrarEstado();

        gestor.registrarDocumento("informe.pdf");
        gestor.registrarDocumento("tarea.docx");
        gestor.registrarDocumento("foto.png");
        gestor.mostrarEstado();

        gestor.imprimirSiguiente();
        gestor.imprimirSiguiente();
        gestor.mostrarEstado();

        gestor.recuperarUltima();
        gestor.mostrarEstado();

        gestor.imprimirSiguiente();
        gestor.imprimirSiguiente();
        gestor.imprimirSiguiente();
        gestor.mostrarEstado();

        gestor.recuperarUltima();
        gestor.mostrarEstado();
    }
}
