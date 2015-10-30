import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

/** verantwortliche Klasse für die Darstellung */
public class OptView extends JFrame {
	
	/** Ein Testbutton */
	JButton bn_test;
	
	/** Zeichenflaechenklasse
	 * muss die Funktion paintComponent überschreiben */
	class Zeichenflaeche extends JLabel {
		@Override protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g; //aus Kompatibilitätsgründen
			zeichnen(g2); //private zeichenfunktion
		}
	}
	
	Zeichenflaeche m_zeichenflaeche;
	
	//Konstruktor
	public OptView(String title) {
		super(title);
		setLayout(null);
		setBounds(10, 10, 1000, 600);
		initWindow();
	}
	
	//Fensterinitialisierung Hilfsfunktion
	void initWindow() {
		bn_test = new JButton("Test");
		bn_test.setBounds(10, 10, 100, 20);
		
		m_zeichenflaeche = new Zeichenflaeche();
		m_zeichenflaeche.setBounds(200, 100, 800, 600);
		m_zeichenflaeche.setOpaque(true);//undurchsichtig
		m_zeichenflaeche.setBackground(Color.WHITE);
		
		//Dem Fensterbereich hinzufügen
		getContentPane().add(bn_test);
		getContentPane().add(m_zeichenflaeche);
	}
	
	void zeichnen(Graphics2D g2) {
		
	}
}
