
Tras revisar las herramientas teóricas para paralelizar el algoritmo de búsqueda de caminos más cortos, se ha observado que el algoritmo de Dijkstra, diseñado originalmente para un procesamiento secuencial, ha sido objeto de diversas modificaciones para su paralelización. Entre estas soluciones se encuentran el uso de múltiples hebras para aumentar la velocidad de cálculo y la división del grafo en subgrafos.

Sin embargo, en este trabajo se propone un enfoque alternativo que centra el paralelismo en la creación de tareas concurrentes para relajar las aristas de los nodos vecinos. Esta estrategia permite procesar simultáneamente múltiples aristas, aprovechando los múltiples núcleos de la CPU para acelerar la ejecución.

Para demostrar la utilidad de la paralelización en este contexto, en lugar de aplicar el algoritmo una sola vez buscando un nodo origen y un nodo destino, se planteará una tarea más compleja: la búsqueda de todos los caminos óptimos que parten del nodo origen hacia todos los demás nodos del grafo. De esta manera, se pondrá a prueba la capacidad del algoritmo paralelo para manejar una tarea computacionalmente más exigente.
