import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int P;
        int K;
        P=sc.nextInt();
        K=sc.nextInt();
        int answer = 0;
        
        for(int i=K; i<=P; i++){
            answer = answer + 1;
        }
        
        System.out.print(answer);
	}
}