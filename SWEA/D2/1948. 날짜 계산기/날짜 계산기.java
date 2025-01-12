import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
        HashMap<Integer, Integer> monthAndDayMap = new HashMap<Integer, Integer>();
        monthAndDayMap.put(1, 31);
        monthAndDayMap.put(2, 28);
        monthAndDayMap.put(3, 31);
        monthAndDayMap.put(4, 30);
        monthAndDayMap.put(5, 31);
        monthAndDayMap.put(6, 30);
        monthAndDayMap.put(7, 31);
        monthAndDayMap.put(8, 31);
        monthAndDayMap.put(9, 30);
        monthAndDayMap.put(10, 31);
        monthAndDayMap.put(11, 30);
        monthAndDayMap.put(12, 31);

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int answer = 0;
            
            System.out.print("#" + test_case + " ");
            
            ArrayList<Integer> arrList = new ArrayList<>();
            
            for(int i=0; i<4; i++){
                int n = sc.nextInt();

                arrList.add(n); 
            }
            
            int firstMonth = arrList.get(0);
            int secondMonth = arrList.get(2);
            
            for(int i=firstMonth; i<=secondMonth; i++){
                if(firstMonth == i && secondMonth == i){
                	answer = answer + (arrList.get(3) - arrList.get(1)) + 1;
                } else if(firstMonth == i){
                	answer = answer + (monthAndDayMap.get(i) - arrList.get(1)) + 1;
                } else if(secondMonth == i){
                    answer = answer + arrList.get(3);
                } else{
                	answer = answer + monthAndDayMap.get(i);
                }
            }
            
            System.out.println(answer);
		}
	}
}