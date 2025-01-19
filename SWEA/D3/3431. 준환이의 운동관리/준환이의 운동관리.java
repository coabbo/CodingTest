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
            
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();

            if(X > U){
            	System.out.println("-1");
            } else if(X >= L && X <= U){
            	System.out.println("0");
            } else{
            	System.out.println(L - X);
            }
		}
	}
}