import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
        int num;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            System.out.print("#" + test_case + " ");
            
            num = sc.nextInt();

            while(num != 1){
            	if(num % 2 == 0){
                    num = num / 2;
                    a = a + 1;
                }
                if(num % 3 == 0){
                    num = num / 3;
                    b = b + 1;
                }
                if(num % 5 == 0){
                    num = num / 5;
                    c = c + 1;
                }
                if(num % 7 == 0){
                    num = num / 7;
                    d = d + 1;
                }
                if(num % 11 == 0){
                    num = num / 11;
                    e = e + 1;
                }
            }
            System.out.println(a + " " + b + " " + c + " " + d + " " + e);
		}
	}
}