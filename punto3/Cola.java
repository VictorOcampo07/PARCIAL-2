package punto3;

public class Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamaño;

    public Cola() {
        frente = null;
        fin = null;
        tamaño = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);

        if (estaVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }

        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }

        T dato = frente.getDato();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        tamaño--;
        return dato;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void imprimir() {
        Nodo<T> actual = frente;

        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }

        System.out.println("null");
    }
}
