package punto4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        ArbolABB arbol = new ArbolABB();

        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
        arbol.insertar(55);
        arbol.insertar(65);

        System.out.print("Ingrese el limite inferior: ");
        int inferior = entrada.nextInt();

        System.out.print("Ingrese el limite superior: ");
        int superior = entrada.nextInt();

        int cantidad = arbol.contarEquiposEnRango(inferior, superior);

        System.out.println("Cantidad de equipos en el rango: " + cantidad);

        entrada.close();
    }
}
