import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    // Método que realiza la búsqueda binaria
    public static int buscar(List<Integer> lista, int objetivo) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            
            // Si encontramos el elemento
            if (lista.get(medio) == objetivo) {
                return medio; // Devuelve el índice del elemento
            }
            
            // Si el objetivo es mayor que el elemento medio
            if (lista.get(medio) < objetivo) {
                inicio = medio + 1;
            } 
            // Si el objetivo es menor que el elemento medio
            else {
                fin = medio - 1;
            }
        }
        
        return -1; // Si el elemento no está presente en la lista
    }

    // Método para interactuar con el usuario y realizar la búsqueda
    public static void opcionBinarySearch(List<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("❌ No hay datos cargados. Cargue datos primero.");
            return;
        }

        // Solicitar al usuario el número que desea buscar
        System.out.print("Ingrese el número que desea buscar: ");
        Scanner scanner = new Scanner(System.in);  // Usar un único Scanner
        int objetivo = scanner.nextInt();
        
        // Realizar la búsqueda binaria
        int resultado = buscar(lista, objetivo);
        
        // Mostrar el resultado
        if (resultado == -1) {
            System.out.println("❌ El número no está en la lista.");
        } else {
            System.out.println("✅ El número " + objetivo + " se encuentra en el índice: " + resultado);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        List<Integer> lista = List.of(1, 3, 5, 7, 9, 11, 13);
        opcionBinarySearch(lista);
    }
}

   