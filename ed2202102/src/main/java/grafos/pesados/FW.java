/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.pesados;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class FW {

    private DigrafoPesado digrafo;
    int INF = 99999;

    public FW(DigrafoPesado digrafo) {
        this.digrafo = digrafo;
    }

    int[][] floydWarshall() {
        int tamaño = digrafo.cantidadDeVertices();
        int dist[][] = minimasDistancias();
        int i, j, k;
        for (k = 0; k < tamaño; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < tamaño; i++) {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < tamaño; j++) {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    public int[][] minimasDistancias() {
        int tamaño = this.digrafo.cantidadDeVertices();
        int[][] matriz = new int[tamaño][tamaño];
        //inicializa con ceros e infinitos
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (i == j) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < tamaño; i++) {
            List<AdyacentesConPeso> adyacentesDeUnVertice = digrafo.listaDeAdyacencia.get(i);
            for (AdyacentesConPeso posDeAdyacente : adyacentesDeUnVertice) {
                matriz[i][posDeAdyacente.getIndiceVertice()] = (int) posDeAdyacente.getPeso();
            }
        }
        return matriz;
    }

    public void showMatriz(int[][] matriz) {
        int tamaño = digrafo.cantidadDeVertices();
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    String mostrarCostosYCaminos(int UnVertice) {
        LinkedList<List> listaDeCaminosDeUnVerticeATodos = new LinkedList<>();
        for (int i = 0; i < digrafo.cantidadDeVertices(); i++) {
            List<Integer> CaminoDeUnVerticeAOtro = new LinkedList<>();
            CaminoDeUnVerticeAOtro.add(UnVertice);
            listaDeCaminosDeUnVerticeATodos.add(CaminoDeUnVerticeAOtro);
        }
        int tamaño = digrafo.cantidadDeVertices();
        int dist[][] = minimasDistancias();
        int i, j, k;
        //intermedio
        for (k = 0; k < tamaño; k++) {
            // fuentes
            for (i = 0; i < tamaño; i++) {
                // destino
                for (j = 0; j < tamaño; j++){ 
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        if(i==UnVertice){
                            listaDeCaminosDeUnVerticeATodos.get(j).add(k);
                        }
                    }
                }
            }
        }
        for (int m = 0; m < digrafo.cantidadDeVertices(); m++) {
            listaDeCaminosDeUnVerticeATodos.get(m).add(m);
        }
        String costosYCaminos = "" ;
        for (int l = 0; l < listaDeCaminosDeUnVerticeATodos.size(); l++) {
            if(dist[UnVertice][l]== 99999){
                costosYCaminos =  costosYCaminos + UnVertice+ " a " + l + " no se puede llegar " + "\n";
            }
            else if(dist[UnVertice][l]== 0){
                costosYCaminos =  costosYCaminos +UnVertice+ " a " + l + " no cuesta nada, porque es el mismo vertice" + "\n";
            }
            else{
                costosYCaminos =  costosYCaminos +UnVertice+ " a " + l + " cuesta " + dist[UnVertice][l] + " y el camino es "
                               + listaDeCaminosDeUnVerticeATodos.get(l) + "\n";
            }
            
        }
        return costosYCaminos;
    }
}
