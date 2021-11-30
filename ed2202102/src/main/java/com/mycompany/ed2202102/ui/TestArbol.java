/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed2202102.ui;

import com.mycompany.ed2202102.ArbolBinarioBusqueda;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class TestArbol {
    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer,Integer> arbolPrueba = new ArbolBinarioBusqueda<>();
        
        
        arbolPrueba.insertar(15, 1);
        arbolPrueba.insertar(7, 1);
        arbolPrueba.insertar(27, 1);
        arbolPrueba.insertar(5, 1);
        arbolPrueba.insertar(6, 1);
        arbolPrueba.insertar(35, 1);
        arbolPrueba.insertar(34, 1);
        arbolPrueba.insertar(33, 1);
//        
        List<Integer> clavesInOrden = new LinkedList<>();
        List<Integer> valoresInOrden = new LinkedList<>();
        List<Integer> clavesPostOrden = new LinkedList<>();
        List<Integer> valoresPostOrden = new LinkedList<>();
        
        clavesInOrden.add(1);
        clavesInOrden.add(7);
        clavesInOrden.add(9);
        clavesInOrden.add(13);
        clavesInOrden.add(15);
        clavesInOrden.add(28);
        clavesInOrden.add(29);
        
        valoresInOrden.add(1);
        valoresInOrden.add(7);
        valoresInOrden.add(9);
        valoresInOrden.add(13);
        valoresInOrden.add(15);
        valoresInOrden.add(28);
        valoresInOrden.add(29);
        
        clavesPostOrden.add(1);
        clavesPostOrden.add(13);
        clavesPostOrden.add(9);
        clavesPostOrden.add(7);
        clavesPostOrden.add(29);
        clavesPostOrden.add(28);
        clavesPostOrden.add(15);
        
        
        valoresPostOrden.add(1);
        valoresPostOrden.add(13);
        valoresPostOrden.add(9);
        valoresPostOrden.add(7);
        valoresPostOrden.add(29);
        valoresPostOrden.add(28);
        valoresPostOrden.add(15);
        
        ArbolBinarioBusqueda<Integer,Integer> arbolPrueba2 = new ArbolBinarioBusqueda<>(clavesInOrden,valoresInOrden,clavesPostOrden,valoresPostOrden,false);
        
        System.out.println(arbolPrueba2.recorridoEnInOrden());
//        int cantUnSoloHijo = arbolPrueba.cantNodosUnSoloHijo();
//        System.out.println(cantUnSoloHijo);
//        System.out.println(arbolPrueba.unSoloHijo()); 
//        System.out.println(arbolPrueba.unSoloHijoAntesN(2));
    }
}
