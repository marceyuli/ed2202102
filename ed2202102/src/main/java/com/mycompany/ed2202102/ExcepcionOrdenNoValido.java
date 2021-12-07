
package com.mycompany.ed2202102;

class ExcepcionOrdenNoValido extends Exception {

    public ExcepcionOrdenNoValido() {
        super("Clave no existe en el arbol");
    }

    public ExcepcionOrdenNoValido(String string) {
        super(string);
    }
    
}