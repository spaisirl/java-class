package ex03;

import java.io.File;
import java.util.Calendar;

public class FileClassExample {

	public static void main(String[] args) {
		String fileName = "C:/Windows/system.ini";
		//파일 객체 생성 (파일을 생성하는 것이 아님)
		File f = new File(fileName);
		System.out.println(f);
		System.out.println(f.exists());
		System.out.println(f.getName());
		System.out.println(f.getPath());
		System.out.println(f.getParent());
		System.out.println(f.length());
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		System.out.println(f.lastModified());
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(f.lastModified());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String strDate = year + "-" + month + "-" + date + " ";
		strDate += hour + ":" + minute + ":" + second;
		System.out.println(strDate);
		
		File f2 = new File("C:/Temp/mydir");
		if (!f2.exists()) {
			boolean b = f2.mkdir();
			if (b) {
				System.out.println("폴더 생성 성공");
				
			} else {
				System.out.println("폴더 생성 실패");
			}
		}
		
		File f3 = new File("C:/Temp/yourdir/hisdir/heridr");
		f3.mkdirs();
		
		File f4 = new File("C:/Temp");
		String[] list = f4.list();
		for (String str : list) {
			System.out.println("str: " + str);
		}
		File[] files = f4.listFiles();
		for (File aFile : files) {
			System.out.println(aFile.getName() + ":" + aFile.length() + "bytes");
			if (aFile.getName().equals("test.out")) {
				aFile.renameTo(new File("C:/Temp/test2.out"));
			}
			System.out.println("파일 이름 변경 완료");
		}
		
		File f5 = new File("C:/Temp/target.txt");
		if(f5.exists()) {
			boolean b = f5.delete();
			if (b) {
				System.out.println("파일 삭제 완료");
			}
		}
	}

}
