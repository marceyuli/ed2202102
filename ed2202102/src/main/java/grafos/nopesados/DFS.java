/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.nopesados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class DFS {
    private UtilsRecorridos controlMarcados;
    private Grafo grafo;
    private List<Integer> recorrido;

    public UtilsRecorridos getControlMarcados() {
        return controlMarcados;
    }

    public DFS(Grafo unGrafo, int posVerticePartida){
        this.grafo =unGrafo;
        grafo.validarVertice(posVerticePartida);
        recorrido = new ArrayList<>();
        controlMarcados = new UtilsRecorridos(this.grafo.cantidadDeVertices()); //ya esta todo desmarcado
        procesarDFS(posVerticePartida);
    }

    public void procesarDFS(int posVertice) {
        controlMarcados.marcarVertice(posVertice);
        recorrido.add(posVertice);
        Iterable<Integer> adyacentesDeVerticeEnTurno = grafo.adyacenciasDeVertice(posVertice);
        for(Integer posVerticeAdyacente : adyacentesDeVerticeEnTurno){
            if(!controlMarcados.estaVerticeMarcado(posVerticeAdyacente)){
                procesarDFS(posVerticeAdyacente);
            }
        }
        
    }
    public boolean hayCaminoAVertice(int posVertice){
        grafo.validarVertice(posVertice);
        return controlMarcados.estaVerticeMarcado(posVertice);
    }
    public Iterable<Integer> obtenerRecorrido(){
        return this.recorrido;
    }
    public boolean hayCaminoATodos(){
        return controlMarcados.estanTodosMarcados();
    }
}
