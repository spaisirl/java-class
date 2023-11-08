package ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryFastCopy {

	public static void main(String[] args) {
		File src = new File("C:/Temp/left.png");
		File desc = new File("C:/Temp/left2.png");
		try {
			FileInputStream input = new FileInputStream(src);
			FileOutputStream output = new FileOutputStream(desc);
			BufferedInputStream bInput = new BufferedInputStream(input);
			BufferedOutputStream bOutput = new BufferedOutputStream(output);
			long startTime = System.currentTimeMillis();
			//int i =0;
			while(true) {
				//int data = input.read();
				int data = bInput.read();
				if (data == -1) {
					break;
				}
				output.write(data);
				//System.out.println(++i);
			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			System.out.println("파일 복사 완료:" + (elapsedTime/1000.0)+"초 걸림");
			bInput.close();
			bOutput.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
