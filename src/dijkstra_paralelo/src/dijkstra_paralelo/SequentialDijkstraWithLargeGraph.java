package dijkstra_paralelo;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class SequentialDijkstraWithLargeGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número máximo de nodos en el grafo: ");
        int n = scanner.nextInt();

        SequentialDijkstra.grafo graph = new SequentialDijkstra.grafo(n + 64); // Número máximo de nodos en el grafo

        // Generar aristas con valores aleatorios entre 1 y 100
        Random random = new Random();
        for (char c1 = 'A'; c1 <= 'Z'; c1++) {
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                if (c1 != c2) { // Evitar lazos
                    int weight = random.nextInt(100) + 1; // Valor aleatorio entre 1 y 100
                    graph.addEdge(String.valueOf(c1), String.valueOf(c2), weight);
                }
            }
        }
        for (char c1 = 'a'; c1 <= 'z'; c1++) {
            for (char c2 = 'A'; c2 <= 'Z'; c2++) {
                if (c1 != c2) { // Evitar lazos
                    int weight = random.nextInt(100) + 1; // Valor aleatorio entre 1 y 100
                    graph.addEdge(String.valueOf(c1), String.valueOf(c2), weight);
                }
            }
        }

        // Agregar 120 aristas más
        for (int i = 0; i < 120; i++) {
            char c1 = (char) ('A' + random.nextInt(26));
            char c2 = (char) ('A' + random.nextInt(26));
            int weight = random.nextInt(100) + 1; // Valor aleatorio entre 1 y 100
            graph.addEdge(String.valueOf(c1), String.valueOf(c2), weight);
        }

        // Agregar nodos con nombres del 1 al n
        for (int i = 1; i <= n; i++) {
            graph.addEdge(String.valueOf(i), String.valueOf(i), 0); // Agregar nodo con peso 0
        }

        // Agregar n aristas adicionales entre nodos
        for (int i = 0; i < n; i++) {
            int node1 = random.nextInt(n) + 1; // Nodo aleatorio del 1 al n
            int node2 = random.nextInt(n) + 1; // Nodo aleatorio del 1 al n
            int weight = random.nextInt(200) + 1; // Valor aleatorio entre 1 y 200
            graph.addEdge(String.valueOf(node1), String.valueOf(node2), weight);
        }

        // Agregar aristas que conecten nodos numéricos con nodos de letras minúsculas
        for (int i = 1; i <= n; i++) {
            char letter = (char) ('a' + random.nextInt(26)); // Letra minúscula aleatoria
            int weight = random.nextInt(200) + 1; // Valor aleatorio entre 1 y 200
            graph.addEdge(String.valueOf(i), String.valueOf(letter), weight);
        }

        // Obtener el tiempo de inicio
        long inicio = System.nanoTime();
        SequentialDijkstra.grafo.Result result = graph.dijkstra("H");
        System.out.println("Distancias desde el nodo H:");
        graph.printResult(result, "H");

        // Obtener el tiempo de finalización
        long fin = System.nanoTime();

        // Calcular la duración de la ejecución
        long t = (fin - inicio) / 1_000_000; // Convertir de nanosegundos a milisegundos

        System.out.println("Tiempo de ejecución: " + t + " milisegundos");

        scanner.close();
    }
}
