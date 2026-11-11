package punto3;

public class Main {

    public static void main(String[] args) {

        Cola<Solicitud> pendientes = new Cola<>();

        pendientes.encolar(new Solicitud("S1", "NORMAL", 10));
        pendientes.encolar(new Solicitud("S2", "ALTA", 30));
        pendientes.encolar(new Solicitud("S3", "ALTA", 15));
        pendientes.encolar(new Solicitud("S4", "NORMAL", 5));

        GestorSolicitudes gestor = new GestorSolicitudes();

        System.out.println("Cola original:");
        pendientes.imprimir();

        Cola<Solicitud> resultado =
                gestor.seleccionarSolicitudes(pendientes, 25);

        System.out.println("\nSolicitudes seleccionadas:");
        resultado.imprimir();

        System.out.println("\nSolicitudes pendientes:");
        pendientes.imprimir();
    }
}