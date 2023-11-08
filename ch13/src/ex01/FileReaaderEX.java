package ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaaderEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String fileName="C:\\windows\\system.ini";
		String fileName="C:/temp/number.txt";
		// 스트림을 개설(빨대를 꽂는다.)
		try {
			
			FileReader reader= new FileReader(fileName);
			while (true) {
			int data = reader.read();
			//System.out.println(data);
			if (data == -1) { // EOF (End of File)
				break;
			}
//			System.out.print((char)data);
			System.out.print(data + " ");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중에 문제가 발생했습니다.");
		}
	}

}
