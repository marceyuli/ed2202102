/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.pesados;

/**
 *
 * @author marce
 */
public class Test {
    public static void main(String[] args) {
        DigrafoPesado digrafo = new DigrafoPesado(4);
        digrafo.insertarArista(0, 1, 50);
        digrafo.insertarArista(0, 2, 30);
        digrafo.insertarArista(1, 3, 10);
        digrafo.insertarArista(2, 1, 1);
        System.out.println(digrafo);
        System.out.println("Ejercicio 13 Algoritmo FLOYD WARSHALL que muestre costos y caminos de un vertice a todos los demas");
       FW ejecutar = new FW(digrafo);
        System.out.println(ejecutar.mostrarCostosYCaminos(2));
       Dijkstra dijkstra = new Dijkstra(digrafo);
        System.out.println(dijkstra.getCostoMinimo(0, 3));
       dijkstra.caminosYCostosDesdeUnVertice(0);
    }
}
