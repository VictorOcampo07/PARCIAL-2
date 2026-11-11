import java.util.Stack;

public class Punto2 {

    public static Stack<String> obtenerSegmento(Stack<String> historial, int inicio, int fin){
        Stack<String> resultado = new Stack<>();

        //Casos base
        if(historial == null || inicio < 1 || inicio > fin) {
            return resultado;
        }

        Stack<String> auxHistorial = new Stack<>();
        Stack<String> tempSegmento = new Stack<>();

        int posicionActual = 1;
        // Recorrer la pila original y extraer los elementos en el rango [inicio, fin]
        while (!historial.isEmpty()) {
            String accion = historial.pop();
            auxHistorial.push(accion); // Resguardo para restaurar la pila original

            if (posicionActual >= inicio && posicionActual <= fin) {
                tempSegmento.push(accion);
            }

            posicionActual++;
        }

        // Restaurar la pila original a su estado y orden exacto
        while (!auxHistorial.isEmpty()) {
            historial.push(auxHistorial.pop());
        }

        // Validación de condición de borde: Si fin superó la cantidad de elementos disponibles
        int totalElementos = posicionActual - 1;
        if (fin > totalElementos) {
            return new Stack<>(); // Retorna pila vacía si fin excede la cantidad de elementos
        }

        // Invertir tempSegmento para que la acción en la posición inicio quede en el tope del resultado
        while (!tempSegmento.isEmpty()) {
            resultado.push(tempSegmento.pop());
        }

        return resultado;
    }

    public static void main(String[] args) {
        Stack<String> historial = new Stack<>();

        // Construcción de la pila 
        // Tope -> A6 -> A5 -> A4 -> A3 -> A2 -> A1
        historial.push("A1");
        historial.push("A2");
        historial.push("A3");
        historial.push("A4");
        historial.push("A5");
        historial.push("A6");

        System.out.println("=== Pila Original (Tope -> Fondo) ===");
        imprimirPila(historial);

        int inicio = 2;
        int fin = 4;
        Stack<String> segmento = obtenerSegmento(historial, inicio, fin);

        System.out.println("\n=== Resultado para inicio = " + inicio + " y fin = " + fin + " (Tope -> Fondo) ===");
        imprimirPila(segmento);

        System.out.println("\n=== Pila Original restaurada ===");
        imprimirPila(historial);
    }

    private static void imprimirPila(Stack<String> pila) {
        @SuppressWarnings("unchecked")
        Stack<String> copia = (Stack<String>) pila.clone();
        while (!copia.isEmpty()) {
            System.out.println("  [Tope -> " + copia.pop() + "]");
        }
    } 
    
}
