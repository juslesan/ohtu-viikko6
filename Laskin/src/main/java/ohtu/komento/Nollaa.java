package ohtu.komento;

import javax.swing.JTextField;
import ohtu.Sovelluslogiikka;

/**
 *
 * @author eekuurne
 */
public class Nollaa implements Komento {

    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    int edellinen;

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }
    
    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        sovellus.nollaa();
        
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
