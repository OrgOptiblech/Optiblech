
/** enthält alle Formen und die Hauptlogik bis auf das Zeichnen */
public class OptModel {
	
	/** Liste der Shapes*/
	public ShapeColl m_shapeColl;
	
	/** Liste der Matrizen (Koordinatentransformationen) */
	public PosColl m_posColl;
		
	public OptModel(ShapeColl shapeColl, PosColl posColl) {
		m_shapeColl = shapeColl;
		m_posColl = posColl;
	}
	
	//Test
	public void Shape1NachRechts() {
		m_posColl.getTransl(0).x += 10;
	}
	
	public void Shape2NachUnten() {
		m_posColl.getTransl(1).y += 10;
	}
	
	
}
