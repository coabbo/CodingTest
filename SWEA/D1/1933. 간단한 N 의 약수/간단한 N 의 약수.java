import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num=sc.nextInt();

        for(int i=1; i<=num; i++){
            if(num % i == 0){
                System.out.print(i);
                if(num != i){
                    System.out.print(" ");
                }
            }
        }
	}
}