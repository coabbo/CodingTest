import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        Set<String> setList = new HashSet<>();
        ArrayList<String> checkList = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
        int answer;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            setList.clear();
            int temp = 1;
            
            System.out.print("#" + test_case);
            
            String N = sc.next();
            int tempNum = Integer.parseInt(N);
            
            while(!setList.containsAll(checkList)){   
                int numLength = (int)(Math.log10(tempNum)+1);
                
                String tempst = Integer.toString(tempNum);
                
                for(int i=0; i<numLength; i++){
                    setList.add(String.valueOf(tempst.charAt(i)));
                }
                
                temp = temp + 1;
                tempNum = Integer.parseInt(N);
                tempNum = tempNum * temp;
            }
            
            answer = tempNum - Integer.parseInt(N);
            System.out.println(" " + answer);
		}
	}
}