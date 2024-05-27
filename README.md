# **Paralelizacion en GPU de algoritmos de busqueda de caminos optimos**
Este trabajo explora la viabilidad de la paralelización para la búsqueda de caminos óptimos en grafos, utilizando como caso de estudio el algoritmo de Dijkstra. El objetivo principal es evaluar la eficiencia de una implementación paralela en Java comparandola con su versión secuencial original
Este trabajo explora la viabilidad de la paralelización para la búsqueda de caminos óptimos en grafos, utilizando como caso de estudio el algoritmo de Dijkstra. El objetivo principal es evaluar la eficiencia de una implementación paralela en Java comparandola con su versión secuencial original, centrándose en el análisis del tiempo de ejecución y la precisión de los resultados.

La recurrencia, inherente a la naturaleza de los grafos, presenta un desafío computacional significativo al tratar con problemas de gran escala. La paralelización en GPU emerge como una alternativa prometedora para abordar este reto, aprovechando la arquitectura altamente paralela de las GPU para acelerar el proceso de búsqueda de caminos. Si bien en este trabajo se centrará tanto en la parte teórica como la implementación de lo visto, la amplitud y complejidad del tema han hecho necesario enfocarse en el algoritmo de Dijkstra, dejando otros aspectos para futuras investigaciones.

Los resultados obtenidos revelaron que la implementación paralela en Java ofrece mejoras significativas en el tiempo de ejecución al hablar de grafos grafos completos o con un número elevado de nodos. En el caso de grafos con menor densidad o complejidad, la implementación paralela no mostró una ventaja significativa sobre la versión secuencial. No obstante, los resultados generales confirman el potencial de la paralelización para optimizar la búsqueda de caminos óptimos en grafos.

En esencia, la paralelización en grafos consiste en dividir el grafo original en subgrafos más pequeños y manejables. Esto permite distribuir la carga computacional entre múltiples procesadores, lo que puede traducirse en una reducción significativa del tiempo de ejecución, especialmente para problemas de gran escala.

Palabras clave: Paralelismo, Dijkstra, Búsqueda de caminos más cortos, Grafo, Java, GPU. 
