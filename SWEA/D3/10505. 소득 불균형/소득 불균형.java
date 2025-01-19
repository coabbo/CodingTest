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
            int num = sc.nextInt();
            int sum = 0;
            double mean = 0;
            int answer = 0;
            
            for(int i=0; i<num; i++){
            	int temp = sc.nextInt();
                arrList.add(temp);
            }
            
            for(int i=0; i<arrList.size(); i++){
            	sum = sum + arrList.get(i);
            }
            
            mean = sum/num;
            
            for(int i=0; i<num; i++){
            	if(arrList.get(i) > mean)
                    continue;
                else
                    answer = answer + 1;
            }
            
            System.out.println(answer);
		}
	}
}