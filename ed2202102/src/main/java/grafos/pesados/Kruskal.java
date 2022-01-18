
package grafos.pesados;

import grafos.nopesados.ExcepcionAristaNoExiste;
import grafos.nopesados.ExcepcionAristaYaExiste;
import grafos.nopesados.ExcepcionNroVerticesInvalido;
import java.util.LinkedList;


public class Kruskal {
     private GrafoPesado grafo;

    public Kruskal(GrafoPesado grafo) {
        this.grafo = grafo;
    }
    
     public GrafoPesado ProcesarKruskal() throws ExcepcionNroVerticesInvalido, ExcepcionAristaYaExiste, ExcepcionAristaNoExiste
    {
        GrafoPesado aux = new GrafoPesado(grafo.cantidadDeVertices());
        AristasOrdenadas ejecutar = new AristasOrdenadas(grafo);
        LinkedList<Arista> a = ejecutar.aristasDelGrafo();
        for(int i=0; i< a.size(); i++){
            aux.insertarArista(a.get(i).verticeOrigen, a.get(i).verticeDestino, a.get(i).peso);
            
            if(aux.hayCiclo()){
                System.out.println("hay ciclo al insertar" + a.get(i).verticeOrigen +a.get(i).verticeDestino);
                aux.eliminarArista(a.get(i).verticeOrigen, a.get(i).verticeDestino);
            }
            aux.controlMarcados.desmarcarTodos();
            
        }
        return aux;
    }
}
