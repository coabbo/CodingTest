class Solution
{
	public static void main(String args[]) throws Exception
	{
		String plus = "+++++";
        String[] plusArr = new String[plus.length()];
        
        plusArr = plus.split("");
        
        for(int i=0; i<plusArr.length; i++){
            plusArr[i] = "#";
            for(int j=0; j<plusArr.length; j++){
                System.out.print(plusArr[j]);
            }
            plusArr[i] = "+";
            System.out.println("");
        }
	}
}