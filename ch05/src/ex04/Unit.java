package ex04;

public abstract class Unit {
	
	private int x, y; // 현재 위치
	private String name;

	
	public Unit(String name) {
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void move (int x, int y) {
		System.out.printf("%s이(가) (%d, %d)으로 이동합니다.\n", 
				name, x, y);
		
		this.x = x;
		this.y = y;
		
	}
	
	
	public abstract void attack(int x, int y);

	public void showPosition() {
		System.out.printf("%s이(가) (%d,%d)에 있습니다.\n", 
				name, x, y);
		
	}
	
	

}
