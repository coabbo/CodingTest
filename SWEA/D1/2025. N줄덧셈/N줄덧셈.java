import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
        int answer = 0;
		T=sc.nextInt();
		
        for(int i=0; i<=T; i++){
            answer = answer + i;
        }
        
        System.out.print(answer);
	}
}