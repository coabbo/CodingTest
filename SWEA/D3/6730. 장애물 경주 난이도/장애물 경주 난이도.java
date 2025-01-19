import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            
            arrList.clear();
            tempList.clear();
            
            int num = sc.nextInt();
            for(int i=0; i<num; i++){
            	int temp = sc.nextInt();               
                arrList.add(temp);
            }
            
            for(int i=0; i < arrList.size() - 1; i++){
            	tempList.add(arrList.get(i+1) - arrList.get(i));
            }
            
            Collections.sort(tempList);
            
            if((tempList.get(0) == tempList.get(tempList.size()-1)) && tempList.get(0) > 0){
            	System.out.println(tempList.get(0) + " " + "0");
            } else if(tempList.get(0) == tempList.get(tempList.size()-1) && tempList.get(0) < 0){
                System.out.println("0" + " " + Math.abs(tempList.get(0)));
            } else{
                System.out.println(tempList.get(tempList.size()-1) + " " + Math.abs(tempList.get(0)));
            }
		}
	}
}