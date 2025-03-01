import java.util.List;

public class EnhancedBubbleSort {
    public static void ordenar(List<Integer> lista) {
        int n = lista.size();
        boolean intercambiado;
        
        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    // Intercambiar elementos
                    int temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                    intercambiado = true;
                }
            }
            
            // Si no hubo intercambios, la lista ya está ordenada
            if (!intercambiado) break;
        }
        System.out.println("✅ Lista ordenada con Enhanced Bubble Sort.");
    }

    public static void opcionEnhancedBubbleSort(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("❌ No hay datos cargados. Cargue datos primero.");
            return;
        }
        ordenar(lista);
        System.out.println("📊 Lista ordenada: " + lista);
    }
}
