import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String T;
        int TLength;
		T=sc.next();
        TLength = T.length();
        
        String[] arr = new String[TLength];
        arr = T.split("");
        
        int answer = 0;
        for(int i=0; i<arr.length; i++){
            answer = answer + Integer.parseInt(arr[i]);
        }
        
        System.out.print(answer);
	}
}