import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();
		String s;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#" + test_case + " ");
            
            s = sc.next();
            
            String YYYY = s.substring(0, 4);
            String MM = s.substring(4, 6);
            String DD = s.substring(6, 8);
            
            switch(MM){
                case "01":
                case "03":
                case "05":
                case "07":
                case "08":
                case "10":
                case "12":
                    if (Integer.parseInt(DD) >= 1 && Integer.parseInt(DD) <= 31){
                        System.out.println(YYYY + "/" + MM + "/" + DD);
                    } else{
                        System.out.println("-1");
                    }
                    break;
                    
                case "04":
                case "06":
                case "09":
                case "11":
                    if(Integer.parseInt(DD) >= 1 && Integer.parseInt(DD) <= 30){
                    	System.out.println(YYYY + "/" + MM + "/" + DD);
                    } else{
                        System.out.println("-1");
                    }
                    break;
                    
                case "02":
                    if(Integer.parseInt(DD) >= 1 && Integer.parseInt(DD) <= 28){
                        System.out.println(YYYY + "/" + MM + "/" + DD);
                    } else{
                    	System.out.println("-1");
                    }
                    break;
                    
                default: System.out.println("-1");         
            }
		}
	}
}