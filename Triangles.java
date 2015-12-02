import static java.lang.System.*;
import static java.lang.Math.*;
import java.text.*;

class Point{

	private double x,y;

	Point(double x, double y){
		this.x=x;
		this.y=y;
	}

	public double getX(){ return x;}

	public double getY(){ return y;}

}

public class Triangles{

	public static void type(Point a, Point b, Point c){

		StringBuilder triangle = new StringBuilder();

		//Length sides: Pythagoream triangles
		double l1 = getLength(a, b);
		double l2 = getLength(b, c);
		double l3 = getLength(a, c);

		if(l1==l2 && l1==l3) triangle.append("Equilateral");
		else if(l1!=l2 && l1!=l3 && l2!=l3) triangle.append("Scalene");
		else triangle.append("Isosceles");

		//Angles: Law of cosines, generalization of Pythagoream theorem for right triangles
		double a1 = getAngle(l1,l2,l3);
		double a2 = getAngle(l1,l3,l2);
		double a3 = getAngle(l2,l3,l1);

		
		if(a1==90 || a2==90 || a3==90) triangle.append("-Rigth");
		else if(a1>90 || a2>90 || a3>90) triangle.append("-Obtuse");
		else triangle.append("-Acute");

		out.println(triangle);		
		

	}

	private static double getLength(Point a, Point b){
		return sqrt(pow(a.getX()-b.getX(),2)+pow(a.getY()-b.getY(),2));
	}

	private static double getAngle(double l1, double l2, double l3){
		double aux = rad2degree(acos((pow(l1,2)+pow(l2,2)-pow(l3,2))/(2*l1*l2)));
		DecimalFormat num = new DecimalFormat("###,###");
		String s = num.format(aux);
		return Double.parseDouble(s);
	}

	private static double rad2degree(double rad){
		return rad*360/(2*PI);
	}

	public static void main(String[] args){
		type(new Point(0,0), new Point(1,0.5), new Point(1,1));
	}

}
