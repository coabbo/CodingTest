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
            String s = sc.next();
            
            s = s.replace("a", "");
            s = s.replace("e", "");
            s = s.replace("i", "");
            s = s.replace("o", "");
            s = s.replace("u", "");
            System.out.println(s);
		}
	}
}