import java.util.List;

public class SelectionSort {
    public static void ordenar(List<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j) < lista.get(indiceMinimo)) {
                    indiceMinimo = j;
                }
            }
            // Intercambiar el mínimo encontrado con el primer elemento no ordenado
            int temp = lista.get(i);
            lista.set(i, lista.get(indiceMinimo));
            lista.set(indiceMinimo, temp);
        }
        System.out.println("✅ Lista ordenada con Selection Sort.");
    }

    public static void opcionSelectionSort(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("❌ No hay datos cargados. Cargue datos primero.");
            return;
        }
        ordenar(lista);
        System.out.println("📊 Lista ordenada: " + lista);
    }
}
