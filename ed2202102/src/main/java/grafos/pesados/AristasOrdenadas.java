/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.pesados;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
class AristasOrdenadas {

    private GrafoPesado grafo;

    public AristasOrdenadas(GrafoPesado grafo) {
        this.grafo = grafo;
    }
    public LinkedList<Arista> aristasDelGrafo(){
        LinkedList<Arista> aristas = new LinkedList();
        for(int i=0; i<grafo.cantidadDeVertices();i++){
            List<AdyacentesConPeso> listaDeAdyacentesDeVertice = grafo.listaDeAdyacencia.get(i);
            for(int j=0; j<listaDeAdyacentesDeVertice.size(); j++){
                Arista arista = new Arista(i,listaDeAdyacentesDeVertice.get(j).getIndiceVertice(),listaDeAdyacentesDeVertice.get(j).getPeso());
                aristas.add(arista);
            }
        }
        EliminarRepetidas(aristas);
        aristas.sort(Comparator.comparing(arista -> arista.peso));
        return aristas;
    }
    
    
    public void EliminarRepetidas(LinkedList<Arista> aristasDelGrafo){
        for(int i =0; i<aristasDelGrafo.size();i++){
            int pos = posicionDelRepetido(aristasDelGrafo.get(i),aristasDelGrafo);
            aristasDelGrafo.remove(pos);
        }
    }

    private int posicionDelRepetido(Arista arista, LinkedList<Arista> aristasDelGrafo) {
        int posicion= -1;
        int verticeOrigen = arista.verticeOrigen;
        int verticeDestino = arista.verticeDestino;
        for(int i =0; i<aristasDelGrafo.size();i++){
            Arista aristaEnTurno = aristasDelGrafo.get(i);
            if((aristaEnTurno.verticeDestino == arista.verticeOrigen) && (aristaEnTurno.verticeOrigen == arista.verticeDestino)){
                posicion = i;
            }
        }
        return posicion;
    }
    
}
