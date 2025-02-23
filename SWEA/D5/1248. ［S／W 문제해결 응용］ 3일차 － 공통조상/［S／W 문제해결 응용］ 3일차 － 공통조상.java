import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
class Solution {
    public static int size;
    public static int[][] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int testCase = 1; testCase<=T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken()); //정점의 수
            int E = Integer.parseInt(st.nextToken()); //간선의 수
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());
             
            tree = new int[V+1][3];
             
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i<E; i++) {
                 
                int parentNode = Integer.parseInt(st.nextToken());
                int childNode = Integer.parseInt(st.nextToken());
                 
                if(tree[parentNode][0] == 0) {
                    tree[parentNode][0] = childNode; //왼쪽
                }   
                else {
                    tree[parentNode][1] = childNode; //오른쪽
                }
                tree[childNode][2] = parentNode; //부모
            }
             
            ArrayList<Integer> path1 = new ArrayList<>();
            int current = target1;
            while (current != 0) {
                path1.add(current);
                current = tree[current][2];
            }
             
            ArrayList<Integer> path2 = new ArrayList<>();
            current = target2;
            while (current != 0) {
                path2.add(current);
                current = tree[current][2];
            }
             
            Collections.reverse(path1);
            Collections.reverse(path2);
             
            int answerP = 0;
            int minSize = Math.min(path1.size(), path2.size());
            for (int i = 0; i < minSize; i++) {
                if (path1.get(i).equals(path2.get(i))) {
                    answerP = path1.get(i);
                } else {
                    break;
                }
            }
             
            size = 0;
             
            preOrder(answerP);
             
            sb.append("#").append(testCase).append(" ").append(answerP).append(" ").append(size).append("\n");
        }
         
        System.out.println(sb.toString());
    }
     
    public static void preOrder(int node) {
        if(node != 0) {
            size++;
            preOrder(tree[node][0]);
            preOrder(tree[node][1]);
        }
    }
}