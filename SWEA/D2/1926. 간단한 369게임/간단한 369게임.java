import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int num;
		num=sc.nextInt();

        for(int i=1; i<=num; i++){
            String temp = Integer.toString(i);
               
            if(temp.contains("3") || temp.contains("6") || temp.contains("9")){
                for(int j=0; j<temp.length(); j++){
                	if(temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9'){
                        System.out.print("-");
                    }
                }
                if(temp != Integer.toString(i)){
                    System.out.print(" ");
                }
            } else{
                if(temp != Integer.toString(i)){
                    System.out.print(i + " ");
                }
            }
        }
	}
}