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
            int answer = 0;
            int strLength = sc.nextInt();
            String example = sc.next();
            String chan = sc.next();
            
            for(int i=0; i<strLength; i++){
            	if(example.charAt(i) == chan.charAt(i)){
                	answer = answer + 1;
                }
            }
            System.out.println(answer);
		}
	}
}