import java.awt.geom.Point2D;

/** beschreibt die Position eines Shape in Form eines Translationsvektors und eines Rotationswinkels*/
public class ShapePos {
	
	/** 2-D  Translationsvektor 
	 * Verschiebung des Shape vom Ursprung */
	Point2D.Double m_transl;
	
	/** Rotationszustand des Shape in Radiant*/
	double m_rot; 

	public ShapePos() {
		m_transl = new Point2D.Double();
		m_rot = 0.0;
	}
	
	public Point2D.Double getTransl() {
		return m_transl;
	}
	
	public void setTransl(Point2D.Double transl) {
		m_transl = transl;
	}
	
	public double getRot() {
		return m_rot;
	}
	
	public void setRot(double rot) {
		m_rot = rot;
	}
}
