
package grafos.nopesados;

public class Test {
    public static void main(String[] args) throws ExcepcionNroVerticesInvalido, ExcepcionAristaYaExiste {
       
       Digrafo digrafo = new Digrafo(9);
       digrafo.insertarArista(0, 1);
       digrafo.insertarArista(1, 2);
       digrafo.insertarArista(2, 0);
       digrafo.insertarArista(2, 3);
       digrafo.insertarArista(3, 4);
       digrafo.insertarArista(4, 7);
       digrafo.insertarArista(4, 5);
      digrafo.insertarArista(5, 6);
      digrafo.insertarArista(6, 7);
      digrafo.insertarArista(6, 4);
       EjerciciosDigrafo ejecutar2 = new EjerciciosDigrafo(digrafo);
        System.out.println(digrafo);
        System.out.println("EJ3 : HAY CICLO EN EL DIGRAFO?");
        System.out.println(ejecutar2.hayCiclo());
        System.out.println("EJ 4: HAY CICLO EN EL DIGRAFO? USANDO MATRIZ DE CAMINOS");
        MatrizDeCaminos matriz = new MatrizDeCaminos(digrafo);
        System.out.println(matriz.hayCiclo());
        System.out.println("EJ5: RETORNAR LOS ELEMENTOS DE LAS ISLAS DE UN DIGRAFO");
        ejecutar2.elementosIslas();
        System.out.println("EJ6: Encontrar la matriz de caminos");
        matriz.showMatriz(matriz.matrizDeCaminos());
        System.out.println("EJ7: Metodo digrafo para encontrar si es debilmente conexo");
        System.out.println(ejecutar2.esDebilmenteConexo());
        System.out.println("EJ8: METODO digrafo para encontrar si es fuertemente conexo");
        System.out.println(ejecutar2.esFuertementeConexo());
        Grafo grafo= new Grafo(8);
        grafo.insertarArista(0, 1);
        grafo.insertarArista(0, 2);
        grafo.insertarArista(1, 2);
        grafo.insertarArista(1, 4);
        grafo.insertarArista(2, 3);
        grafo.insertarArista(5, 6);
       // grafo.insertarArista(6, 7);
        grafo.insertarArista(7, 5);
        EjerciciosGrafo ejecutar = new EjerciciosGrafo(grafo);
        System.out.println("EJ9: VERIFICAR SI HAY CICLOS EN UN GRAFO");
        System.out.println(ejecutar.hayCiclo());
        System.out.println("EJ 10: OBTENER LOS ELEMENTOS DE LAS ISLAS DE UN GRAFO");
        ejecutar.elementosIslas();
        System.out.println("EJ 11: NRO DE ISLAS EN EL DIGRAFO");
        System.out.println(ejecutar2.cantIslas());
        System.out.println("EJ 12: IMPLEMENTAR EL ALGORITMO DE WARSHALL");
        AW ejecutarWarshall = new AW(digrafo);
        ejecutarWarshall.showMatriz(ejecutarWarshall.algoritmoWharsall());
        System.out.println("EJ 14: CUANTAS COMPONENTES FUERTEMENTE CONEXAS EXISTEN");
        System.out.println(ejecutar2.cantidadCFC());
    }
}
