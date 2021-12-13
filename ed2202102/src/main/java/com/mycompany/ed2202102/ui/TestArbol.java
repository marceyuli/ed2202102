/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed2202102.ui;

import com.mycompany.ed2202102.ArbolBinarioBusqueda;
import com.mycompany.ed2202102.NodoBinario;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marce
 */
public class TestArbol {
    public static void main(String[] args) {
        ArbolBinarioBusqueda<Integer,Integer> arbolPrueba = new ArbolBinarioBusqueda<>();
        
        
        arbolPrueba.insertar(13, 1);
        arbolPrueba.insertar(9, 1);
        arbolPrueba.insertar(15, 1);
        arbolPrueba.insertar(1, 1);
        arbolPrueba.insertar(14, 1);
        arbolPrueba.insertar(16, 1);
        arbolPrueba.insertar(10, 1);
        arbolPrueba.insertar(2, 1);
        arbolPrueba.insertar(11, 1);
        
        System.out.println("EJERCICIO 7: CANTIDAD DE NODOS QUE TIENEN AMBOS HIJOS DISTINTOS DE VACIO USANDO INORDEN");
        System.out.println(arbolPrueba.cantidadAmbosHijosNoVaciosInOrden());
        
        System.out.println("EJERCICIO 8: CANTIDAD DE NODOS QUE TIENEN UN SOLO HIJO (RECURSIVO)");
        System.out.println(arbolPrueba.cantNodosUnSoloHijo());
        
        System.out.println("EJERCICIO 9:CANTIDAD DE HIJOS VACIOS USANDO INORDEN");
        System.out.println(arbolPrueba.cantHijosVaciosInOrden());
   
       System.out.println("EJERCICIO 10: RECONSTRUCCION DE ARBOL");
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
        System.out.println("claves in orden :" + clavesInOrden  );
         System.out.println("claves post orden :" + clavesPostOrden  );
        ArbolBinarioBusqueda<Integer,Integer> arbolPrueba2 = new ArbolBinarioBusqueda<>(clavesInOrden,valoresInOrden,clavesPostOrden,valoresPostOrden,false);
        
        
        System.out.println("RECORRIDO PRE ORDEN DEL NUEVO ARBOL");
        System.out.println(arbolPrueba2.recorridoEnPreOrden());

        System.out.println("Ejercicio 11, pasar un nodo y que devuelta el predecesor");
        System.out.println(arbolPrueba.recorridoEnInOrden());
        System.out.println("Se le pasara la raiz");
        System.out.println("predecesor =");
        System.out.println(arbolPrueba.predecesorInOrden(arbolPrueba.getRaiz()));
    }

}
