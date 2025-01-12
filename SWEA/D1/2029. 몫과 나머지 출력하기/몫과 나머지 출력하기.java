import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
        int num1;
        int num2;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            
            System.out.println("#" + test_case + " "+ num1/num2 + " " + num1%num2);
		}
	}
}