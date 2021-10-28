/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed2202102.ui;

import com.mycompany.ed2202102.ArbolBinarioBusqueda;

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
        
        
        
        int cantUnSoloHijo = arbolPrueba.cantNodosUnSoloHijo();
        System.out.println(cantUnSoloHijo);
        System.out.println(arbolPrueba.unSoloHijo()); 
        System.out.println(arbolPrueba.unSoloHijoAntesN(2));
    }
}
