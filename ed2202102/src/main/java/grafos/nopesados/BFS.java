/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.nopesados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author marce
 */
public class BFS {
    private UtilsRecorridos controlMarcados;
    private Grafo grafo;
    private List<Integer> recorrido;
    
    public BFS(Grafo unGrafo, int posVerticePartida){
        this.grafo = unGrafo;
        grafo.validarVertice(posVerticePartida);
        recorrido = new ArrayList<>();
        controlMarcados = new UtilsRecorridos(this.grafo.cantidadDeVertices()); //ya esta todo desmarcado
        ejecutarBFS(posVerticePartida);
    }

    public void ejecutarBFS(int posVertice) {
        Queue<Integer> cola= new LinkedList<>();
        cola.offer(posVertice);
        controlMarcados.marcarVertice(posVertice);
        do{
            int posVerticeEnTurno = cola.poll();
            recorrido.add(posVerticeEnTurno);
            Iterable<Integer> adyacentesDeVerticeEnTurno = grafo.adyacenciasDeVertice(posVerticeEnTurno);
            for(Integer posVerticeAdyacente: adyacentesDeVerticeEnTurno){
                if(!controlMarcados.estaVerticeMarcado(posVerticeAdyacente)){
                    cola.offer(posVerticeAdyacente);
                    controlMarcados.marcarVertice(posVerticeAdyacente);
                }
            }
            
        } while (!cola.isEmpty());
    }
    public boolean hayCaminoAVertice(int posVertice){
        grafo.validarVertice(posVertice);
        return controlMarcados.estaVerticeMarcado(posVertice);
    }
    public Iterable<Integer> obtenerRecorrido(){
        return this.recorrido;
    }
}
