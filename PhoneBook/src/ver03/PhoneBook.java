package ver03;

public class PhoneBook {
	public PhoneInfo[] storage = new PhoneInfo[10]; // 10번 들어 갈 공간이 있다는 뜻. for문으로 10번까지 반복하는 것과는 다른 의미.
	public int index = 0;
	
	public void addInfo(PhoneInfo info) {
		storage[index] = info;
		index++;
	}
	
	public void showAll() {

		for(int i = 0; i<index; i++) {
			storage[i].showInfo();
		}
		
	}
}
