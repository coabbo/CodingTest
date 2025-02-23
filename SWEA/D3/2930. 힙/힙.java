import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine()); //연산 수행 횟수
             
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
             
            sb.append("#").append(testCase).append(" ");
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1) {
                    pq.add(Integer.parseInt(st.nextToken()));
                } else if(temp == 2) {
                    if(pq.size() == 0) {
                        sb.append("-1").append(" ");
                    } else {
                        sb.append(pq.poll()).append(" ");
                    }
                }
            }
            sb.append("\n");
        }//testCase 끝
        System.out.print(sb.toString());
    }//main 끝
}//class 끝