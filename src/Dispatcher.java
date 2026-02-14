package learning;

import java.util.*;

public class Dispatcher {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double y1 = Controller.readDoubleInput(scanner, "Enter first point\nx - ");
		double x1 = Controller.readDoubleInput(scanner, "z - ");
		double rads1 = Controller.readYaw(scanner);
		double y2 = Controller.readDoubleInput(scanner, "Enter second point\nx - ");
		double x2 = Controller.readDoubleInput(scanner, "z - ");
		double rads2 = Controller.readYaw(scanner);
		try {
			Point stronghold = (new Line(new Point(x1, y1), rads1)).findIntersection(new Line(new Point(x2, y2), rads2));
			System.out.println("XYZ : [" + (int)stronghold.getY() + ", ~, " + (int)stronghold.getX() + "]");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Controller.waitForQuit(scanner);
	}

}
