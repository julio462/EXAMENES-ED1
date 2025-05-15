import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AVLTree {
    Node raiz;

    public int getAltura(Node nodo) {
        return nodo == null ? 0 : nodo.altura;
    }

    public int getFactorBalance(Node nodo) {
        return (nodo == null) ? 0 : getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    public Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;
        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;

        return x;
    }

    public Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;
        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;

        return y;
    }

    public Node insertar(Node nodo, int valor) {
        if (nodo == null)
            return new Node(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo;

        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));

        int balance = getFactorBalance(nodo);

        // Casos de desbalance
        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotarDerecha(nodo); // LL

        if (balance < -1 && valor > nodo.derecha.valor)
            return rotarIzquierda(nodo); // RR

        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo); // LR
        }

        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo); // RL
        }

        return nodo;
    }

    public void printTree(Node root) {
        int maxLevel = maxDepth(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }
    
    private void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return;
    
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;
    
        printWhitespaces(firstSpaces);
    
        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.valor);
                newNodes.add(node.izquierda);
                newNodes.add(node.derecha);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }
    
            printWhitespaces(betweenSpaces);
        }
        System.out.println();
    
        // Dibuja las ramas / \
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines * 2 + i + 1);
                    continue;
                }
    
                if (nodes.get(j).izquierda != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);
    
                printWhitespaces(i * 2 - 1);
    
                if (nodes.get(j).derecha != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);
    
                printWhitespaces(edgeLines * 2 - i);
            }
            System.out.println();
        }
    
        printNodeInternal(newNodes, level + 1, maxLevel);
    }
    
    private void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    
    private int maxDepth(Node node) {
        if (node == null) return 0;
        return Math.max(maxDepth(node.izquierda), maxDepth(node.derecha)) + 1;
    }
    
    private boolean isAllElementsNull(List<Node> list) {
        for (Node node : list) {
            if (node != null) return false;
        }
        return true;
    }
}    
