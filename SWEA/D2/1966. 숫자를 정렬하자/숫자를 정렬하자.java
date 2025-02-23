import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int[] numArr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < numArr.length; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
             
            for (int i = 0; i < numArr.length; i++) {
                int j; //정렬 포인트
                int key = numArr[i];
                 
                for(j = i-1; j >= 0 && key < numArr[j]; j--) {
                    numArr[j+1] = numArr[j];
                }
                 
                numArr[j+1] = key;
            }
             
            sb.append("#").append(testCase).append(" ");
            for (int k = 0; k < numArr.length; k++) {
                sb.append(numArr[k]).append(" ");
                 
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}