package ver01;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneInfo info1 = new PhoneInfo("한현수", "010-1111-1111");
		PhoneInfo info2 = new PhoneInfo("김동영", "010-2222-2222", "2000.01.01");
		
		/*
		info1.showInfo();
		info2.showInfo();
		*/
		
		
		PhoneInfo[] infos = {info1, info2}; // 객체배열
		
		//객체 스와핑
		PhoneInfo temp = infos[0];
		infos[0] = infos[1];
		infos[1] = temp;
		
		// for (int i =0; i<infos.length;i++)
		for (PhoneInfo aInfo : infos) {
			aInfo.showInfo(); // PhoneInfo aInfo = info1;
		}
	}

}
