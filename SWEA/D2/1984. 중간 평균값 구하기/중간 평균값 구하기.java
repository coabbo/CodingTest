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
            System.out.print("#" + test_case + " ");
            arrList.clear();
            double sum=0;
            
			for(int i=0; i<10; i++){
                int num = sc.nextInt();
                arrList.add(num);
            }
            
            Collections.sort(arrList);
            
            for(int i=1; i<9; i++){
                sum = sum + arrList.get(i);
            }
            
            System.out.println(Math.round(sum/8));
		}
	}
}