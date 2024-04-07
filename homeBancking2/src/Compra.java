public class Compra implements Comparable<Compra>{

    private double valor;
    private String descripcion;

    public Compra(double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Compra: valor= " + valor +
                ", descripcion=' " + descripcion;
    }

    @Override
    public int compareTo(Compra compra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(compra.getValor()));
    }
}
