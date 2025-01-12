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
            
            int num;
            int answer = 0;
            num = sc.nextInt();
            
            for(int i=1; i<=num; i++){
                if(i%2==0){
                	answer = answer - i;
                }
                else{
                	answer = answer + i;
                }
            }
            System.out.println(answer);
		}
	}
}