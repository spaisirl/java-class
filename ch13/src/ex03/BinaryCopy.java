package ex03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopy {

	public static void main(String[] args) {
		File src = new File("C:/Temp/eclipse.zip");
		File desc = new File("C:/Temp/eclipse2.zip");
		try {
			FileInputStream input = new FileInputStream(src);
			FileOutputStream output = new FileOutputStream(desc);
			long startTime = System.currentTimeMillis();
			int i =0;
			while(true) {
				int data = input.read();
				if (data == -1) {
					break;
				}
				output.write(data);
				System.out.println(++i);
			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			System.out.println("파일 복사 완료:" + (elapsedTime/1000.0)+"초 걸림");
			input.close();
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
