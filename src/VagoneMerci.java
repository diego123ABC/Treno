public class VagoneMerci extends Vagone{
    private double caricoMassimo;
    private double caricoAttuale;

    public VagoneMerci(String matricola, int lunghezza, double pesoVuoto, double caricoMassimo, double caricoAttuale) {
        super(matricola, lunghezza, pesoVuoto);
        this.caricoMassimo = caricoMassimo;
        this.caricoAttuale = caricoAttuale;
    }

    public VagoneMerci(){
        this.matricola = "B";
        this.lunghezza = 60;
        this.pesoVuoto = 30;
        this.caricoMassimo = 50;
        this.caricoAttuale = 40;
    }

    public double getCaricoMassimo() {
        return caricoMassimo;
    }

    public void setCaricoMassimo(double caricoMassimo) {
        this.caricoMassimo = caricoMassimo;
    }

    public double getCaricoAttuale() {
        return caricoAttuale;
    }

    public void setCaricoAttuale(double caricoAttuale) {
        if(caricoAttuale <= 60 && caricoAttuale <= caricoMassimo && caricoAttuale >= pesoVuoto){this.caricoAttuale = caricoAttuale;}
    }

    @Override
    public String toString() {
        return super.toString() + ", caricoMassimo=" + caricoMassimo + ", caricoAttuale=" + caricoAttuale;
    }
}
