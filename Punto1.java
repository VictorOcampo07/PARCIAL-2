import java.util.Stack;

public class Punto1 {

    public enum Estado {
        CONFIRMADA,
        ANULADA
    }

    public static class Operacion {
        private String codigo;
        private Estado estado;

        public Operacion(String codigo, Estado estado) {
            this.codigo = codigo;
            this.estado = estado;
        }

        public String getCodigo() {
            return codigo;
        }

        public Estado getEstado() {
            return estado;
        }

        @Override
        public String toString() {
            return codigo + " (" + estado + ")";
        }
    }

    public static Stack<Operacion> obtenerUltimasConfirmadas(Stack<Operacion> historial, int n) {
        Stack<Operacion> resultado = new Stack<>();

        // caso base
        if (n <= 0 || historial == null || historial.isEmpty()) {
            return resultado;
        }

        Stack<Operacion> auxHistorial = new Stack<>();
        Stack<Operacion> tempConfirmadas = new Stack<>();

        // 1. Recorrer la pila original buscando las n operaciones confirmadas
        while (!historial.isEmpty()) {
            Operacion op = historial.pop();
            auxHistorial.push(op); // Guardar para restaurar después

            if (op.getEstado() == Estado.CONFIRMADA && tempConfirmadas.size() < n) {
                tempConfirmadas.push(op);
            }
        }

        // 2. Restaurar la pila original a su estado y orden exacto
        while (!auxHistorial.isEmpty()) {
            historial.push(auxHistorial.pop());
        }

        // 3. Pasar las confirmadas a la pila de resultado para mantener la más reciente en el tope
        while (!tempConfirmadas.isEmpty()) {
            resultado.push(tempConfirmadas.pop());
        }

        return resultado;
    }
    public static void main(String[] args) {
        Stack<Operacion> historial = new Stack<>();

        // Construcción de la pila
        // Apilamos desde la más antigua (fondo) a la más reciente (tope).
        // Fondo: O1 -> O2 -> O3 -> O4 -> O5 :Tope
        historial.push(new Operacion("O1", Estado.ANULADA));
        historial.push(new Operacion("O2", Estado.CONFIRMADA));
        historial.push(new Operacion("O3", Estado.CONFIRMADA));
        historial.push(new Operacion("O4", Estado.ANULADA));
        historial.push(new Operacion("O5", Estado.CONFIRMADA));

        System.out.println("=== Pila original antes de la función (Tope a Fondo) ===");
        imprimirPilaDesdeTope(historial);

        int n = 2;
        Stack<Operacion> resultado = obtenerUltimasConfirmadas(historial, n);

        System.out.println("\n=== Resultado para n = " + n + " (Tope a Fondo) ===");
        imprimirPilaDesdeTope(resultado);

        System.out.println("\n=== Pila original después de la función (debe conservar orden) ===");
        imprimirPilaDesdeTope(historial);
    }
    private static void imprimirPilaDesdeTope(Stack<Operacion> pila) {
        @SuppressWarnings("unchecked")
        Stack<Operacion> copia = (Stack<Operacion>) pila.clone();
        while (!copia.isEmpty()) {
            System.out.println("  [Tope -> " + copia.pop() + "]");
        }
    }
}