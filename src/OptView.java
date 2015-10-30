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
	
	/** Shapes Löschen*/
	JButton bn_clear;
	
	/** Schalter um die Darstellung der Shapes an- und abzuschalten*/
	boolean shapesVisible = true;
	
	/** Zeichenflaechenklasse
	 * muss die Funktion paintComponent überschreiben 
	 * hält einen Zeiger auf die Graphics2D Zeichenflaeche*/
	class Zeichenflaeche extends JLabel {
		@Override protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g; //aus Kompatibilitätsgründen
			render(g2); //private zeichenfunktion
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
	
	/** Initialisierung des Hauptfensters */
	void initWindow() {
		bn_clear = new JButton("Clear");
		bn_clear.setBounds(10, 10, 150, 20);
		
		m_zeichenflaeche = new Zeichenflaeche();
		m_zeichenflaeche.setBounds(200, 100, 800, 600);
		m_zeichenflaeche.setOpaque(true);//undurchsichtig
		m_zeichenflaeche.setBackground(Color.WHITE);
		
		
		bn_clear.addActionListener(new ActionListener()
		{//anonyme Klasse
			public void actionPerformed(ActionEvent e)
			{
				if(shapesVisible) {
					shapesVisible = false;
					bn_clear.setText("Draw Shapes");
				} else {
					shapesVisible = true;
					bn_clear.setText("Clear");
				}
				m_zeichenflaeche.repaint();
			}
		});
		
		//Dem Fensterbereich hinzufügen
		getContentPane().add(bn_clear);
		getContentPane().add(m_zeichenflaeche);
	}
	
	/** Haupt-Render-Funktion 
	 * durchläuft die Formen (mit ihren Transformationen, in OptModel enthalten),
	 *  die auf der Zeichenflaeche gezeichnet werden sollen. 
	 */
	void render(Graphics2D g2) {
		if(shapesVisible) {
			for (int i = 0; i < m_model.NO_RECTS_TO_DRAW; i++) {
				g2.draw(m_model.m_rectsToDraw.elementAt(i));
			}
		}
		
	}
}
