package punto4;

public class ArbolABB {

    NodoEquipo raiz;

    public ArbolABB() {
        raiz = null;
    }

    public void insertar(int codigo) {
        raiz = insertarRecursivo(raiz, codigo);
    }

    private NodoEquipo insertarRecursivo(NodoEquipo actual, int codigo) {

        if (actual == null) {
            return new NodoEquipo(codigo);
        }

        if (codigo < actual.codigo) {
            actual.izquierda = insertarRecursivo(actual.izquierda, codigo);
        } else if (codigo > actual.codigo) {
            actual.derecha = insertarRecursivo(actual.derecha, codigo);
        }

        return actual;
    }

    public int contarEquiposEnRango(int inferior, int superior) {

        if (inferior > superior) {
            return 0;
        }

        return contarRecursivo(raiz, inferior, superior);
    }

    private int contarRecursivo(NodoEquipo actual, int inferior, int superior) {

        if (actual == null) {
            return 0;
        }

        if (actual.codigo < inferior) {
            return contarRecursivo(actual.derecha, inferior, superior);
        }

        if (actual.codigo > superior) {
            return contarRecursivo(actual.izquierda, inferior, superior);
        }

        return 1
                + contarRecursivo(actual.izquierda, inferior, superior)
                + contarRecursivo(actual.derecha, inferior, superior);
    }
}
