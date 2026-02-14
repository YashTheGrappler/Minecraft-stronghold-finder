package learning;

import java.io.*;

class Line implements Serializable{
	private double k;
	private double b;
	private boolean isVertical; 
    private int verticalX; 
  
    Line(Point p1, Point p2){
    	if(p1.getX() > p2.getX()) {
    		Point temp = p1;
    		p1 = p2;
    		p2 = temp;
    	}
    	double x1 = p1.getX();
        double deltaX = p2.getX() - x1;
        if(deltaX == 0) {
        	this.k = Double.POSITIVE_INFINITY;
        	this.b = Double.NaN;
        	this.isVertical = true;
        	this.verticalX = (int)x1;
        }else {
        	double y1 = p1.getY();
        	double deltaY = p2.getY() - y1;
        	this.k = deltaY / deltaX;  
            this.b = y1 - this.k * x1;
            this.isVertical = false;
            this.verticalX = 0;
        }
    }
    
    Line(Point p, double rads) {
    	this(p, new Point(p.getX() + Math.cos(rads), p.getY() + Math.sin(rads)));
    }
  
    Line(){}
  
    boolean isPointOnLine(Point p) {
    	return this.isVertical? this.verticalX == p.getX(): this.k*p.getX() + b == p.getY();
    }
    
    Point findIntersection(Line line) throws IOException{
    	if(this.equals(line)) {
    		throw new IOException("Illegal input");
    	}
    	if(this.isVertical) {
    		if(line.isVertical) {
    			throw new IOException("No intersection");
    		}else {
    			return new Point(this.verticalX, line.k * this.verticalX + line.b);
    		}
    	}else {
    		if(line.isVertical) {
        		return new Point(line.verticalX, this.k * line.verticalX + this.b);
    		}else {
    			if(this.k == line.k) {
    				throw new IOException("No intersection");
        		}else {
        			double x = (line.b - this.b)/(this.k - line.k);
                	return new Point(x, this.k * x + this.b);
        		}
    		}
    	}
    }						
    
    public double getK() {
    	return this.k;
    }
  
    public double getB() {
    	return this.b;
    }
    
    public String toString() {
    	if(isVertical) {
    		return "Vertical line x - " + verticalX;
    	}else {
    		return "Line - " + this.k + "*x + " + this.b;
    	}
    }	
    	
    public boolean equals(Object o) {
    	return isVertical? this.verticalX == ((Line)o).verticalX : this.k == ((Line)o).k && this.b == ((Line)o).b;
    }
  
    public int hashCode() {
    	return isVertical? Integer.hashCode(this.verticalX): Double.hashCode(this.k) * 31 + Double.hashCode(this.b);
    }
}