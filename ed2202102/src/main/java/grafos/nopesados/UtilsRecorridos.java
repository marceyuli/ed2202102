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
public class UtilsRecorridos {
    private List<Boolean> marcados;
    public UtilsRecorridos(int numVertices){
        marcados = new ArrayList<>();
        for(int i=0; i< numVertices; i++){
            marcados.add(Boolean.FALSE);
        }
    }
    public void marcarVertice(int posVertice){
        //pre: La posicion es valida
        marcados.set(posVertice, Boolean.TRUE);
    }
    public void desmarcarVertice(int posVertice){
        //pre: La posicion es valida
        marcados.set(posVertice, Boolean.FALSE);
    }
    public boolean estaVerticeMarcado(int posVertice){
        return marcados.get(posVertice);
    }
    public void desmarcarTodos(){
        for(int i=0; i<marcados.size(); i++){
            marcados.set(i, Boolean.FALSE);
        }
    }
    public boolean estanTodosMarcados(){
        for(Boolean marcado: marcados){
            if(!marcado){
                return false;
            }
        }
        return true;
    }
}
