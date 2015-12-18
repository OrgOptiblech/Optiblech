import java.awt.geom.Point2D;

/**Abstrakte Shape Klasse */
public abstract class VirtualShape {
	
	double m_umfang;
	double m_flaeche;
	int m_ANZAHL_POINTS;
	
	Point2D.Double[] m_pointArray;
	
	public VirtualShape(int ANZAHL_POINTS, Point2D.Double[] pointArray) {
		m_ANZAHL_POINTS = ANZAHL_POINTS;
		m_pointArray = pointArray;
		berechneUmfang();
	}
	
	public Point2D.Double getPoint(int index) {
		return m_pointArray[index];
	}
	
	public double getUmfang() {
		return m_umfang;
	}
	
	public double getFlaeche() {
		return m_flaeche;
	}
	
	
	/**Addiert die Differenzstrecken zwischen den Punkten
	 * @return Umfang des Shapes	 */
	void berechneUmfang() {
		for (int i = 1; i < m_ANZAHL_POINTS; i++) {
			m_umfang += m_pointArray[i].distance(m_pointArray[i-1]);		
		}
	}
	
	void berechneFlaeche() {
		//muss noch implementiert werden
	}
}
