import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A;
		int B;
		int C;
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();

		int num1 = (A+B)%C;
		int num2 = ((A%C) + (B%C))%C;
		int num3 = (A*B)%C;
		int num4 = ((A%C) * (B%C))%C;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		
	}
}