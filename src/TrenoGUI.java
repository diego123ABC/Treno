import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class TrenoGUI extends JFrame{
    private Treno treno;
    private JPanel pannelloTitolo;
    private JPanel pannelloTreno;
    private JPanel pannelloBottoni;
    private JButton aggiungiVagoneMerci;
    private JButton aggiungiVagonePasseggeri;
    private JButton listaVagoni;
    private JButton lunghezzaTreno;
    private JButton pesoTreno;
    private JLabel titolo;
    private JLabel lunghezza;
    private JLabel peso;
    private JTextArea lista;
    private JPanel pannelloValori; //Contiene lunghezza, peso e lista vagoni

    public TrenoGUI(Treno treno){
        this.treno = treno;
        this.setSize(1400,900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pannelloValori = new JPanel();
        pannelloTitolo = new JPanel();
        pannelloTreno = new JPanel();
        pannelloBottoni = new JPanel();
        pannelloBottoni.setLayout(new GridLayout(0, 1)); //Griglia con 1 colonna

        titolo = new JLabel();
        titolo.setText("Treno GUI");
        titolo.setFont(new Font("Sanserif", Font.BOLD, 60));
        titolo.setHorizontalAlignment(JLabel.CENTER); //Titolo al centro

        aggiungiVagoneMerci = new JButton("Aggiungi un vagone merci");
        aggiungiVagoneMerci.setFont(new Font("Sanserif", Font.BOLD, 15));
        aggiungiVagoneMerci.addActionListener(new AscoltaAggiungiVagoneMerci());
        aggiungiVagoneMerci.setContentAreaFilled(false); //Rendo trasparente lo sfondo dell bottone
        aggiungiVagoneMerci.setBorderPainted(false); //Elimino i bordi del bottone

        aggiungiVagonePasseggeri = new JButton("Aggiungi un vagone passeggeri");
        aggiungiVagonePasseggeri.setFont(new Font("Sanserif", Font.BOLD, 15));
        aggiungiVagonePasseggeri.addActionListener(new AscoltaAggiungiVagonePasseggeri());
        aggiungiVagonePasseggeri.setContentAreaFilled(false);
        aggiungiVagonePasseggeri.setBorderPainted(false);

        listaVagoni = new JButton("Lista vagoni del treno");
        listaVagoni.setFont(new Font("Sanserif", Font.BOLD, 15));
        listaVagoni.addActionListener(new AscoltaListaVagoni());
        listaVagoni.setContentAreaFilled(false);
        listaVagoni.setBorderPainted(false);

        lunghezzaTreno = new JButton("Lunghezza Treno");
        lunghezzaTreno.setFont(new Font("Sanserif", Font.BOLD, 15));
        lunghezzaTreno.addActionListener(new AscoltaLunghezzaTreno());
        lunghezzaTreno.setContentAreaFilled(false);
        lunghezzaTreno.setBorderPainted(false);

        pesoTreno = new JButton("Peso del treno");
        pesoTreno.setFont(new Font("Sanserif", Font.BOLD, 15));
        pesoTreno.addActionListener(new AscoltaPesoTreno());
        pesoTreno.setContentAreaFilled(false);
        pesoTreno.setBorderPainted(false);

        //Istanziazione per la stampa dei valori
        lunghezza = new JLabel();
        lunghezza.setFont(new Font("Sanserif", Font.BOLD, 15));
        peso = new JLabel();
        peso.setFont(new Font("Sanserif", Font.BOLD, 15));
        lista = new JTextArea();
        lista.setFont(new Font("Sanserif", Font.BOLD, 15));
        lista.setOpaque(false); //Sfondo della TextArea trasparente

        //Aggiungo al pannello tutti i bottoni
        pannelloBottoni.add(aggiungiVagoneMerci);
        pannelloBottoni.add(aggiungiVagonePasseggeri);
        pannelloBottoni.add(listaVagoni);
        pannelloBottoni.add(lunghezzaTreno);
        pannelloBottoni.add(pesoTreno);

        pannelloTitolo.add(titolo);

        pannelloValori.add(lunghezza);
        pannelloValori.add(lista);
        pannelloValori.add(peso);

        this.add(pannelloTitolo, BorderLayout.NORTH);
        this.add(pannelloTreno, BorderLayout.CENTER);
        this.add(pannelloBottoni, BorderLayout.EAST);
        this.add(pannelloValori, BorderLayout.SOUTH);
        this.setVisible(true);
        
        
    }

    class AscoltaAggiungiVagoneMerci implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ImageIcon icona = new ImageIcon("piko-vagone-merci-chiuso-fs-removebg-preview.png"); //Immagine treno merci
            Image immagine = icona.getImage();
            Image nuovaImmagine = immagine.getScaledInstance(250, 150,  java.awt.Image.SCALE_SMOOTH); //Ridimensiono l'immagine
            ImageIcon iconaRidimensionata = new ImageIcon(nuovaImmagine);
            JButton vagone = new JButton(iconaRidimensionata);

            //Rendo lo sfondo del bottone trasparente
            vagone.setContentAreaFilled(false);
            vagone.setBorderPainted(false);

            pannelloTreno.add(vagone);//Aggiungo il bottone (vagone) al pannello
            //Aggiornamento pannello
            pannelloTreno.revalidate(); //si occupa di ricalcolare il layout dei componenti
            pannelloTreno.repaint(); //si occupa di richiedere il ridisegno grafico dei componenti stessi

            VagoneMerci v = new VagoneMerci(); //Istanzio un nuovo vagone merci
            treno.aggiungiVagone(v);//Aggiungo il nuovo vagone al treno
            
        }
        
    }

    class AscoltaAggiungiVagonePasseggeri implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ImageIcon icona = new ImageIcon("roco-44227-carrozza-passeggeri-verde-storica-removebg-preview.png"); //Immagine treno passeggeri
            Image immagine = icona.getImage();
            Image nuovaImmagine = immagine.getScaledInstance(250, 150,  java.awt.Image.SCALE_SMOOTH);
            ImageIcon iconaRidimensionata = new ImageIcon(nuovaImmagine);
            JButton vagone = new JButton(iconaRidimensionata);

            vagone.setContentAreaFilled(false);
            vagone.setBorderPainted(false);

            pannelloTreno.add(vagone);
            pannelloTreno.revalidate();
            pannelloTreno.repaint();

            VagonePasseggeri v = new VagonePasseggeri();
            treno.aggiungiVagone(v);
        }
        
    }

    class AscoltaListaVagoni implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            lista.setText("Lista vagoni: \n" + treno.listaVagoni());
            //Ripulisco lunghezza e peso in modo da stampare solo la lista
            lunghezza.setText("");
            peso.setText("");
        }
    }

    class AscoltaLunghezzaTreno implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            lunghezza.setText("Lunghezza treno in cm: " + treno.lunghezzaTreno());
            lista.setText("");
            peso.setText("");
        }  
    }

    class AscoltaPesoTreno implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            peso.setText("Peso del treno in tonnellate: " + treno.pesoTreno());
            lista.setText("");
            lunghezza.setText("");
        }
        
    }

}
