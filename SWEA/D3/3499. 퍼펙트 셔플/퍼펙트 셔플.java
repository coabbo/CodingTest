import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
             
            int firstNum = N / 2;
            int secondNum = N - firstNum;
             
            int maxNum = Math.max(firstNum, secondNum);
            int minNum = Math.min(firstNum, secondNum);
             
            Queue<String> firstQueue = new LinkedList<>();
            Queue<String> secondQueue = new LinkedList<>();
             
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             
            for (int i = 0; i < maxNum; i++) {
                firstQueue.add(st.nextToken());
            }
             
            for (int i = 0; i < minNum; i++) {
                secondQueue.add(st.nextToken());
            }
             
            Queue<String> answerQueue = new LinkedList<>();
             
            for (int i = 0; i < N; i++) {
                if(i % 2 == 0) {
                    answerQueue.add(firstQueue.poll());
                }
                else if(i % 2 == 1) {
                    answerQueue.add(secondQueue.poll());
                }
            }
             
            sb.append("#").append(testCase).append(" ");
             
            int tempSize = answerQueue.size();
            for (int i = 0; i < tempSize; i++) {
                sb.append(answerQueue.poll()).append(" ");
            }
             
            sb.append("\n");
             
        }
        System.out.println(sb.toString());
    }
}