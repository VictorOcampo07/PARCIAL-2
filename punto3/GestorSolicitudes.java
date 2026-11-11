package punto3;

public class GestorSolicitudes {

    public Cola<Solicitud> seleccionarSolicitudes(
            Cola<Solicitud> pendientes, int minutos) {

        Cola<Solicitud> seleccionadas = new Cola<>();
        Cola<Solicitud> altas = new Cola<>();
        Cola<Solicitud> normales = new Cola<>();
        Cola<Solicitud> original = new Cola<>();

        if (minutos <= 0) {
            return seleccionadas;
        }

        // Separar las solicitudes por prioridad
        while (!pendientes.estaVacia()) {

            Solicitud s = pendientes.desencolar();

            original.encolar(s);

            if (s.getPrioridad().equalsIgnoreCase("ALTA")) {
                altas.encolar(s);
            } else {
                normales.encolar(s);
            }
        }

        // Atender primero las solicitudes de prioridad alta
        while (!altas.estaVacia()) {

            Solicitud s = altas.desencolar();

            if (s.getDuracion() <= minutos) {
                seleccionadas.encolar(s);
                minutos = minutos - s.getDuracion();
            }
        }

        // Después atender las solicitudes normales
        while (!normales.estaVacia()) {

            Solicitud s = normales.desencolar();

            if (s.getDuracion() <= minutos) {
                seleccionadas.encolar(s);
                minutos = minutos - s.getDuracion();
            }
        }

        // Recuperar las solicitudes que no fueron seleccionadas
        while (!original.estaVacia()) {

            Solicitud s = original.desencolar();

            if (!contieneSolicitud(seleccionadas, s)) {
                pendientes.encolar(s);
            }
        }

        return seleccionadas;
    }

    private boolean contieneSolicitud(
            Cola<Solicitud> seleccionadas, Solicitud buscada) {

        Cola<Solicitud> auxiliar = new Cola<>();
        boolean encontrada = false;

        while (!seleccionadas.estaVacia()) {

            Solicitud actual = seleccionadas.desencolar();

            if (actual == buscada) {
                encontrada = true;
            }

            auxiliar.encolar(actual);
        }

        while (!auxiliar.estaVacia()) {
            seleccionadas.encolar(auxiliar.desencolar());
        }

        return encontrada;
    }
}