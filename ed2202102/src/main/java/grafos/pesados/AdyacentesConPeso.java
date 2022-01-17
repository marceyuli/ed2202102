
package grafos.pesados;

public class AdyacentesConPeso implements Comparable<AdyacentesConPeso> {
    private int indiceVertice;
    private double peso;
    public AdyacentesConPeso(int vertice) {
        this.indiceVertice = vertice;
    }

    public AdyacentesConPeso(int vertice, double peso) {
        this.indiceVertice = vertice;
        this.peso = peso;
    }

    public int getIndiceVertice() {
        return indiceVertice;
    }

    public void setIndiceVertice(int vertice) {
        this.indiceVertice = vertice;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(AdyacentesConPeso vert) {
        Integer esteVertice = this.indiceVertice;
        Integer elOtroVertice = vert.indiceVertice;
        return esteVertice.compareTo(elOtroVertice);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 + hash + this.indiceVertice;
        return hash;
    }

    @Override
    public boolean equals(Object otro) {
        if(otro == null) {
            return false;
        }
        if(getClass() != otro.getClass()) {
            return false;
        }
        AdyacentesConPeso other = (AdyacentesConPeso) otro;
        return this.indiceVertice == other.indiceVertice;
    }

}