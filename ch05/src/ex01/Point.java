package ex01;

public class Point { /* extends object */
	private int x;
	private int y;
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {
		//System.out.println("("+ x + ", "+ y +")");
		// f: format(형식)
		// %d: decimal(10진 정수)
		// %f: float(실수)
		// %s : string(문자열)
		System.out.printf("(%d, %d)\n", x, y);
	}
}
