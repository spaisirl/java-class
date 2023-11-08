package ver02;

public class PhoneBookMain {

	public static void main(String[] args) {
		
		PhoneBook book = new PhoneBook();
		
		PhoneInfo info1 = new PhoneInfo("한현수", "010-1111-1111");
		book.addInfo(info1);
		PhoneInfo info2 = new PhoneInfo("김동영", "010-2222-2222", "2000.01.01");
		book.addInfo(info2);
		
		book.showAll();
		
	}

}
