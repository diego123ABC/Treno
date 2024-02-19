public class VagonePasseggeri extends Vagone{
    private int massimoPasseggeri;
    private int numPasseggeri;

    public VagonePasseggeri(String matricola, int lunghezza, double pesoVuoto, int massimoPasseggeri,
            int numPasseggeri) {
        super(matricola, lunghezza, pesoVuoto);
        this.massimoPasseggeri = massimoPasseggeri;
        this.numPasseggeri = numPasseggeri;
    }

    public VagonePasseggeri(){
        this.matricola = "A";
        this.lunghezza = 100;
        this.pesoVuoto = 40;
        this.massimoPasseggeri = 50;
        this.numPasseggeri = 40;
    }

    public int getMassimoPasseggeri() {
        return massimoPasseggeri;
    }

    public void setMassimoPasseggeri(int massimoPasseggeri) {
        this.massimoPasseggeri = massimoPasseggeri;
    }

    public int getNumPasseggeri() {
        return numPasseggeri;
    }

    public void setNumPasseggeri(int numPasseggeri) {
        if(numPasseggeri <= 60 && numPasseggeri <= massimoPasseggeri && numPasseggeri > 0){this.numPasseggeri = numPasseggeri;}
    }

    @Override
    public String toString() {
        return super.toString() + ", massimoPasseggeri=" + massimoPasseggeri + ", numPasseggeri=" + numPasseggeri;
    }

    @Override
    public double pesoVagone() {
        return this.getPesoVuoto() + this.getNumPasseggeri() * 0.07;
    }
}
