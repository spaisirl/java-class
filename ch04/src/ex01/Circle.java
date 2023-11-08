package ex01;

public class Circle {
	// 멤버 필드 (데이터)
	public int radius;
	public String name;
	
	//생성자
	public Circle() {}
	
	public Circle(int r, String n) { //필드 생성자
		radius = r;
		name = n;
	}
	
	// 멤버 메서드 (기능)
	public double getArea() {
		double area = radius*radius*Math.PI;
		return area;

	}
	
}
