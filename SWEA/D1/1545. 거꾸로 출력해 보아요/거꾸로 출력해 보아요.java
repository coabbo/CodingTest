import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num=sc.nextInt();
		
        for(int i=num; i>=0; i--){
            System.out.print(i);
            if(i != 0){
                System.out.print(" ");
            }
        }
	}
}