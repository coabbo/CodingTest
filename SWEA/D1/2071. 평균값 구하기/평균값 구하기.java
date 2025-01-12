import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();
        double answer = 0;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            
            answer = 0;
            arrList.clear();
            
			for(int i=0; i<10; i++){
            	arrList.add(sc.nextInt());
            }
            
            for(int i=0; i<10; i++){
                answer = answer + arrList.get(i);
            }
            
            answer = answer / 10;
            System.out.println(Math.round(answer));
		}
	}
}