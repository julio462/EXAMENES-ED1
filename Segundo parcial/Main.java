public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        System.out.println("Paso 1: Agregar el número 0 al inicio de la lista");
        list.addFirst(0);
        list.printList();
        
        System.out.println("Paso 2: Agregar el número 2 al final de la lista");
        list.add(2);
        list.printList();
        
        System.out.println("Paso 3: Agregar el número 4 al medio de la lista (posición 1)");
        list.addMiddle(4, 1);
        list.printList();
        
        System.out.println("Paso 4: Mostrar la lista actual");
        list.printList();
        
        System.out.println("Paso 5: Remover el número 2 de la lista");
        list.remove(2);
        list.printList();
        
        System.out.println("Paso 6: Mostrar la lista después de la eliminación");
        list.printList();
        
        System.out.println("Paso 7: Agregar el número 6 al final de la lista");
        list.add(6);
        list.printList();
        
        System.out.println("Paso 8: Verificar si el número 4 está en la lista");
        System.out.println("¿Contiene 4? " + list.contains(4));
        
        System.out.println("Paso 9: Verificar si el número 8 está en la lista");
        System.out.println("¿Contiene 8? " + list.contains(8));
        
        System.out.println("Paso 10: Revertir la lista");
        list.reverse();
        list.printList();
        
        System.out.println("Paso 11: Mostrar la lista después de revertir");
        list.printList();
        
        System.out.println("Paso 12: Agregar el número 8 al inicio de la lista");
        list.addFirst(8);
        list.printList();
        
        System.out.println("Paso 13: Mostrar la lista final");
        list.printList();
    }
}
