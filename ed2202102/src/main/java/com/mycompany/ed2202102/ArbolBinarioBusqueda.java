package com.mycompany.ed2202102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArbolBinarioBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K,V>{
    protected NodoBinario<K,V> raiz;
    
    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException{
        if(claveAInsertar==null){
            throw new NullPointerException("No se permiten insertar claves vacias");
        }
        if(valorAInsertar==null){
            throw new NullPointerException("No se permiten insertar claves vacias");
        }
        if(this.esArbolVacio()){
            this.raiz = new NodoBinario<>(claveAInsertar,valorAInsertar);
            return;
        }
        NodoBinario<K,V> nodoAnterior = NodoBinario.nodoVacio();
        NodoBinario<K,V> nodoActual = this.raiz;
        while(!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            nodoAnterior = nodoActual;
            if(claveAInsertar.compareTo(claveActual)<0){
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveAInsertar.compareTo(claveActual)>0){
                nodoActual = nodoActual.getHijoDerecho();
            }
            else{
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        K claveAnterior = nodoAnterior.getClave();
        NodoBinario<K,V> nuevoNodo = new NodoBinario<>(claveAInsertar,valorAInsertar);
        if(claveAInsertar.compareTo(claveAnterior)<0){
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        }else{
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }

    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoExiste {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V buscar(K claveABuscar) {
        if(claveABuscar == null){
            return null;
        }
        NodoBinario<K,V> nodoActual = this.raiz;
        while(!NodoBinario.esNodoVacio(nodoActual)){
            K claveActual = nodoActual.getClave();
            if(claveABuscar.compareTo(claveActual)<0){
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveABuscar.compareTo(claveActual)>0){
                nodoActual = nodoActual.getHijoDerecho();
            }
            else{
                return nodoActual.getValor();
            }
        }
        return null;
    }

    @Override
    public boolean contiene(K claveABuscar) {
        return this.buscar(claveABuscar) != null;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vaciar() {
        this.raiz = NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if(!this.esArbolVacio()){
            Queue<NodoBinario<K,V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            while(!colaDeNodos.isEmpty()){
                NodoBinario<K,V> nodoActual = colaDeNodos.poll();
                recorrido.add(nodoActual.getClave());
                if(!nodoActual.esVacioHijoIzquierdo()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if(!nodoActual.esVacioHijoDerecho()){
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoEnInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
