import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta números enteros al árbol AVL (escribe 'exit' o -1 para terminar):");

        while (true) {
            System.out.print("Número: ");
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("exit") || entrada.equals("-1")) {
                System.out.println("Programa terminado.");
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                arbol.raiz = arbol.insertar(arbol.raiz, numero);
                System.out.println("Árbol AVL actualizado:");
                arbol.printTree(arbol.raiz);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
            }
        }

        sc.close();
    }
}
