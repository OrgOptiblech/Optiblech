import java.awt.Rectangle;
import java.util.Vector;

/** enthält alle Formen und die Hauptlogik bis auf das Zeichnen
 * 
 */
public class OptModel {
	
	public Vector<Rectangle> m_rectsToDraw;
	public int NO_RECTS_TO_DRAW = 3;
	
	public OptModel() {
		m_rectsToDraw = new Vector<Rectangle>(NO_RECTS_TO_DRAW);
		Rectangle r1 = new Rectangle(10, 10, 100, 100);
		Rectangle r2 = new Rectangle(30, 30, 100, 100);
		Rectangle r3 = new Rectangle(100, 200, 100, 100);
		m_rectsToDraw.add(r1);
		m_rectsToDraw.add(r2);
		m_rectsToDraw.add(r3);
	}
	
	
	
}
