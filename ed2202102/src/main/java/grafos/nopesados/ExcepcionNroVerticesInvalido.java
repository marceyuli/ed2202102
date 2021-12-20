/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos.nopesados;

/**
 *
 * @author marce
 */
class ExcepcionNroVerticesInvalido extends Exception {
     public ExcepcionNroVerticesInvalido() {
        super("NRO VERTICES INVALIDO");
    }

    public ExcepcionNroVerticesInvalido(String string) {
        super(string);
    } 
}
