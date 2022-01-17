/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.pesados;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author marce
 */
public class DigrafoPesado extends GrafoPesado {

   public DigrafoPesado() {
       super();
   }

   public DigrafoPesado(int nroInicialDeVertices) {
       super(nroInicialDeVertices);
   }

    @Override
    public int cantidadDeAristas () {
        int cantidad = 0;
        for(int i = 0; i < this.listaDeAdyacencia.size(); i++) {
            List<AdyacentesConPeso> adyacencias = listaDeAdyacencia.get(i);
            cantidad += adyacencias.size();
        }
        return cantidad;
    }

    @Override
    public void eliminarArista (int posVerticeOrigen, int posVerticeDestino) {
        if(!this.existeAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new IllegalArgumentException("La arista ya existe");
        }
        List<AdyacentesConPeso> adyacenteDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        AdyacentesConPeso adyacenciaAlOrigen = new AdyacentesConPeso(posVerticeDestino, 0);
        int posicionDelDestino = adyacenteDelOrigen.indexOf(adyacenciaAlOrigen);
        adyacenteDelOrigen.remove(posicionDelDestino);
    }

    @Override
    public void insertarArista (int posVerticeOrigen, int posVerticeDestino, double peso) {
        if(this.existeAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new RuntimeException("La lista ya existe");
        }
        List<AdyacentesConPeso> adyacenciaDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        AdyacentesConPeso adyacenciaAlOrigen = new AdyacentesConPeso(posVerticeDestino, peso);
        adyacenciaDelOrigen.add(adyacenciaAlOrigen);
        Collections.sort(adyacenciaDelOrigen);
    }

    @Override
    public int gradoDelVertice (int posDeVertice) {
        throw new UnsupportedOperationException("Método no soportado grafos dirigidos");
    }

    public int gradoDeEntrdaDeVertice (int posDeVertice) {
        super.validarVertice(posDeVertice);
        int entradaDeVertice = 0;
        for(List<AdyacentesConPeso> adyacentesDeVertice : super.listaDeAdyacencia) {
            for(AdyacentesConPeso posDeAdyacente : adyacentesDeVertice) {
                if(posDeAdyacente.getIndiceVertice() == posDeVertice) {
                    entradaDeVertice++;
                }
            }
        }
        return entradaDeVertice;
    }

    public int gradoDeSalidaDeVertice (int posDeVertice) {
        return super.gradoDelVertice(posDeVertice);
    }
    
}
