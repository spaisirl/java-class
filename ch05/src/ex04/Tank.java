package ex04;

public class Tank extends Unit {
	

	public Tank(String name) {
		super(name);
	}

	@Override
	public void attack(int x, int y) {
		System.out.printf("%s이(가) (%d, %d)를 대포로 공격합니다.\n",
				getName(), x, y);
	}
	
}
