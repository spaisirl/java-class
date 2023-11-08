package ex01;

public class RandomEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * for(int count=1;count<=10;count++) {
		 * double x = Math.random();
		 * 
		 * x=i*10
		 * x=i+1
		 * System.out.println((int)n)
		 * }
		 */
		
		
		double n = (int)(Math.random()*500)+501;
		double m = (int)(Math.random()*13)+1;
		
		// int(Math.random()* 갯수) +시작값
		
		System.out.println((int)n);
		System.out.println((int)m);
		
		
	}

}
