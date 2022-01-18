/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.pesados;

import grafos.nopesados.ExcepcionAristaNoExiste;
import grafos.nopesados.ExcepcionAristaYaExiste;
import grafos.nopesados.ExcepcionNroVerticesInvalido;

/**
 *
 * @author marce
 */
public class Test {
    public static void main(String[] args) throws ExcepcionNroVerticesInvalido, ExcepcionAristaYaExiste, ExcepcionAristaNoExiste {
        DigrafoPesado digrafo = new DigrafoPesado(4);
        digrafo.insertarArista(0, 1, 50);
        digrafo.insertarArista(0, 2, 30);
        digrafo.insertarArista(1, 3, 10);
        digrafo.insertarArista(2, 1, 1);
        System.out.println(digrafo);
        System.out.println("Ejercicio 13 Algoritmo FLOYD WARSHALL que muestre costos y caminos de un vertice a todos los demas");
       FW ejecutar = new FW(digrafo);
        System.out.println("Ejercicio 15 ");
        System.out.println(ejecutar.mostrarCostosYCaminos(2));
       Dijkstra dijkstra = new Dijkstra(digrafo);
      //  System.out.println(dijkstra.getCostoMinimo(0, 1));
      //  dijkstra.imprimirCamino();
       dijkstra.caminosYCostosDesdeUnVertice(0);
       
       GrafoPesado grafo = new GrafoPesado(6);
        grafo.insertarArista(0, 1, 3);
        grafo.insertarArista(0, 2, 2);
        grafo.insertarArista(1, 3, 5);
        grafo.insertarArista(2, 3, 1);
        grafo.insertarArista(3, 4, 8);
        grafo.insertarArista(4, 5, 9);
        
        System.out.println("Kruskal");
       Kruskal kruskal = new Kruskal(grafo);
       System.out.println(kruskal.ProcesarKruskal());
    }
}
