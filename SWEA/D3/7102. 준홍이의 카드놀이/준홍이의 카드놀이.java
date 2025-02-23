import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            int[] count = new int[N+M+1];
             
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    count[i+j]++;
                }
            }           
             
            int max = -1;
            for(int i = 2; i < count.length; i++) {
                if (max < count[i]) {
                    max = count[i];
                }
            }
             
            sb.append("#").append(testCase).append(" ");
             
            for(int i = 2; i < count.length; i++) {
                if (max == count[i]) {
                    sb.append(i).append(" ");
                }
            }
             
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}