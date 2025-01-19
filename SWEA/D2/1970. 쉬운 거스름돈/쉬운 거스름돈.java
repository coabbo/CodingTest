import java.util.*;

class Solution
{
	public static int returnCount(int num, int moneyUnit) {
		int count;
        count = num / moneyUnit;
        num = num % moneyUnit;
        System.out.print(count + " ");
		
		return num;
	}
	
	public static void main(String args[]) throws Exception
	{   
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int count50000;
        int count10000;
        int count5000;
        int count1000;
        int count500;
        int count100;
        int count50;
        int count10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.println("#" + test_case);
            
            int num = sc.nextInt();
            
            num = returnCount(num, 50000);
            num = returnCount(num, 10000);
            num = returnCount(num, 5000);
            num = returnCount(num, 1000);
            num = returnCount(num, 500);
            num = returnCount(num, 100);
            num = returnCount(num, 50);
            num = returnCount(num, 10);

            System.out.println("");
		}
	}
}