
package grafos.pesados;

import grafos.nopesados.ExcepcionAristaYaExiste;
import grafos.nopesados.ExcepcionNroVerticesInvalido;
import grafos.nopesados.UtilsRecorridos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrafoPesado {
    protected List<List<AdyacentesConPeso>> listaDeAdyacencia;
    private UtilsRecorridos controlMarcados;
    public GrafoPesado () {
        this.listaDeAdyacencia = new ArrayList<>();
        controlMarcados = new UtilsRecorridos(this.cantidadDeVertices());
    }

    public GrafoPesado (int nroInicialDeVertices) {
        if(nroInicialDeVertices <= 0) {
            throw new RuntimeException("Nro de vertices no valido");
        }
        this.listaDeAdyacencia = new ArrayList<>();
        for(int i = 0; i < nroInicialDeVertices; i++) {
            this.insertarVertice();
        }
    }


    public void insertarVertice() {
        List<AdyacentesConPeso> adyacentesDeNuevoVertice = new ArrayList<>();
        this.listaDeAdyacencia.add(adyacentesDeNuevoVertice);
    }

    public int cantidadDeVertices() {
        return listaDeAdyacencia.size();
    }

    public int gradoDelVertice(int posDeVertice) {
        validarVertice(posDeVertice);
        List<AdyacentesConPeso> adyacenteDelVertice = this.listaDeAdyacencia.get(posDeVertice);
        return adyacenteDelVertice.size();

    }

    public void validarVertice(int posicionDeVertice) {
        if (posicionDeVertice < 0 || posicionDeVertice >= this.cantidadDeVertices()) {
            throw new IllegalArgumentException("No existe vértice en la " + "posición " + posicionDeVertice + "en este grafo");
        }
    }

    public void insertarArista(int posVerticeOrigen, int posVerticeDestino, double peso) {
        if(this.existeAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new RuntimeException("La lista ya existe");
        }
        List<AdyacentesConPeso> adyacenciaDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        AdyacentesConPeso adyacenciaAlOrigen = new AdyacentesConPeso(posVerticeDestino, peso);
        adyacenciaDelOrigen.add(adyacenciaAlOrigen);
        Collections.sort(adyacenciaDelOrigen);
        if(posVerticeOrigen != posVerticeDestino) {
            List<AdyacentesConPeso> adyacenciaDelDestino = this.listaDeAdyacencia.get(posVerticeDestino);
            AdyacentesConPeso adyacenciaAlDestino = new AdyacentesConPeso(posVerticeOrigen, peso);
            adyacenciaDelDestino.add(adyacenciaAlDestino);
            Collections.sort(adyacenciaDelDestino);
        }
    }

    public boolean existeAdyacencia(int posVerticeOrigen, int posVerticeDestino) {
        validarVertice(posVerticeOrigen);
        validarVertice(posVerticeDestino);
        List<AdyacentesConPeso> adyacenciaDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        AdyacentesConPeso adyacenciaAlOrigen = new AdyacentesConPeso(posVerticeDestino);
        return adyacenciaDelOrigen.contains(adyacenciaAlOrigen);
    }

    public Iterable<Integer> adyancentesDeVertice(int posDeVertice) {
        validarVertice(posDeVertice);
        List<AdyacentesConPeso> adyaventeDelVertice = this.listaDeAdyacencia.get(posDeVertice);
        List<Integer> soloVertices = new ArrayList<>();
        for(AdyacentesConPeso adyacenteConPeso : adyaventeDelVertice) {
            soloVertices.add(adyacenteConPeso.getIndiceVertice());
        }
        Iterable<Integer> iterableDeAdyacentes = soloVertices;
        return iterableDeAdyacentes;
    }
    public Iterable<AdyacentesConPeso> adyacentesDeVertice(int posVertice){
        validarVertice(posVertice);
        List<AdyacentesConPeso> adyaventeDelVertice = this.listaDeAdyacencia.get(posVertice);
        Iterable<AdyacentesConPeso> iterableDeAdyacentes = adyaventeDelVertice;
        return iterableDeAdyacentes;
    }
    public int cantidadDeAristas() {
        int cantAristas = 0;
        int cantLazos = 0;
        for (int i = 0; i < this.listaDeAdyacencia.size(); i++) {
            List<AdyacentesConPeso> adyacentesDeUnVertice = this.listaDeAdyacencia.get(i);
            for(AdyacentesConPeso posDeAdyacente : adyacentesDeUnVertice) {
                if(i == posDeAdyacente.getIndiceVertice()) {
                    cantLazos++;
                } else {
                    cantAristas++;
                }
            }
        }
        return cantLazos + (cantAristas / 2);
    }


    public void eliminarArista(int posVerticeOrigen, int posVerticeDestino) {
        if(!this.existeAdyacencia(posVerticeOrigen, posVerticeDestino)) {
            throw new IllegalArgumentException("La arista ya existe");
        }
        List<AdyacentesConPeso> adyacenteDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        AdyacentesConPeso adyacenciaAlOrigen = new AdyacentesConPeso(posVerticeDestino, 0);
        int posicionDelDestino = adyacenteDelOrigen.indexOf(adyacenciaAlOrigen);
        adyacenteDelOrigen.remove(posicionDelDestino);
        if(posVerticeOrigen != posVerticeDestino) {
            List<AdyacentesConPeso> adyacentesDelDestino = this.listaDeAdyacencia.get(posicionDelDestino);
            AdyacentesConPeso adyacenciaAlDestino = new AdyacentesConPeso(posVerticeOrigen, 0);
            int posicionDelOrigen = adyacentesDelDestino.indexOf(posVerticeOrigen);
            adyacentesDelDestino.remove(posicionDelOrigen);
        }
    }
    //Modificar el eliminar

    public void eliminarVertice(int posDeVertice) {
        validarVertice(posDeVertice);
        listaDeAdyacencia.remove(posDeVertice);
        for (int i = 0; i < listaDeAdyacencia.size(); i++) {
            List<AdyacentesConPeso> adyacencias = listaDeAdyacencia.get(i);
            for(int j = 0; j < adyacencias.size(); j++) {
                AdyacentesConPeso pos = adyacencias.get(posDeVertice);
                if(pos.getIndiceVertice() >= 0) {
                    adyacencias.remove(pos);
                } else if (pos.getIndiceVertice() > posDeVertice) {
                    AdyacentesConPeso p = adyacencias.get(j);
                    p.setIndiceVertice(p.getIndiceVertice() - 1);
                    adyacencias.set(j, p);
                }
            }
        }
    }


    public double peso (int posVerticeOrigen, int posVerticeDestino) {
        validarVertice(posVerticeOrigen);
        validarVertice(posVerticeDestino);
        if(!this.existeAdyacencia(posVerticeOrigen,posVerticeDestino)) {
            throw new RuntimeException("La arista ya existe");
        }
        List<AdyacentesConPeso> adyacenteDelOrigen = this.listaDeAdyacencia.get(posVerticeOrigen);
        AdyacentesConPeso adyacenciaAlOrigen = new AdyacentesConPeso(posVerticeDestino);
        int posicionDeLaAdyacencia = adyacenteDelOrigen.indexOf(adyacenciaAlOrigen);
        return adyacenteDelOrigen.get(posicionDeLaAdyacencia).getPeso();
    }
    public boolean hayCiclo() throws ExcepcionNroVerticesInvalido, ExcepcionAristaYaExiste  {
       GrafoPesado grafoAux = new GrafoPesado(this.cantidadDeVertices());
        for(int i = 0; i < listaDeAdyacencia.size(); i++) {
            if(hayCiclo(grafoAux, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean hayCiclo(GrafoPesado grafoAux, int posVertice) throws ExcepcionAristaYaExiste {
        
        controlMarcados.marcarVertice(posVertice);
        List<AdyacentesConPeso> adyacentesDeVertice = listaDeAdyacencia.get(posVertice);
        for (AdyacentesConPeso adyacentes : adyacentesDeVertice) {
            if(!controlMarcados.estaVerticeMarcado(adyacentes.getIndiceVertice())) {
                if(!grafoAux.existeAdyacencia(posVertice, adyacentes.getIndiceVertice()) && posVertice != adyacentes.getIndiceVertice()) {
                    grafoAux.insertarArista(posVertice, adyacentes.getIndiceVertice(),1);
                    hayCiclo(grafoAux, adyacentes.getIndiceVertice());
                }
            } else {
                if(!grafoAux.existeAdyacencia(posVertice, adyacentes.getIndiceVertice()) && posVertice != adyacentes.getIndiceVertice()) {
                    grafoAux.insertarArista(posVertice, adyacentes.getIndiceVertice(),1);
                    return true;
                }
            }
        }

        return false;
    }
    @Override
    public String toString() {
        String grafo = "";
        for ( int i = 0; i < listaDeAdyacencia.size(); i++ ) {
            List<AdyacentesConPeso> adyacentes = listaDeAdyacencia.get(i);
            grafo = grafo + i + " : " + "[";
            for ( int j = 0; j < adyacentes.size(); j++ ) {
                AdyacentesConPeso componente = adyacentes.get(j);
                if (j == adyacentes.size() - 1) {
                    grafo = grafo + "[" + componente.getIndiceVertice() + "|" + (int)componente.getPeso() + "]";
                } else {
                    grafo = grafo + "[" + componente.getIndiceVertice() + "|" + (int)componente.getPeso() + "]" + "-->";
                }

            }
            grafo = grafo + "]" + "\n";
        }
        return grafo;
    }
}
