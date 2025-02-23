import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
  
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        ArrayList<Integer> numList = new ArrayList<>();
  
        for(int test_case = 1; test_case <= T; test_case++)
        {
            numList.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
             
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine() + " ");
                for(int j = 0; j < M; j++) {
                    numList.add(Integer.parseInt(st.nextToken()));
                }
            }
             
            int maxSum = 0;
             
            for(int i = 0; i <= M-N; i++) {
                for(int j = 0; j <= M-N; j++) {
                    int sum = 0;
                     
                    for (int di = 0; di < N; di++) {
                        for (int dj = 0; dj < N; dj++) {
                            sum += numList.get((i + di) * M + (j + dj));
                        }
                    }
                     
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
             
            sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
        }
        System.out.print(sb.toString());
    }
}