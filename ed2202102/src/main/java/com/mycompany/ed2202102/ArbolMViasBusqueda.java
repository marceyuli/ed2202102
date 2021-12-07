/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed2202102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author marce
 */
public class ArbolMViasBusqueda<K extends Comparable<K>, V>
        implements IArbolBusqueda<K, V> {

    protected NodoMVias<K, V> raiz;
    protected int orden;
    protected static final int POSICION_INVALIDA = -1;
    protected static final int ORDEN_MINIMO = 3;

    public ArbolMViasBusqueda() {
        this.orden = ORDEN_MINIMO;
    }

    public ArbolMViasBusqueda(int orden) throws ExcepcionOrdenNoValido {
        if (orden < ArbolMViasBusqueda.ORDEN_MINIMO) {
            throw new ExcepcionOrdenNoValido();
        }
        this.orden = orden;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) {
        if(valorAInsertar == NodoMVias.datoVacio()){
            throw new NullPointerException("No se permite insertar valores nulos");
        }
        if(claveAInsertar == NodoMVias.datoVacio()){
            throw new NullPointerException("No se permite insertar claves nulas");
        }
        if(this.esArbolVacio()){
            this.raiz = new NodoMVias<>(this.orden,claveAInsertar, valorAInsertar);
            return;
        }
        NodoMVias<K,V> nodoActual = this.raiz;
        while(!NodoMVias.esNodoVacio(nodoActual)){
            int posicionDeClaveAInsertar = this.getPosicionDeClave(nodoActual, claveAInsertar);
            if(posicionDeClave != POSICION_INVALIDA){ //SI LA CLAVE ESTA EN EL NODO
                nodoActual.setValor(posicionDeClave, valorAInsertar);
                nodoActual = NodoMVias.nodoVacio();
            }else{
                if(nodoActual.esHoja()){
                    if(nodoActual.estanClavesLlenas()){
                        int posicionPorDondeBajar = this.obtenerPosicionPorDondeBajar(nodoActual, claveAInsertar);
                        NodoMVias<K,V> nuevoHijo = new NodoMVias<>(this.orden,claveAInsertar,valorAInsertar);
                        nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                    }else{
                        this.insertarClaveYValorOrdenadaEnNodo(nodoActual,claveAInsertar,valorAInsertar);
                    }
                    nodoActual= NodoMVias.nodoVacio();
                }else{
                    int posicionPorDondeBajar = this.obtenerPosicionPorDondeBajar(nodoActual, claveAInsertar);
                    if(nodoActual.esHijoVacio(posicionPorDondeBajar)){
                        NodoMVias<K,V> nuevoHijo = new NodoMVias<>(this.orden,claveAInsertar,valorAInsertar);
                        nodoActual.setHijo(posicionPorDondeBajar, nuevoHijo);
                    }else{
                        nodoActual = nodoActual.getHijo(posicionPorDondeBajar);
                    }
                    
                }
            }
        }
    
    }

    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoExiste {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar == NodoMVias.datoVacio()) {
            return (V) NodoMVias.datoVacio();
        }
        NodoMVias<K, V> nodoActual = this.raiz;
        while (!NodoMVias.esNodoVacio(nodoActual)) {
            boolean huboCambioDeNodo = false;
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias()
                    && !huboCambioDeNodo; i++) {
                K claveActual = nodoActual.getClave(i);
                if (claveABuscar.compareTo(claveActual) == 0) {
                    return nodoActual.getValor(i);
                }
                if (claveABuscar.compareTo(claveActual) < 0) {
                    nodoActual = nodoActual.getHijo(i);
                    huboCambioDeNodo = true;
                }
            }
            if (!huboCambioDeNodo) {
                nodoActual = nodoActual.getHijo(this.orden - 1);
            }
        }

        return (V) NodoMVias.datoVacio();

    }

    @Override
    public boolean contiene(K claveABuscar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean esArbolVacio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if(this.esArbolVacio()){
            return recorrido;
        }
        
        Queue<NodoMVias<K,V>> colaDeNodos =new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        
        while (!colaDeNodos.isEmpty()) {
            NodoMVias<K, V> nodoActual = colaDeNodos.poll();
            for (int i = 0; i < nodoActual.cantidadDeClavesNoVacias(); i++) {
                recorrido.add(nodoActual.getClave(i));
                if (!nodoActual.esHijoVacio(i)) {
                    colaDeNodos.offer(nodoActual.getHijo(i));
                }
            }
            if(!nodoActual.esHijoVacio(nodoActual.cantidadDeClavesNoVacias())){
                colaDeNodos.offer(nodoActual.getHijo(nodoActual.cantidadDeClavesNoVacias()));
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