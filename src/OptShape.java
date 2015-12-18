import java.awt.geom.Point2D;

public class OptShape extends VirtualShape {
	
	/** Konstruktor
	 * @param ANZAHL_POINTS gibt die Größe des PointArrays an
	 * @param pointArray referenz eines gültigen Pointarrays
	 */
	public OptShape(int ANZAHL_POINTS, Point2D.Double[] pointArray) {
		super(ANZAHL_POINTS, pointArray);
		
	}
}
