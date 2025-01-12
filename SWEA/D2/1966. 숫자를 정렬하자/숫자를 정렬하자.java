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
            
            int num = sc.nextInt();
            ArrayList<Integer> numList = new ArrayList<>();
            
            for(int i=0; i<num; i++){
            	int temp = sc.nextInt();
                numList.add(temp);
            }
            
            Collections.sort(numList);
            
            for(int nums : numList){
            	System.out.print(nums + " ");
            }

            System.out.println("");
		}
	}
}