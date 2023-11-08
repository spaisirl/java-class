package ver07;


public class PhoneBook {
		
		/*
	 	다운캐스팅은 if문을 사용해야 한다.
	 	if (생1 instanceof 고양이) {
	 		고양이 고2 = (고양이)생1; // o 다운캐스팅 (상위타입을 하위타입으로 변환)
	 		}
		*/
	
		private PhoneInfo[] storage = new PhoneInfo[10];
		private int index = 0;
		
		public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
			storage[index] = info;
			index++;
		}
		
		/*
		public void showAll() {
			for (int i = 0; i < index; i++) {
				storage[i].showInfo();
			}
		}
		*/
		
		public void showAll() {
			for (int i = 0; i < index; i++) {
				if (storage[i] instanceof PhoneInfoSchool) {
					PhoneInfoSchool infoSchool = (PhoneInfoSchool)storage[i];
					infoSchool.showInfoSchool();
				} else if (storage[i] instanceof PhoneInfoCompany) {
					PhoneInfoCompany infoCompany = (PhoneInfoCompany)storage[i];
					infoCompany.showInfoCompany();
				}
				
			}
		}
		
		//이름으로 검색하기
		public void searchByName(String searchName) {
			for(int i = 0; i < index; i++) {
				PhoneInfo info = storage[i];
				String name = info.getName(); 
				/*이름을 불려오고 싶은데 String name은 이미 클래스에서 
				 	사용 중이라 PhoneInfo에서 getName을 작성하여 불려오기*/ 
				if (searchName.equals(name)) {
					if (info instanceof PhoneInfoSchool) { //다운캐스팅
						PhoneInfoSchool pis = (PhoneInfoSchool)info; 
						pis.showInfoSchool(); //인적사항 정보 불려오기
						
					} else if (info instanceof PhoneInfoCompany) {
						PhoneInfoCompany pic = (PhoneInfoCompany)info;
						pic.showInfoCompany();
					}
					
					return; // 아래의 문장을 실행하지 않고 끝내기
					// break; 를 쓰게 되면 이름을 못 찾아도 반복문을 실행해서
					
				} 
				
			}
			
			System.out.println(searchName + "을(를) 찾지 못하였습니다.");
		}
		
		//이름 중복 확인
		public boolean isNameDup(String searchName) {
			for (int i = 0; i <index; i++) {
				PhoneInfo info = storage[i];
				String name = info.getName();
				if(name.equals(searchName)) {
					return true;
				}
			}
			
			return false;
		}
		
		
		
}
