package dijkstra_paralelo;

import java.util.*;

public class SequentialDijkstra {

    static class grafo {
        private final Map<String, Integer> nodeIndexMap;
        private final List<String> nodes;
        private final int[][] adjMatrix;

        public grafo(int maxNodes) {
            nodeIndexMap = new HashMap<>();
            nodes = new ArrayList<>();
            adjMatrix = new int[maxNodes][maxNodes];
        }

        public void addNode(String node) {
            if (!nodeIndexMap.containsKey(node)) {
                int index = nodes.size();
                nodes.add(node);
                nodeIndexMap.put(node, index);
            }
        }

        public void addEdge(String src, String dest, int weight) {
            addNode(src);
            addNode(dest);
            int srcIndex = nodeIndexMap.get(src);
            int destIndex = nodeIndexMap.get(dest);
            adjMatrix[srcIndex][destIndex] = weight;
            adjMatrix[destIndex][srcIndex] = weight; // Si el gráfico es no dirigido
        }

        public Result dijkstra(String startNode) {
            int V = nodes.size();
            int[] dist = new int[V];
            int[] pred = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(pred, -1);
            int srcIndex = nodeIndexMap.get(startNode);
            dist[srcIndex] = 0;

            boolean[] visited = new boolean[V];
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(node -> dist[node]));
            pq.add(srcIndex);

            while (!pq.isEmpty()) {
                int u = pq.poll();
                if (visited[u]) continue;
                visited[u] = true;

                for (int v = 0; v < V; v++) {
                    if (!visited[v] && adjMatrix[u][v] != 0) {
                        int weight = adjMatrix[u][v];
                        if (dist[u] + weight < dist[v]) {
                            dist[v] = dist[u] + weight;
                            pred[v] = u;
                            pq.add(v);
                        }
                    }
                }
            }
            return new Result(dist, pred);
        }

        public void printResult(Result result, String startNode) {
            for (int i = 0; i < result.dist.length; i++) {
                if (result.dist[i] == Integer.MAX_VALUE) {
                    System.out.println("Nodo " + nodes.get(i) + ": Inalcanzable");
                    continue;
                }
                StringBuilder path = new StringBuilder();
                printPath(result.pred, i, path, result.dist);
                System.out.println("Nodo " + nodes.get(i) + ": " + result.dist[i] + " (" + path + ")");
            }
        }

        private void printPath(int[] pred, int i, StringBuilder path, int[] dist) {
            if (i == -1) return;
            printPath(pred, pred[i], path, dist);
            if (path.length() > 0) {
                path.append(" -> ");
            }
            path.append(nodes.get(i)).append("(").append(dist[i]).append(")");
        }

        static class Result {
            int[] dist;
            int[] pred;

            Result(int[] dist, int[] pred) {
                this.dist = dist;
                this.pred = pred;
            }
        }
    }

    public static void main(String[] args) {
        // Creación del grafo
        grafo graph = new grafo(26); // Número máximo de nodos en el grafo

        graph.addEdge("A", "B", 15);
        graph.addEdge("A", "H", 5);
        graph.addEdge("B", "I", 10);
        graph.addEdge("B", "K", 20);
        graph.addEdge("C", "D", 35);
        graph.addEdge("C", "L", 8);
        graph.addEdge("D", "E", 30);
        graph.addEdge("D", "I", 50);
        graph.addEdge("E", "F", 25);
        graph.addEdge("E", "J", 35);
        graph.addEdge("F", "K", 200);
        graph.addEdge("G", "I", 100);
        graph.addEdge("G", "J", 1);
        graph.addEdge("H", "L", 9999);
        graph.addEdge("I", "L", 5);

        // Obtener el tiempo de inicio
	    long inicio = System.nanoTime();
        grafo.Result result = graph.dijkstra("H");
        System.out.println("Distancias desde el nodo H:");
        graph.printResult(result, "H");
        
     // Obtener el tiempo de finalizacion
	    long fin = System.nanoTime();
	      
	    // Calcular la duracion de la ejecucion
	    long t = (fin - inicio) / 1_000_000; 
	    // Convertir de nanosegundos a milisegundos
	      
	    System.out.println("Tiempo de ejecución: " + t + " milisegundos");
    }
}
