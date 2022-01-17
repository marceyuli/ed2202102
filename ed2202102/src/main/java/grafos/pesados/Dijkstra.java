package grafos.pesados;

import grafos.nopesados.UtilsRecorridos;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dijkstra {

    double INFINITO = Double.MAX_VALUE;
    DigrafoPesado digrafo;
    List<Double> listaDeCostos;
    UtilsRecorridos marcados;
    List<Integer> predecesores;
    Stack<Integer> pilaDeCaminos;
    double costoMinimo;

    public Dijkstra(DigrafoPesado unDigrafo) {
        this.digrafo = unDigrafo;
        listaDeCostos = new LinkedList<>();
        marcados = new UtilsRecorridos(unDigrafo.cantidadDeVertices());
        predecesores = new LinkedList<>();
        pilaDeCaminos = new Stack<>();
        costoMinimo = INFINITO;
        for (int i = 0; i < digrafo.cantidadDeVertices(); i++) {
            listaDeCostos.add(INFINITO);
            predecesores.add(-1);
        }
    }

    public double menorNoMarcado(List<Double> listaDeCostos, UtilsRecorridos marcados) {
        double menor = Double.MAX_VALUE;
        int i = 0;
        while (i < listaDeCostos.size()) {
            if (listaDeCostos.get(i) < menor && !marcados.estaVerticeMarcado(i)) {
                menor = listaDeCostos.get(i);
            }
            i++;
        }
        return menor;
    }

    public void caminoMinimo(int verticeI, int verticeF) {
        listaDeCostos.set(verticeI, 0.0);
        int verticeActual = verticeI;
        while (verticeActual != verticeF && !marcados.estanTodosMarcados()
                && !marcados.estaVerticeMarcado(verticeF)) {
            double posMenor = menorNoMarcado(listaDeCostos, marcados);
            verticeActual = listaDeCostos.indexOf(posMenor);
            //pilaDeCaminos.add(verticeActual);
            List<Integer> listaDeAdyacentes = (List<Integer>) digrafo.adyancentesDeVertice(verticeActual);
            for (int i = 0; i < listaDeAdyacentes.size(); i++) {
                int posicionActual = listaDeAdyacentes.get(i);
                if (!marcados.estaVerticeMarcado(posicionActual)) {
                    predecesores.set(posicionActual, verticeActual);
                }
                if (listaDeCostos.get(posicionActual) > (listaDeCostos.get(verticeActual) + digrafo.peso(verticeActual, posicionActual))) {
                    double nuevoCosto = listaDeCostos.get(verticeActual) + digrafo.peso(verticeActual, posicionActual);
                    listaDeCostos.set(posicionActual, nuevoCosto);
                }
            }
            marcados.marcarVertice(verticeActual);
        }
        costoMinimo = listaDeCostos.get(verticeF);
        marcados.desmarcarTodos(); 
        pilaDeCaminos.push(verticeF);
        while(predecesores.get(verticeF)!=-1 && verticeF!= verticeI){
             pilaDeCaminos.push(predecesores.get(verticeF));
             verticeF= predecesores.get(verticeF);
        }
        /*
        pilaDeCaminos.push(verticeF);
        int verticeTurno = verticeF;
        while( verticeTurno != verticeI){
            if(predecesores.get(verticeTurno)!= -1){
            pilaDeCaminos.push(predecesores.get(verticeTurno));
            verticeTurno = predecesores.get(verticeTurno);
        }
    }*/
    
    }
    public Stack<Integer> getPilaDeCaminos() {
        return pilaDeCaminos;
    }

    public List<Integer> getPredecesores() {
        return predecesores;
    }

    public double getCostoMinimo(int verticeI, int verticeF) {
        //caminoMinimo(verticeI, verticeF);
        //System.out.println(pilaDeCaminos);
        return costoMinimo;

    }
    public String camino(){
        String s = "";
        Stack<Integer> pila = getPilaDeCaminos();
        while(!pila.isEmpty()){
            s= s + pila.pop() + "\n";
        }
        return s;
    }
    /*
   15. Para un grafo dirigido pesado implementar el algoritmo de Dijkstra que muestre con que 
vértices hay caminos de costo mínimo partiendo desde un vértice v, con qué costo y cuáles 
son los caminos*/
    public void caminosYCostosDesdeUnVertice(int verticeInicial) {

        for (int unDestino = 0; unDestino < digrafo.cantidadDeVertices(); unDestino++) {
            String s = "De " + verticeInicial + " a ";
            if(unDestino!=verticeInicial){
                caminoMinimo(verticeInicial, unDestino);
                if (listaDeCostos.get(unDestino) != INFINITO) {
                    s = s + unDestino + " cuesta " + getCostoMinimo(verticeInicial, unDestino) + " y el camino es [" + "\n" ;
                    s = s + camino();
                    System.out.println("imprimio ya");
                }
                  s = s + "]";
                System.out.println(s + "\n");
            }
              
                
            
        }
    }
}
