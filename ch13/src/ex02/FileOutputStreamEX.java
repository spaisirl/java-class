package ex02;

import java.io.FileOutputStream;

public class FileOutputStreamEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] data = {0,1,2,3,4};
		try {
			FileOutputStream output = new FileOutputStream("C:/temp/test.out");
			output.write(data);
			output.close();
			System.out.println("파일 쓰기 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
