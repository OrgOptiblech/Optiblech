import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;


/** verantwortliche Klasse f�r die Darstellung */
public class OptView extends JFrame {
	
	/** Shapes L�schen*/
	JButton bn_clear;
	
	/** Test: Shape1 nach rechts verschieben*/
	JButton bn_nachRechtsVersch;
	
	/** Test: Shape2 nach unten verschieben*/
	JButton bn_nachUntenVersch;
	
	
	
	/** Schalter um die Darstellung der Shapes an- und abzuschalten*/
	boolean shapesVisible = true;                                    // �nderung von Torsten Kropp am 20.12.2015
	
	/** Zeichenflaechenklasse
	 * muss die Funktion paintComponent �berschreiben 
	 * h�lt einen Zeiger auf die Graphics2D Zeichenflaeche*/
	class Zeichenflaeche extends JLabel {
		@Override protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g; //aus Kompatibilit�tsgr�nden
			render(g2); //private zeichenfunktion
			}
	}
	
	/** Die eigentliche Fl�che, auf der die Shapes gezeichnet werden */
	Zeichenflaeche m_zeichenflaeche;
	
	/** Referenz auf das Model
	 * welches die zentrale Logik enth�lt */
	OptModel m_model;
	
	/** Anzeige des Umfangs */
	JLabel lb_umfang;
	
	/**Konstruktor 
	 * Titel und Referenz auf das Model �bergeben*/
	public OptView(String title, OptModel optModel) {
		super(title);
		setLayout(null);
		setBounds(10, 10, 1000, 600);
		m_model = optModel;
		initWindow();
	}
	
	/** Initialisierung des Hauptfensters */
	void initWindow() {
		bn_clear = new JButton("Draw Shapes");
		bn_clear.setBounds(10, 10, 150, 20);
		
		//Test
		bn_nachRechtsVersch = new JButton("Shape1 nach rechts");
		bn_nachRechtsVersch.setBounds(10, 300, 150, 20); 
		
		bn_nachUntenVersch = new JButton("Shape2 nach unten");
		bn_nachUntenVersch.setBounds(10, 350, 150, 20); 
		
		
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
					shapesVisible = false;                           // �nderung von Torsten Kropp am 20.12.2015
					bn_clear.setText("Clear");
				}
				m_zeichenflaeche.repaint();
			}
		});
		
		bn_nachRechtsVersch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				m_model.Shape1NachRechts();
				m_zeichenflaeche.repaint();
			}
		});
			
		bn_nachUntenVersch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				m_model.Shape2NachUnten();
				m_zeichenflaeche.repaint();
			}
		});
		
		
		
		lb_umfang = new JLabel();
		lb_umfang.setBounds(10, 100, 150, 60);
		lb_umfang.setOpaque(true);
		lb_umfang.setBackground(Color.WHITE);
		//Umf�nge in String
		String str = "<html>Umfang 1 = ";
		str = str.concat(String.valueOf(m_model.m_shapeColl.getElement(0).m_umfang));
		str = str.concat("<br>Umfang 2 = ");
		str = str.concat(String.valueOf(m_model.m_shapeColl.getElement(1).m_umfang));
		str = str.concat("</html>");
		lb_umfang.setText(str);
		
		//Dem Fensterbereich hinzuf�gen
		getContentPane().add(bn_clear);
		getContentPane().add(bn_nachRechtsVersch);
		getContentPane().add(bn_nachUntenVersch);
		getContentPane().add(m_zeichenflaeche);
		getContentPane().add(lb_umfang);
	}
	
	/** Haupt-Render-Funktion 
	 * durchl�uft die Formen (sp�ter mit ihren Transformationen, in OptModel enthalten),
	 *  die auf der Zeichenflaeche gezeichnet werden sollen. */
	void render(Graphics2D g2) {
		if(shapesVisible) {
			for (int i = 0; i < m_model.m_shapeColl.m_ANZAHL_SHAPES; i++) {
				
				//Transformation sichern
				AffineTransform saveTransform = g2.getTransform();
			    
				// Transformation zur�cksetzen
			    AffineTransform identity = new AffineTransform();
			    g2.setTransform(identity);
			 	
			    //entsprechende Koordinatentranformation anhand Position erzeugen 
				AffineTransform at = new AffineTransform();
				at.setToIdentity();
				at.translate(m_model.m_posColl.getTransl(i).getX(),
							m_model.m_posColl.getTransl(i).getY());
				at.rotate(m_model.m_posColl.getRot(i));
			    g2.transform(at); 
				
				int ANZAHL_POINTS = m_model.m_shapeColl.m_shapes.elementAt(i).m_ANZAHL_POINTS;
				for(int k = 1; k < ANZAHL_POINTS; k++) {
					g2.draw(new Line2D.Double(m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(k-1).getX(), 
											  m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(k-1).getY(),
											  m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(k).getX(),
											  m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(k).getY()));
				}
				//letzte Linie: Endpunkt zum Anfangspunkt
				g2.draw(new Line2D.Double(m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(0).getX(), 
						  m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(0).getY(),
						  m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(ANZAHL_POINTS-1).getX(),
						  m_model.m_shapeColl.m_shapes.elementAt(i).getPoint(ANZAHL_POINTS-1).getY()));
				
				//Koordinatentransformation zur�cksetzen
				g2.transform(saveTransform);
			}
			
		}
		
	}
}
