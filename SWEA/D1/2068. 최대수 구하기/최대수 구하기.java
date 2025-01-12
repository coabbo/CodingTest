import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            arrList.clear();
            for(int i=0; i<10; i++){
                int num = sc.nextInt();
                arrList.add(num);
            }
            
            int max = Collections.max(arrList);
            System.out.println("#" + test_case + " " + max);
		}
	}
}