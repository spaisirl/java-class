package ver06;


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
				// storage[i].showInfo();
			}
		}
		
}
