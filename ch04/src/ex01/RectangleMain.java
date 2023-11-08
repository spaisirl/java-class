package ex01;

import java.util.InputMismatchException; // ctrl+shift+o
import java.util.Scanner;

public class RectangleMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Rectangle c2 = new Rectangle();
		try {
			System.out.println("면적을 구해봅시다.");
			System.out.print("너비: ");
			c2.width = scanner.nextInt();
			System.out.print("높이: ");
			c2.height = scanner.nextInt();
			int area = c2.getArea();
			System.out.print("면적: " + area);
			
		} catch (InputMismatchException e) {
			System.out.println("너비와 높이는 정수값을 입력해주세요.");
		}
		
		scanner.close();
	}	

}
