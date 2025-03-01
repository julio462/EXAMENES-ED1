import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void ordenar(List<Integer> lista) {
        if (lista.size() < 2) {
            return; // Caso base: lista con un solo elemento ya está ordenada
        }

        int mitad = lista.size() / 2;
        List<Integer> izquierda = new ArrayList<>(lista.subList(0, mitad));
        List<Integer> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        ordenar(izquierda);
        ordenar(derecha);
        
        merge(lista, izquierda, derecha);
    }

    private static void merge(List<Integer> lista, List<Integer> izquierda, List<Integer> derecha) {
        int i = 0, j = 0, k = 0;

        // Mezclar las dos listas ordenadas
        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i) < derecha.get(j)) {
                lista.set(k++, izquierda.get(i++));
            } else {
                lista.set(k++, derecha.get(j++));
            }
        }

        // Si quedan elementos en la lista izquierda
        while (i < izquierda.size()) {
            lista.set(k++, izquierda.get(i++));
        }

        // Si quedan elementos en la lista derecha
        while (j < derecha.size()) {
            lista.set(k++, derecha.get(j++));
        }
    }

    public static void opcionMergeSort(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("❌ No hay datos cargados. Cargue datos primero.");
            return;
        }
        ordenar(lista);
        System.out.println("✅ Lista ordenada con Merge Sort.");
        System.out.println("📊 Lista ordenada: " + lista);
    }
}
