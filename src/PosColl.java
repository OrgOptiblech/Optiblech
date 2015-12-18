import java.awt.geom.Point2D;
import java.util.Vector;

/** Liste der Positionen der Shapes
 * Position bedeutet: Translation und Rotation*/
public class PosColl {
	int m_ANZAHL_SHAPES;
	Vector<ShapePos> m_shapePos;
	
	public PosColl(int ANZAHL_SHAPES) {
		m_ANZAHL_SHAPES = ANZAHL_SHAPES;
		m_shapePos = new Vector<ShapePos>(ANZAHL_SHAPES);
		for (int i = 0; i < m_ANZAHL_SHAPES; i++) {
			ShapePos sp = new ShapePos();
			m_shapePos.addElement(sp);
		}
	}
	
	public void setShapePos(int index, ShapePos sp) {
		m_shapePos.set(index, sp);
	}
	
	public ShapePos getShapePos(int index) {
		return m_shapePos.elementAt(index);
	}
	
	public void setTransl(int index, Point2D.Double transl) {
		ShapePos sp = m_shapePos.elementAt(index);
		sp.setTransl(transl);
		m_shapePos.set(index, sp);
	}
	
	public Point2D.Double getTransl(int index) {
		return m_shapePos.elementAt(index).getTransl();
	}
	
	public void setRot(int index, double rot) {
		ShapePos sp = m_shapePos.elementAt(index);
		sp.setRot(rot);
		m_shapePos.set(index, sp);
	}
	
	public double getRot(int index) {
		return m_shapePos.elementAt(index).getRot();
	}
	
}
