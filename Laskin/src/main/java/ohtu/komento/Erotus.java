package ohtu.komento;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author eekuurne
 */
public class Erotus implements Komento {

    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    int edellinen;

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }
    
    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        int arvo = 0;
        
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        sovellus.miinus(arvo);
        
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + edellinen);
        sovellus.setTulos(edellinen);
    }
}
