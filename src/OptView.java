import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** verantwortliche Klasse für die Darstellung */
public class OptView extends JFrame {
	
	/** Ein Testbutton */
	JButton bn_test;
	
	/** Zeichenflaechenklasse
	 * muss die Funktion paintComponent überschreiben 
	 * hält einen Zeiger auf die Graphics2D Zeichenflaeche*/
	class Zeichenflaeche extends JLabel {
		Graphics2D m_g2;
		
		@Override protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			m_g2 = (Graphics2D)g; //aus Kompatibilitätsgründen
			zeichnen(m_g2); //private zeichenfunktion
		}
	}
	
	Zeichenflaeche m_zeichenflaeche;
	
	OptModel m_model;
	
	//Konstruktor
	public OptView(String title) {
		super(title);
		setLayout(null);
		setBounds(10, 10, 1000, 600);
		m_model = new OptModel();
		initWindow();
	}
	
	//Fensterinitialisierung Hilfsfunktion
	void initWindow() {
		bn_test = new JButton("Klick mich");
		bn_test.setBounds(10, 10, 100, 20);
		
		m_zeichenflaeche = new Zeichenflaeche();
		m_zeichenflaeche.setBounds(200, 100, 800, 600);
		m_zeichenflaeche.setOpaque(true);//undurchsichtig
		m_zeichenflaeche.setBackground(Color.WHITE);
		
		
		bn_test.addActionListener(new ActionListener()
		{//anonyme Klasse
			public void actionPerformed(ActionEvent e)
			{
				//Hier die Aktion: z.B. 
				m_model.isForm1 = true;
				m_zeichenflaeche.repaint();
			}
		});
		
		//Dem Fensterbereich hinzufügen
		getContentPane().add(bn_test);
		getContentPane().add(m_zeichenflaeche);
	}
	
	/** Wrapper: weiterrleiten an OptModel */
	void zeichnen(Graphics2D g2) {
		m_model.zeichnen(g2);
	}
}
