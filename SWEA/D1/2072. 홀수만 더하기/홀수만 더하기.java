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
            
            int answer = 0;
            arrList.clear();
            
            for(int i=0; i<10; i++){
                arrList.add(sc.nextInt());
            }
            
            for(int i=0; i<10; i++){
                if(arrList.get(i) % 2 == 1){
                	answer = answer + arrList.get(i);
                }
            }
            System.out.println(answer);
		}
	}
}