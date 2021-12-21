package com.mycompany.ed2202102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArbolBinarioBusqueda<K extends Comparable<K>, V> implements IArbolBusqueda<K, V> {

    public ArbolBinarioBusqueda() {
    }

    protected NodoBinario<K, V> raiz;
    /*
    Implemente un método que reciba en listas de parámetros las llaves y valores de los
    recorridos en postorden e inorden respectivamente y que reconstruya el árbol binario
    original. Su método no debe usar el método insertar
*/
    public ArbolBinarioBusqueda(List<K> clavesInOrden, List<V> valoresInOrden,
            List<K> clavesNoInOrden, List<V> valoresNoInOrden, boolean esConPreOrden) {
        if (clavesInOrden.size() != clavesNoInOrden.size()
                || valoresInOrden.size() != valoresNoInOrden.size()
                || clavesInOrden.size() != valoresNoInOrden.size()) {
            throw new RuntimeException("No se permiten tamaños distintos");
        }
        if (esConPreOrden) {
            this.raiz = reconstruccionConPreOrden(clavesInOrden, valoresInOrden, clavesNoInOrden, valoresNoInOrden);
        } else {
            this.raiz = reconstruccionConPostOrden(clavesInOrden, valoresInOrden, clavesNoInOrden, valoresNoInOrden);
        }
    }

    private NodoBinario<K, V> reconstruccionConPostOrden(List<K> clavesInOrden, List<V> valoresInOrden,
            List<K> clavesPostOrden, List<V> valoresPostOrden) {
        if (clavesInOrden.isEmpty()) {
            return null;
        }
        int posicionDeClavePadreEnPostOrden = clavesPostOrden.size() - 1;
        K clavePadre = clavesPostOrden.get(posicionDeClavePadreEnPostOrden);
        V valorPadre = valoresPostOrden.get(posicionDeClavePadreEnPostOrden);
        int posicionDeClavePadreEnInOrden = this.posicionDeClave(clavePadre, clavesInOrden);
        //Armar rama por Izquierda
        List<K> clavesInOrdenPorIzquierda = clavesInOrden.subList(0, posicionDeClavePadreEnInOrden);
        List<V> valoresInOrdenPorIzquierda = valoresInOrden.subList(0, posicionDeClavePadreEnInOrden);
        List<K> clavesPostOrdenPorIzquierda = clavesPostOrden.subList(0, posicionDeClavePadreEnInOrden);
        List<V> valoresPostOrdenPorIzquierda = valoresPostOrden.subList(0, posicionDeClavePadreEnInOrden);
        NodoBinario<K, V> hijoIzquierdo = reconstruccionConPostOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda,
                clavesPostOrdenPorIzquierda, valoresPostOrdenPorIzquierda);
        //Armar rama derecha
        List<K> clavesInOrdenPorDerecha = clavesInOrden.subList(posicionDeClavePadreEnInOrden + 1, clavesInOrden.size());
        List<V> valoresInOrdenPorDerecha = valoresInOrden.subList(posicionDeClavePadreEnInOrden + 1, clavesInOrden.size());
        List<K> clavesPostOrdenPorDerecha = clavesPostOrden.subList(posicionDeClavePadreEnInOrden, clavesPostOrden.size() - 1);
        List<V> valoresPostOrdenPorDerecha = valoresPostOrden.subList(posicionDeClavePadreEnInOrden, clavesPostOrden.size() - 1);
        NodoBinario<K, V> hijoDerecho = reconstruccionConPostOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha,
                clavesPostOrdenPorDerecha, valoresPostOrdenPorDerecha);
        // Aramar nodo Actual
        NodoBinario<K, V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoDerecho(hijoDerecho);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        return nodoActual;
    }

    private int posicionDeClave(K claveAEncontrar, List<K> listaDeClaves) {
        for (int i = 0; i < listaDeClaves.size(); i++) {
            K claveActual = listaDeClaves.get(i);
            if (claveActual.compareTo(claveAEncontrar) == 0) {
                return i;
            }
        }
        return -1;
    }

    private NodoBinario<K, V> reconstruccionConPreOrden(List<K> clavesInOrden, List<V> valoresInOrden,
            List<K> clavesPreOrden, List<V> valoresPreOrden) {
        if (clavesInOrden.isEmpty()) {
            return null;
        }
        int posicionDeClavePadrePreOrden = 0;
        K clavePadre = clavesPreOrden.get(posicionDeClavePadrePreOrden);
        V valorPadre = valoresPreOrden.get(posicionDeClavePadrePreOrden);
        int posicionDeClavePadreInOrden = posicionDeClave(clavePadre, clavesInOrden);
        //Armando Rama Izquierda
        List<K> clavesInOrdenPorIzquierda = clavesInOrden.subList(0, posicionDeClavePadreInOrden);
        List<V> valoresInOrdenPorIzquierda = valoresInOrden.subList(0, posicionDeClavePadreInOrden);
        List<K> clavesPreOrdenPorIzquierda = clavesInOrden.subList(1, posicionDeClavePadreInOrden + 1);
        List<V> valorespreOrdenPorIzquierda = valoresInOrden.subList(1, posicionDeClavePadreInOrden + 1);
        NodoBinario<K, V> hijoIzquierdo = reconstruccionConPreOrden(clavesInOrdenPorIzquierda, valoresInOrdenPorIzquierda, clavesPreOrdenPorIzquierda, valorespreOrdenPorIzquierda);
        //Armando Rama Derecha
        List<K> clavesInOrdenPorDerecha = clavesInOrden.subList(posicionDeClavePadreInOrden + 1, clavesInOrden.size());
        List<V> valoresInOrdenPorDerecha = valoresInOrden.subList(posicionDeClavePadreInOrden + 1, clavesInOrden.size());
        List<K> clavesPreOrdenPorDerecha = clavesInOrden.subList(posicionDeClavePadreInOrden + 1, clavesInOrden.size());
        List<V> valorespreOrdenPorDerecha = valoresInOrden.subList(posicionDeClavePadreInOrden + 1, clavesInOrden.size());
        NodoBinario<K, V> hijoDerecho = reconstruccionConPreOrden(clavesInOrdenPorDerecha, valoresInOrdenPorDerecha, clavesPreOrdenPorDerecha, valorespreOrdenPorDerecha);
        //Armamos el arbol
        NodoBinario<K, V> nodoActual = new NodoBinario<>(clavePadre, valorPadre);
        nodoActual.setHijoIzquierdo(hijoIzquierdo);
        nodoActual.setHijoDerecho(hijoDerecho);
        return nodoActual;
    }

    @Override
    public void insertar(K claveAInsertar, V valorAInsertar) throws NullPointerException {
        if (claveAInsertar == null) {
            throw new NullPointerException("No se permiten insertar claves vacias");
        }
        if (valorAInsertar == null) {
            throw new NullPointerException("No se permiten insertar claves vacias");
        }
        if (this.esArbolVacio()) {
            this.raiz = new NodoBinario<>(claveAInsertar, valorAInsertar);
            return;
        }
        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        NodoBinario<K, V> nodoActual = this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            K claveActual = nodoActual.getClave();
            nodoAnterior = nodoActual;
            if (claveAInsertar.compareTo(claveActual) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveAInsertar.compareTo(claveActual) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            } else {
                nodoActual.setValor(valorAInsertar);
                return;
            }
        }
        K claveAnterior = nodoAnterior.getClave();
        NodoBinario<K, V> nuevoNodo = new NodoBinario<>(claveAInsertar, valorAInsertar);
        if (claveAInsertar.compareTo(claveAnterior) < 0) {
            nodoAnterior.setHijoIzquierdo(nuevoNodo);
        } else {
            nodoAnterior.setHijoDerecho(nuevoNodo);
        }
    }

    @Override
    public V eliminar(K claveAEliminar) throws ExcepcionClaveNoExiste {
        V valorAEliminar = this.buscar(claveAEliminar);
        if (valorAEliminar == null) {
            throw new ExcepcionClaveNoExiste();
        }
        this.raiz = eliminar(this.raiz, claveAEliminar);

        return valorAEliminar;
    }

    private NodoBinario<K, V> eliminar(NodoBinario<K, V> nodoActual, K claveAEliminar) {
        K claveActual = nodoActual.getClave();

        if (claveAEliminar.compareTo(claveActual) < 0) {
            NodoBinario<K, V> supuestoNuevoHijoIzq = eliminar(nodoActual.getHijoIzquierdo(),
                    claveAEliminar);
            nodoActual.setHijoIzquierdo(supuestoNuevoHijoIzq);
            return nodoActual;
        }

        if (claveAEliminar.compareTo(claveActual) > 0) {
            NodoBinario<K, V> supuestoNuevoHijoDer = eliminar(nodoActual.getHijoDerecho(),
                    claveAEliminar);
            nodoActual.setHijoIzquierdo(supuestoNuevoHijoDer);
            return nodoActual;
        }
        //si llego aca, ya encontre el nodo con la clave a eliminar
        //revisamos que caso es 
        //CASO 1
        if (nodoActual.esHoja()) {
            return NodoBinario.nodoVacio();
        }
        //Caso 2
        //Caso 2.1
        if (!nodoActual.esVacioHijoIzquierdo()
                && nodoActual.esVacioHijoDerecho()) {
            return nodoActual.getHijoIzquierdo();
        }
        //Caso 2.2
        if (nodoActual.esVacioHijoIzquierdo() && !nodoActual.esVacioHijoDerecho()) {
            return nodoActual.getHijoDerecho();
        }
        //Caso 3 
        NodoBinario<K, V> nodoDelSucesor = buscarSucesor(nodoActual.getHijoDerecho());

        NodoBinario<K, V> supuestoNuevoHijo = eliminar(nodoActual.getHijoDerecho(), nodoDelSucesor.getClave());

        nodoActual.setHijoDerecho(supuestoNuevoHijo);
        nodoActual.setClave(nodoDelSucesor.getClave());
        nodoActual.setValor(nodoDelSucesor.getValor());

        return nodoActual;
    }

    public NodoBinario<K, V> buscarSucesor(NodoBinario<K, V> nodoActual) {
        NodoBinario<K, V> nodoAnterior = NodoBinario.nodoVacio();
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getHijoIzquierdo();
        }
        return nodoAnterior;
    }

    @Override
    public V buscar(K claveABuscar) {
        if (claveABuscar == null) {
            return null;
        }
        NodoBinario<K, V> nodoActual = this.raiz;
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            K claveActual = nodoActual.getClave();
            if (claveABuscar.compareTo(claveActual) < 0) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else if (claveABuscar.compareTo(claveActual) > 0) {
                nodoActual = nodoActual.getHijoDerecho();
            } else {
                return nodoActual.getValor();
            }
        }
        return null;
    }

    @Override
    public boolean contiene(K claveABuscar) {
        return this.buscar(claveABuscar) != null;
    }

    @Override
    //POSTORDEN : IDR
    public int size() {
        int cantidad = 0;
        if (!this.esArbolVacio()) {
            Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
            NodoBinario<K, V> nodoActual = this.raiz;
            insertarEnPilaParaPostOrden(nodoActual, pilaDeNodos);
            while (!pilaDeNodos.isEmpty()) {
                nodoActual = pilaDeNodos.pop();
                cantidad++;
            }
            if (!pilaDeNodos.isEmpty()) {
                NodoBinario<K, V> nodoDelTope = pilaDeNodos.peek();
                if (!nodoDelTope.esVacioHijoDerecho()
                        && nodoDelTope.getHijoDerecho() != nodoActual) {
                    insertarEnPilaParaPostOrden(nodoDelTope.getHijoDerecho(), pilaDeNodos);
                }
            }
        }
        return cantidad;
    }

    public int sizeRec() {
        return sizeRec(this.raiz);
    }

    private int sizeRec(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int cantIzq = sizeRec(nodoActual.getHijoIzquierdo());
        int cantDer = sizeRec(nodoActual.getHijoDerecho());
        return cantIzq + cantDer + 1;
    }

    @Override
    public int altura() {
        int altura = 0;
        if (!this.esArbolVacio()) {
            Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            while (!colaDeNodos.isEmpty()) {
                int nroNodosDelNivel = colaDeNodos.size();
                int contador = 0;
                while (contador < nroNodosDelNivel) {
                    NodoBinario<K, V> nodoActual = colaDeNodos.poll();
                    contador++;
                    if (!nodoActual.esVacioHijoIzquierdo()) {
                        colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                    }
                    if (!nodoActual.esVacioHijoDerecho()) {
                        colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                    }
                }
                altura++;

            }
        }
        return altura;
    }

    public int alturaRec() {
        return alturaRec(this.raiz);
    }

    protected int alturaRec(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int alturaIzq = alturaRec(nodoActual.getHijoIzquierdo());
        int alturaDer = alturaRec(nodoActual.getHijoDerecho());
        return alturaIzq > alturaDer ? alturaIzq + 1 : alturaDer + 1;
    }

    @Override
    public void vaciar() {
        this.raiz = NodoBinario.nodoVacio();
    }

    @Override
    public boolean esArbolVacio() {
        return NodoBinario.esNodoVacio(this.raiz);
    }

    @Override
    public List<K> recorridoPorNiveles() {
        List<K> recorrido = new ArrayList<>();
        if (!this.esArbolVacio()) {
            Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
            colaDeNodos.offer(this.raiz);
            while (!colaDeNodos.isEmpty()) {
                NodoBinario<K, V> nodoActual = colaDeNodos.poll();
                recorrido.add(nodoActual.getClave());
                if (!nodoActual.esVacioHijoIzquierdo()) {
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
                if (!nodoActual.esVacioHijoDerecho()) {
                    colaDeNodos.offer(nodoActual.getHijoIzquierdo());
                }
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnPreOrden() {
        List<K> recorrido = new ArrayList<>();
        if (!this.esArbolVacio()) {
            Stack<NodoBinario<K, V>> pilaDeNodo = new Stack<>();
            pilaDeNodo.push(this.raiz);
            while (!pilaDeNodo.isEmpty()) {
                NodoBinario<K, V> nodoActual = pilaDeNodo.pop();
                recorrido.add(nodoActual.getClave());
                if (!nodoActual.esVacioHijoDerecho()) {
                    pilaDeNodo.push(nodoActual.getHijoDerecho());
                }
                if (!nodoActual.esVacioHijoIzquierdo()) {
                    pilaDeNodo.push(nodoActual.getHijoIzquierdo());
                }
            }
        }
        return recorrido;
    }

    @Override
    public List<K> recorridoEnInOrden() {
        List<K> recorrido = new LinkedList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
        NodoBinario<K, V> nodoActual = this.raiz;
        insertarEnPilaRamaIzquierda(nodoActual, pilaDeNodos);

        //iniciando a sacar nodos de la pila
        while (!pilaDeNodos.isEmpty()) {
            nodoActual = pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!nodoActual.esVacioHijoDerecho()) {
                insertarEnPilaRamaIzquierda(nodoActual.getHijoDerecho(), pilaDeNodos);
            }
        }
        return recorrido;
    }

    private void insertarEnPilaRamaIzquierda(NodoBinario<K, V> nodoActual, Stack<NodoBinario<K, V>> pilaDeNodos) {
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            pilaDeNodos.push(nodoActual);
            nodoActual = nodoActual.getHijoIzquierdo();
        }
    }

    public List<K> recorridoInOrdenRec() {
        List<K> recorrido = new ArrayList<>();
        this.recorridoInOrdenRec(this.raiz, recorrido);
        return recorrido;
    }

    private void recorridoInOrdenRec(NodoBinario<K, V> nodoActual, List<K> recorrido) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return;
        }
        recorridoInOrdenRec(nodoActual.getHijoIzquierdo(), recorrido);
        recorrido.add(nodoActual.getClave());
        recorridoInOrdenRec(nodoActual.getHijoDerecho(), recorrido);
    }

    @Override
    public List<K> recorridoEnPostOrden() {
        List<K> recorrido = new LinkedList<>();
        if (this.esArbolVacio()) {
            return recorrido;
        }
        Stack<NodoBinario<K, V>> pilaDeNodos = new Stack<>();
        NodoBinario<K, V> nodoActual = this.raiz;
        insertarEnPilaParaPostOrden(nodoActual, pilaDeNodos);

        //iniciando a sacar nodos de la pila
        while (!pilaDeNodos.isEmpty()) {
            nodoActual = pilaDeNodos.pop();
            recorrido.add(nodoActual.getClave());
            if (!pilaDeNodos.isEmpty()) {
                NodoBinario<K, V> nodoDelTope = pilaDeNodos.peek();
                if (!nodoDelTope.esVacioHijoDerecho()
                        && nodoDelTope.getHijoDerecho() != nodoActual) {
                    insertarEnPilaParaPostOrden(nodoDelTope.getHijoDerecho(), pilaDeNodos);
                }
            }
        }
        return recorrido;
    }

    private void insertarEnPilaParaPostOrden(NodoBinario<K, V> nodoActual, Stack<NodoBinario<K, V>> pilaDeNodos) {
        while (!NodoBinario.esNodoVacio(nodoActual)) {
            pilaDeNodos.push(nodoActual);
            if (!nodoActual.esVacioHijoIzquierdo()) {
                nodoActual = nodoActual.getHijoIzquierdo();
            } else {
                nodoActual = nodoActual.getHijoDerecho();
            }
        }
    }

    //Cantidad de nodos con un solo hijo distintos de vacio
    public int cantNodosUnSoloHijo() {
        return cantNodosUnSoloHijo(this.raiz);
    }

    private int cantNodosUnSoloHijo(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int cantIzq = cantNodosUnSoloHijo(nodoActual.getHijoIzquierdo());
        int cantDer = cantNodosUnSoloHijo(nodoActual.getHijoDerecho());
        int cantTotal = cantIzq + cantDer;
        if ((!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo())
                || (nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo())) {
            cantTotal++;
        }
        return cantTotal;
    }

    //retorna si todos los nodos de un arbol (menos las hojas) tienen un solo hijo
    public boolean unSoloHijo() {
        return unSoloHijo(this.raiz);
    }

    private boolean unSoloHijo(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return false;
        }
        if (nodoActual.esHoja()) {
            return true;
        }

        if (!unSoloHijo(nodoActual.getHijoIzquierdo())) {
            return false;
        }

        if (!unSoloHijo(nodoActual.getHijoDerecho())) {
            return false;
        }
        if ((!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo())
                || (nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo())) {
            return true;
        }
        return false;
    }

    //retorna si todos los nodos de un arbol (menos las hojas) tienen un solo hijo antes del nivel N
    // validar antes que nivelN sea valido o que el arbol no sea vacio
    public boolean unSoloHijoAntesN(int nivelN) {
        return unSoloHijoAntesN(this.raiz, nivelN, 0);
    }

    private boolean unSoloHijoAntesN(NodoBinario<K, V> nodoActual, int nivelN, int nivelActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return true;
        }
        if (nodoActual.esHoja()) {
            return true;
        }
        if (nivelActual < nivelN) {
            boolean verifIzq = unSoloHijoAntesN(nodoActual.getHijoIzquierdo(), nivelN, nivelActual + 1);
            boolean verifDer = unSoloHijoAntesN(nodoActual.getHijoDerecho(), nivelN, nivelActual + 1);
            boolean resul = verifIzq || verifDer;
            if ((!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo())
                    || (nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo())) {
                resul = resul && true;
            } else {
                resul = false;
            }

            return resul;
        }
        return true;
    }

    /*
7. Implemente un método iterativo con el recorrido en inorden que retorne la cantidad de
nodos que tienen ambos hijos distintos de vacío en un árbol binario
     */
    public int cantidadAmbosHijosNoVaciosInOrden() {
        int contador = 0;
        NodoBinario<K, V> nodoActual = this.raiz;
        Stack<NodoBinario<K, V>> pila = new Stack<>();
        insertarEnPilaRamaIzquierda(nodoActual, pila);
        while (!pila.isEmpty()) {
            nodoActual = pila.pop();
            if (!nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo()) {
                contador++;
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                insertarEnPilaRamaIzquierda(nodoActual.getHijoDerecho(), pila);
            }
        }
        return contador;
    }

    /*
    8. Implemente un método recursivo que retorne la cantidad de nodos que tienen un solo hijo
    no vació*/
    public int cantidadNodosUnSoloHijo() {
        return cantidadNodosUnSoloHijo(this.raiz);
    }

    private int cantidadNodosUnSoloHijo(NodoBinario<K, V> nodoActual) {
        if (NodoBinario.esNodoVacio(nodoActual)) {
            return 0;
        }
        int cantIzq = cantidadNodosUnSoloHijo(nodoActual.getHijoIzquierdo());
        int cantDer = cantidadNodosUnSoloHijo(nodoActual.getHijoDerecho());
        int cantTotal = cantIzq + cantDer;
        if ((nodoActual.esVacioHijoDerecho() && !nodoActual.esVacioHijoIzquierdo())
                || (!nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo())) {
            cantTotal++;
        }
        return cantTotal;
    }

    /*9. Implemente un método iterativo con la lógica de un recorrido en inOrden que retorne el
número de hijos vacios que tiene un árbol binario. */
    public int cantHijosVaciosInOrden() {
        int contador = 0;
        Stack<NodoBinario<K, V>> pila = new Stack<>();
        insertarEnPilaRamaIzquierda(this.raiz, pila);
        while (!pila.isEmpty()) {
            NodoBinario<K, V> nodoActual = pila.pop();
            if (nodoActual.esVacioHijoDerecho() && nodoActual.esVacioHijoIzquierdo()) {
                contador = contador + 2;
            } else {
                if (nodoActual.esVacioHijoDerecho() || nodoActual.esVacioHijoIzquierdo()) {
                    contador++;
                }
            }
            if (!nodoActual.esVacioHijoDerecho()) {
                insertarEnPilaRamaIzquierda(nodoActual.getHijoDerecho(), pila);
            }
        }
        return contador;
    }
    /*
    11. Implemente un método privado que reciba un nodo binario de un árbol binario y que
retorne cuál sería su predecesor inorden de la clave de dicho nodo. */
    
//Predecesor in orden 
public NodoBinario<K, V> predecesorInOrden(NodoBinario<K, V> nodoRecibido) {
        List<K> recorridoInOrden = new LinkedList<>();
        recorridoInOrden = this.recorridoEnInOrden();
        int posicionRecibido = this.posicionDeClave(nodoRecibido.getClave(), recorridoInOrden);
        if(posicionRecibido == 0) {
            //throw new RuntimeException("Nodo no tiene sucesor");
            return null;
        }
        int posicionDelPredecesor = this.posicionDeClave(nodoRecibido.getClave(), recorridoInOrden) - 1;
        K claveDelPredecesor = recorridoInOrden.get(posicionDelPredecesor);
        Queue<NodoBinario<K, V>> colaDeNodos = new LinkedList<>();
        colaDeNodos.offer(this.raiz);
        while(!colaDeNodos.isEmpty()) {
            NodoBinario<K, V> nodoActual = colaDeNodos.poll();
            if(nodoActual.getClave() == claveDelPredecesor) {
                return nodoActual;
            }
            if(!nodoActual.esVacioHijoIzquierdo()) {
                colaDeNodos.offer(nodoActual.getHijoIzquierdo());
            }
            if(!nodoActual.esVacioHijoDerecho()) {
                colaDeNodos.offer(nodoActual.getHijoDerecho());
            }
        }
        return null;
    }

    public NodoBinario<K, V> getRaiz() {
        return raiz;
    }
/* Para un árbol binario de búsqueda implemente un método que reciba como parámetro otro
árbol y que retorne verdadero si los arboles son similares, falso en caso contrario. */
    public boolean esArbolSimilar(ArbolBinarioBusqueda<K,V> arbol2){
          boolean flag= true;
          flag= esArbolSimilar(this.raiz, arbol2.raiz,flag);
          return flag;
      }
      private boolean esArbolSimilar(NodoBinario<K,V> nodoActual, NodoBinario<K,V> nodoActualDos,boolean flag){
          if(NodoBinario.esNodoVacio(nodoActual)&&(NodoBinario.esNodoVacio(nodoActualDos))){
              return true;
          }
          else if(!NodoBinario.esNodoVacio(nodoActual)&&(NodoBinario.esNodoVacio(nodoActualDos))){
              return false;
          }
          else if(NodoBinario.esNodoVacio(nodoActual)&&(!NodoBinario.esNodoVacio(nodoActualDos))){
              return false;
          }
          else{
              boolean porIzquierda= esArbolSimilar(nodoActual.getHijoIzquierdo(),nodoActualDos.getHijoIzquierdo(),flag);
              boolean porDerecha= esArbolSimilar(nodoActual.getHijoDerecho(),nodoActualDos.getHijoDerecho(),flag);
              if(porIzquierda&&porDerecha){
                  flag=true;
              }
              else{
                  flag=false;
              }
          }
          return flag;
      }
    
    //PRACTICA APARTE 
      //Es arbol identico?
      public boolean esArbolIdentico(ArbolBinarioBusqueda arbol2){
          boolean flag = true;
          return esArbolIdentico(this.raiz, arbol2.raiz, flag);
      }
      private boolean esArbolIdentico(NodoBinario<K,V> unNodo, NodoBinario<K,V> otroNodo, boolean flag){
          if(NodoBinario.esNodoVacio(unNodo) && NodoBinario.esNodoVacio(otroNodo)){
              return true;
          }
          else if((!NodoBinario.esNodoVacio(unNodo) && NodoBinario.esNodoVacio(otroNodo))||
                  NodoBinario.esNodoVacio(unNodo) && !NodoBinario.esNodoVacio(otroNodo)){
              return false;
          }
          boolean verifIzq = esArbolIdentico(unNodo.getHijoIzquierdo(), otroNodo.getHijoIzquierdo(), flag);
            boolean verifDer = esArbolIdentico(unNodo.getHijoDerecho(), otroNodo.getHijoDerecho(), flag);
            flag= verifIzq && verifDer;
          if(verifIzq && verifDer){
             
              if(unNodo.getClave().compareTo(otroNodo.getClave()) == 0){
                  flag =  flag && true;
              } else{
                  flag = flag && false;
              }
          }
          return flag;
      }
      public int sizeInterativoUsandoInOrden(){
          int size =0;
          Stack<NodoBinario<K,V>> pilaDeNodos = new Stack<>();
          insertarEnPilaRamaIzquierda(this.raiz, pilaDeNodos);
          while(!pilaDeNodos.empty()){
              NodoBinario<K,V> nodoActual = pilaDeNodos.pop();
              size++;
              if(!nodoActual.esVacioHijoDerecho()){
                  insertarEnPilaRamaIzquierda(nodoActual.getHijoDerecho(),pilaDeNodos);
              }
          }
          return size;
      }
              
}
