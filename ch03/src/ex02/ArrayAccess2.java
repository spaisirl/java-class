package ex02;

public class ArrayAccess2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int intArray[] = {3, 5, 7, 9, 1};
			
		for (int x=1;x<intArray.length;x++) {
				if(intArray[0] > intArray[x]) {
					int temp = intArray[0];
					intArray[0] = intArray[x];
					intArray[x] = temp;
					
				}
				
			
				if (intArray[1] > intArray[x]) {
					int temp = intArray[1];
					intArray[1] = intArray[x];
					intArray[x] = temp;
					
				}
			
				
				if (intArray[2] > intArray[x]) {
					int temp = intArray[2];
					intArray[2] = intArray[x];
					intArray[x] = temp;
					
				}
				
				
				if (intArray[3] > intArray[x]) {
					int temp = intArray[3];
					intArray[3] = intArray[x];
					intArray[x] = temp;
	
				}
				
				
				if (intArray[4] > intArray[x]) {
					int temp = intArray[4];
					intArray[4] = intArray[x];
					intArray[x] = temp;
					
				}
							
				System.out.println();
				
				for (int i = 0; i<intArray.length;i++) {
				}
					
			}
	
			for (int v : intArray) {
			System.out.print(v + "");
			}										
			
		}	
}
