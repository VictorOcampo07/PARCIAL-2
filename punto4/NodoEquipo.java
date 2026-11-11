package punto4;

public class NodoEquipo {

    int codigo;
    NodoEquipo izquierda;
    NodoEquipo derecha;

    public NodoEquipo(int codigo) {
        this.codigo = codigo;
        izquierda = null;
        derecha = null;
    }
}
