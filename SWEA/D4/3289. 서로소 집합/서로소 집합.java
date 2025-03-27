import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] p; //대표를 저장할 배열
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            p = new int[N+1];
             
            for(int i = 0; i <= N; i++) {
                p[i] = i;
            }
             
            System.out.print("#" + testCase + " ");
             
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                 
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                 
                if(a == 0) {
                    union(b, c);
                } else {
                    if(findSet(b) == findSet(c)) {
                        System.out.print("1");
                    } else {
                        System.out.print("0");
                    }
                }
            }
            System.out.println();
        }
    }
 
    private static int findSet(int x) {
        if(x != p[x]) 
            p[x] = findSet(p[x]);
        return p[x];
    }
 
    private static void union(int x, int y) {
        p[findSet(y)] = findSet(x);
    }
}