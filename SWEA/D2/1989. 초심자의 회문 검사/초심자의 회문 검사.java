import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        int answer;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			System.out.print("#" + test_case);

            String st = sc.next();
            
            int temp = st.length()-1;
            String reverse = "";
            
            for(int i=temp; i>=0; i--){
            	reverse = reverse + st.charAt(i);
            }
            
            if(reverse.equals(st)){
                answer = 1;
            } else{
            	answer = 0;
            }
            
            System.out.println(" " + answer);
		}
	}
}