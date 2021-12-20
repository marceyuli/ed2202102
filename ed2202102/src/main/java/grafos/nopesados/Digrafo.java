
package grafos.nopesados;

import java.util.Collections;
import java.util.List;

public class Digrafo  extends Grafo{
    public Digrafo(){
        super(); //que llame al constructor del padre
    }
    public Digrafo(int nroInicialDeVertices)throws ExcepcionNroVerticesInvalido{
        super(nroInicialDeVertices);
    }

    @Override
    public void eliminarArista(int posVerticeOrigen, int posVerticeDestino) throws ExcepcionAristaNoExiste {
    if(!existeAdyacencia(posVerticeOrigen,posVerticeDestino)){
            throw new ExcepcionAristaNoExiste();
        }
        List<Integer> adyacentesDelOrigen = this.listaDeAdyacencias.get(posVerticeOrigen) ;
        int posicionDelDestino = adyacentesDelOrigen.indexOf(posVerticeDestino);
        adyacentesDelOrigen.remove(posicionDelDestino);
    }

    @Override
    public int cantidadDeAristas() {
        int c=0;
        for(int i=0; i<listaDeAdyacencias.size();i++){
            int tamaño = listaDeAdyacencias.get(i).size();
            c= c+tamaño;
        }
        return c;
    }

    @Override
    public void insertarArista(int posVerticeOrigen, int posVerticeDestino) throws ExcepcionAristaYaExiste {
    if(this.existeAdyacencia(posVerticeOrigen, posVerticeDestino)){
            throw new ExcepcionAristaYaExiste();
        }
        List<Integer> adyacentesDelOrigen = this.listaDeAdyacencias.get(posVerticeOrigen);
        adyacentesDelOrigen.add(posVerticeDestino);
        Collections.sort(adyacentesDelOrigen);
    }

    @Override
    public int gradoDeVertice(int posDeVertice) {
        throw new UnsupportedOperationException("Metodo no soportado en grafos dirigidos");
    }
    //hay que implementarlp
    public int gradoDeEntradaDeVertice(int posDeVertice) {
        validarVertice(posDeVertice); 
        int entradasDeVertice =0;
        for(List<Integer> adyacentesDeUnVertice: super.listaDeAdyacencias){
            for(Integer posAdyacente: adyacentesDeUnVertice){
                if(posAdyacente == posDeVertice){
                    entradasDeVertice++;
                }
            }
        }
        return entradasDeVertice;
    }
    public int gradoDeSalidaDeVertice(int posDeVertice) {
        return super.gradoDeVertice(posDeVertice);
    }
    
}
