package ex02;

//extends: 확장하다(상속받는다)
// 상위클래스에 정의된 모든 것을 다 가져온다.
public class ColorPoint extends Point{
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		//this 앞에 super(); 가 생략된 것이다.
		super(x,y);
		
		this.color = color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint() {
		System.out.print(color);
		showPoint();
	}
}
