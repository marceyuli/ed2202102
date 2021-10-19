
package com.mycompany.ed2202102;

class ExcepcionClaveNoExiste extends Exception {

    public ExcepcionClaveNoExiste() {
        super("Clave no existe en el arbol");
    }

    public ExcepcionClaveNoExiste(String string) {
        super(string);
    }
    
}
