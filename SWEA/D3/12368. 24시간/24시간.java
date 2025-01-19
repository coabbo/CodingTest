import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int sum = 0;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
            sum = num1 + num2;
            
            if(sum >= 24){
            	System.out.println(sum - 24);
            } else{
            	System.out.println(sum);
            }
		}
	}
}