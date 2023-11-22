package ex01;

interface MyFunction {
	int calc(int x, int y);
}

public class LambdaEx1 {

	public static void main(String[] args) {
		MyFunction add = (x, y) -> {
			return x + y;
		};

		int result1 = add.calc(1, 2);
		System.out.println("result1" + result1);
	}

}
