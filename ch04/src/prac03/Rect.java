package prac03;

public class Rect {

	private int width;
	private int height;
	
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getArea() {
		int area = width* height;
		return area;
	}
}
