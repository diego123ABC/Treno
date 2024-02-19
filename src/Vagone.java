public abstract class Vagone {
    protected String matricola;
    protected int lunghezza;
    protected double pesoVuoto;

    public Vagone(String matricola, int lunghezza, double pesoVuoto) {
        this.matricola = matricola;
        this.lunghezza = lunghezza;
        this.pesoVuoto = pesoVuoto;
    }

    public Vagone() {
        this.matricola = "C";
        this.lunghezza = 10;
        this.pesoVuoto = 10;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public double getPesoVuoto() {
        return pesoVuoto;
    }

    public void setPesoVuoto(double pesoVuoto) {
        this.pesoVuoto = pesoVuoto;
    }

    @Override
    public String toString() {
        return getClass().getName() + ", matricola=" + matricola + ", lunghezza=" + lunghezza + ", pesoVuoto=" + pesoVuoto;
    }

    public abstract double pesoVagone();
}
