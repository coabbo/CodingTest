import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        ArrayList<Integer> time = new ArrayList<>();
        int hour;
        int minute;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            
            time.clear();
            
            for(int i=0; i<4; i++){
                time.add(sc.nextInt());
            }
            
            hour = time.get(0) + time.get(2);
            minute = time.get(1) + time.get(3);
            
            if(minute >= 60){
            	hour = hour + 1;
                minute = minute - 60;
            }
            
            if(hour >= 13){
            	hour = hour - 12;
            }
            
            System.out.print(hour + " ");
            System.out.println(minute);
		}
	}
}