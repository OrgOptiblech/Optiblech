import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Vector;

/** enthält alle Formen und die Hauptlogik bis auf das Zeichnen
 * 
 */
public class OptModel {
	
	public Vector<Rectangle> m_rects;
	public int ANZAHL_FORMEN = 3;
	
	public OptModel() {
		m_rects = new Vector<Rectangle>(ANZAHL_FORMEN);
		Rectangle r1 = new Rectangle(10, 10, 100, 100);
		Rectangle r2 = new Rectangle(30, 30, 100, 100);
		Rectangle r3 = new Rectangle(100, 200, 100, 100);
		m_rects.add(r1);
		m_rects.add(r2);
		m_rects.add(r3);
	}
	
	/** Haupt-Zeichnen-Funktion */
	public void zeichnen(Graphics2D g2) {
		
	}
	
	
	
}
