import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            String num1 = sc.next();
            String num2 = sc.next();
            
            if(num1.length() > 1 || num2.length() > 1){
            	System.out.println("-1");
            } else{
            	System.out.println(Integer.parseInt(num1) * Integer.parseInt(num2));
            }
		}
	}
}