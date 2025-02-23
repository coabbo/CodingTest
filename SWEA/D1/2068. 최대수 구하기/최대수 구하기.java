import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        int[] numArr = new int[10];
 
        int T = Integer.parseInt(br.readLine());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {       
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < numArr.length; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
             
            Arrays.sort(numArr);
 
            sb.append("#").append(test_case).append(" ").append(numArr[numArr.length-1]).append("\n");
        }
        System.out.print(sb.toString());
    }
}