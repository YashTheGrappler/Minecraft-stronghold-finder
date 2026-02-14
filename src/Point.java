package learning;

import java.io.*;

class Point implements Serializable{
	private double x;
	private double y;
  
	Point(double x, double y){
		this.x = x;
		this.y = y;
	}
  
	Point(){}
  
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public String toString() {
		return "Point (" + this.x + ", " + this.y + ")";
	}
  
	public boolean equals(Object o) {
		return this.x == ((Point)o).x && this.y == ((Point)o).y;
	}
  
	public int hashCode() {
		return Double.hashCode(x) * 31 + Double.hashCode(y);
	}
}