import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		String s;
        int num;
		s=sc.next();

		for(int i=0; i<s.length(); i++){
            num = s.charAt(i) - 64;
        	System.out.print(num);
            
            if(i != s.length()-1){
                System.out.print(" ");
            }
        }
	}
}