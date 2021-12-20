/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ed2202102.ui;

import com.mycompany.ed2202102.AVL;
import com.mycompany.ed2202102.ArbolBinarioBusqueda;
import com.mycompany.ed2202102.ArbolMViasBusqueda;
import com.mycompany.ed2202102.ExcepcionOrdenNoValido;
import com.mycompany.ed2202102.NodoBinario;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marce
 */
public class TestArbol {
    public static void main(String[] args)  {
            System.out.println("EJ1: Insertar AVL: 1,2,3,4,5");
            AVL<Integer,Integer> AVL = new AVL<>();
            AVL.insertar(1, 1);
            AVL.insertar(2, 2);
            AVL.insertar(3, 1);
            AVL.insertar(4, 1);
            AVL.insertar(5, 1);
            
            System.out.println("Recorrido in orden:" + AVL.recorridoEnInOrden());
            
            
            System.out.println("EJ2: ELIMINAR AVL: 3");
            AVL.eliminarAVL(3);
            System.out.println("Recorrido in Orden:" + AVL.recorridoEnInOrden());
            
            System.out.println("Ejercicio 5: insertar M vias");
            ArbolMViasBusqueda<Integer,Integer> arbolM = new ArbolMViasBusqueda<>(4);
            arbolM.insertar(120, 1);
            arbolM.insertar(200, 1);
            arbolM.insertar(80, 1);
            arbolM.insertar(150, 1);
            arbolM.insertar(130, 1);
            arbolM.insertar(50, 1);
            arbolM.insertar(100, 1);
            arbolM.insertar(300, 1);
            System.out.println("recorrido por niveles" + arbolM.recorridoPorNiveles());
             System.out.println("recorrido preorden" + arbolM.recorridoEnPreOrden());
             System.out.println("recorrido postOrden" + arbolM.recorridoEnPostOrden());
             System.out.println("Ejercicio 12: verificar si todos los nodos son completos en arbol m vias (usaremos el nivel 0 para probar)");
             System.out.println(arbolM.todosNodosCompletosEnNivelN(0));
             System.out.println("ejercicio 13: verificar arboles similares m vias \"arbolM y ArbolM2\"");
             ArbolMViasBusqueda<Integer,Integer> arbolM2 = new ArbolMViasBusqueda<>(4);
            arbolM2.insertar(240, 1);
            arbolM2.insertar(400, 1);
            arbolM2.insertar(160, 1);
            arbolM2.insertar(300, 1);
            arbolM2.insertar(260, 1);
            arbolM2.insertar(100, 1);
            arbolM2.insertar(200, 1);
            arbolM2.insertar(600, 1);
            System.out.println(arbolM.esSimilar(arbolM2));
            
            System.out.println("Ejercicio 6: eliminar del arbol m vias, el nodo 80");
            arbolM.eliminar(80);
             System.out.println("recorrido por niveles" + arbolM.recorridoPorNiveles());
            
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
            
            System.out.println("EJERCICIO 15, ES ARBOL SIMILAR? ARBOLPRUEBA Y ARBOLPRUEBA2");
            System.out.println(arbolPrueba.esArbolSimilar(arbolPrueba2));
        
        
    }

}
