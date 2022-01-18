/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.pesados;

/**
 *
 * @author marce
 */
class Arista {
    int verticeOrigen;
    int verticeDestino;
    double peso;

    public Arista(int verticeOrigen, int verticeDestino, double peso) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.peso = peso;
    }
}
