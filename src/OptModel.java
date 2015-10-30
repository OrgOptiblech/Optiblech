import java.awt.Color;
import java.awt.Graphics2D;

/** enthält alle Formen und die Hauptlogik
 * 
 */
public class OptModel {
	
	boolean isForm1 = false;
	
	/** Haupt-Zeichnen-Funktion */
	public void zeichnen(Graphics2D g2) {
		if(isForm1) {
			g2.setColor(Color.blue);
			g2.drawRect(10, 10, 100, 100);
		} else {
			g2.setColor(Color.red);
			g2.drawRect(100, 100, 100, 100);
		}
	}
	
	
	
}
