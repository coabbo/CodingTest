import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        int[] numArr = new int[100];
  
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int T = Integer.parseInt(br.readLine());
              
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < numArr.length; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
              
            int max = numArr[0];
            int min = numArr[0];
            int maxidx = 0;
            int minidx = 0;
              
            for(int i = 0; i < T; i++) {
                for(int j = 0; j < 100; j++) {
                    if(max < numArr[j]) {
                        max = numArr[j];
                        maxidx = j;
                    }
                    if(min > numArr[j]) {
                        min = numArr[j];
                        minidx = j;
                    }
                }   
                 
                if(numArr[maxidx] - numArr[minidx] <= 0) {
                    break;
                }
                 
                max = max - 1;
                min = min + 1;
                numArr[maxidx] = max;
                numArr[minidx] = min;
                 
            }
              
            for(int i = 0; i < 100; i ++) {
                if(max < numArr[i]) {
                    max = numArr[i];
                }
                if(min > numArr[i]) {
                    min = numArr[i];
                }
            }
              
            sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
        }
        System.out.print(sb.toString());
    }
}