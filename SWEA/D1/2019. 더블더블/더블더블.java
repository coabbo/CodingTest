import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num=sc.nextInt();
		
        for(int i=0; i<=num; i++){
            int temp = (int)Math.pow(2, i);
            System.out.print(temp);
            if(i != num){
                System.out.print(" ");
            }
        }
	}
}