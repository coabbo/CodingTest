import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A;
		int B;
		
		A = sc.nextInt();
		B = sc.nextInt();
		
		if(A > B) {
			System.out.print(">");
		} else if(A < B){
			System.out.print("<");
		} else {
			System.out.print("==");
		}
	}
}