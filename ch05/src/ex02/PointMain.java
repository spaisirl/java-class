package ex02;

/* 
업캐스팅
class Car {

	void drive() {.............}

}

class Truck extends Car {

	void load
	{
	}

}

class HybridCar extends Car {

	void driveOnWater() {
	}

}

	Truck is-a Car.

Car c1 = new Car();
	Truck t1 = new Truck();
	Car c2 = new Truck(); // o - up- casting(하위타입의 객체를 상위타입으로 바라보기) (형변환)
	Truck t1 = new Car(); // x
	Car c1 = new HybridCar(); // o
	Truck t1 = new HybridCar(); // x

	Car c1 = new Truck(); // o
	Truck t1 = (Truck) c1; // down-casting

Car[] cars = {c1, c2, c3}
Car[] cars2 = {new Truck(), new Truck(), new HybridCar() }

	for(Car car:cars2)
*/

/*
 다운캐스팅은 if문을 사용해야 한다.
 if (생1 instanceof 고양이) {
 	고양이 고2 = (고양이)생1; // o 다운캐스팅(상위타입을 하위타입으로 변환)
 }
*/
 


public class PointMain {

	public static void main(String[] args) {
		
		ColorPoint cp = new ColorPoint(3,4, "RED");
		cp.showColorPoint();
		
	}

}
