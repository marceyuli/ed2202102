
package grafos.nopesados;

public class AW {
     private Grafo grafo;

    public AW(Grafo grafo) {
        this.grafo = grafo;
    }
    public int[][] algoritmoWharsall (){
        int matriz[][] = matrizDeAdyacencia();
        for (int k = 0; k < grafo.cantidadDeVertices(); k++){
            for (int i = 0; i < grafo.cantidadDeVertices(); i++){
                for (int j = 0; j < grafo.cantidadDeVertices(); j++){
                    matriz[i][j] = matriz[i][j] | (matriz[k][j] & matriz[i][k]);
                }
            }
        }
        return matriz;
    }
    public int[][] matrizDeAdyacencia() {
        int tamaño = this.grafo.cantidadDeVertices();
        int[][] matriz = new int[tamaño][tamaño];
        Inicializar(matriz, tamaño);
        for (int i = 0; i < tamaño; i++) {
            for (int j : grafo.listaDeAdyacencias.get(i)) {
                matriz[i][j] = 1;
            }
        }
        return matriz;
    }
      private void Inicializar(int[][] matriz, int tamaño) {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                matriz[i][j] = 0;
            }
        }
    }
     public void showMatriz(int[][] matriz) {
        int tamaño = grafo.cantidadDeVertices();
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
