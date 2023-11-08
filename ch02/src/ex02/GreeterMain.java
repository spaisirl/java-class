package ex02;

public class GreeterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greeter g1 = new Greeter();
		g1.sayHello();
	}

	
	 
}

//객체지향적 프로그래밍 : 객체 간 인사를 한다고 생각
class Greeter {
	public void sayHello() {
		System.out.println("Hello");
	}
	
}
