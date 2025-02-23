import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> code = new ArrayList<>();
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                code.add(Integer.parseInt(st.nextToken()));
            }
 
            int commandCount = Integer.parseInt(br.readLine());
 
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (s.equals("I")) {
                    int location = Integer.parseInt(st.nextToken()); // 위치
                    int x = Integer.parseInt(st.nextToken()); // 개수
                    for (int i = 0; i < x; i++) {
                        int num = Integer.parseInt(st.nextToken());
                        code.add(location + i, num);
                    }
                }
            }
 
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(code.get(i)).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}