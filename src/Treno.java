import java.util.ArrayList;

public class Treno {
    private ArrayList<Vagone> treno;

    public Treno(){
        treno = new ArrayList<>();
    }
    /**
     * Aggiunge un vagone al treno
     */

    public void aggiungiVagone(Vagone v){
        treno.add(v);
    }
    /**
     * lista di tutti vagoni presenti in treno
     */

     public String listaVagoni(){
        String lista = "";
        for(Vagone v : treno){
            lista+=v.toString() + "\n";
        }
        return lista;
     }
     /**
      *lunghezza del treno (ovviamente ricavandola dalla lunghezza dei singoli vagoni)
      */

      public double lunghezzaTreno(){
        double lunghezza = 0;
        for(Vagone v : treno){
            lunghezza+=v.getLunghezza();
        }
        return lunghezza;
      }
      /**
       * peso totale del treno in tonnellate(ogni vagone deve restituire il suo peso attuale). Si ipotizza che il peso medio per i passeggeri sia di 70Kg = 0.07 tonnelate
       */
      public double pesoTreno(){
        double peso = 0;
        for (Vagone v : treno){
            if(v instanceof VagoneMerci){
                peso+=((VagoneMerci)v).getCaricoAttuale() + v.getPesoVuoto();
            }else{
                VagonePasseggeri v1 = (VagonePasseggeri) v;
                peso+=v1.getPesoVuoto() + v1.getNumPasseggeri() * 0.07;
            }
        }
        return peso;
      }
}
