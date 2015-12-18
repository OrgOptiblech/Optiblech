import java.awt.geom.Point2D;

public class OptApp {
		
	static OptModel m_optModel;
	
	public static void main(String[] args) {
		datenErzeugen();
		OptView opt = new OptView("Optiblech", m_optModel);
		opt.setVisible(true);

	}

	static void datenErzeugen() {
		//Wieviele Shapes überhaupt?
		int ANZAHL_SHAPES = 2;
		
		//ShapeColl für diese Anzahl erzeugen
		ShapeColl sc = new ShapeColl(ANZAHL_SHAPES);
		
		//Position Collection (die selbe Anzahl) erzeugen
		PosColl pc = new PosColl(ANZAHL_SHAPES);
				
		//Für jedes Shape
		//Erst OptPoints erzeugen
		int ANZAHL1 = 3;
		Point2D.Double[] ar1 = new Point2D.Double[ANZAHL1];
		for (int i = 0; i < ANZAHL1; i++) {
			ar1[i] = new Point2D.Double();
		}
		//dann einlesen 
		//in Modellkoordinaten  
		ar1[0].x = 0; ar1[0].y = 0;
		ar1[1].x = 50; ar1[1].y = 50;
		ar1[2].x = 50; ar1[2].y = 0;
		
		//Shape2
		int ANZAHL2 = 5;
		Point2D.Double[] ar2 = new Point2D.Double[ANZAHL2];
		for (int i = 0; i < ANZAHL2; i++) {
			ar2[i] = new Point2D.Double();
		}
		//Modellkoordinaten
		ar2[0].x = 0; ar2[0].y = 0;
		ar2[1].x = 50; ar2[1].y= 0;
		ar2[2].x = 100; ar2[2].y = 50;
		ar2[3].x= 200; ar2[3].y= 100;
		ar2[4].x= 50; ar2[4].y= 50;
		
		//OptShapes erzeugen
		OptShape os1 = new OptShape(ANZAHL1, ar1);
		OptShape os2 = new OptShape(ANZAHL2, ar2);
		
		//OptShapes in Collection
		sc.addShape(os1);
		sc.addShape(os2);
		
		//OptModel erzeugen
		m_optModel = new OptModel(sc, pc);
	}
}

