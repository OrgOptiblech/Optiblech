import java.util.Vector;

public class ShapeColl {
	int m_ANZAHL_SHAPES;
	Vector<OptShape> m_shapes;
	
	public ShapeColl(int ANZAHL_SHAPES) {
		m_ANZAHL_SHAPES = ANZAHL_SHAPES;
		m_shapes = new Vector<OptShape>(ANZAHL_SHAPES);
		
	}
	
	public void addShape(OptShape os) {
		m_shapes.add(os);
	}
	
	public OptShape getElement(int index) {
		return m_shapes.elementAt(index);
	}
}
