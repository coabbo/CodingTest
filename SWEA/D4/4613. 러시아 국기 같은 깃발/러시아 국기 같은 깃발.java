import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 행, 3 <= N <= 50 
			int M = Integer.parseInt(st.nextToken()); // 열, 3 <= M <= 50 
			map = new int[N][3]; // 0:W, 1:B, 2:R
			for (int i = 0; i < N; i++) {
				String s = br.readLine(); // "WRWRW"
				for (int j = 0; j < s.length(); j++) {
					switch (s.charAt(j)) {
					case 'W': map[i][0]++; break;
					case 'B': map[i][1]++; break;
					case 'R': map[i][2]++; break;
					}
				}
			}
			int[][] memo = new int[50][3];
			memo[0][0] = map[0][1] + map[0][2]; // 1행은 w만 가능
			memo[0][1] = 987654321; // 임의의 큰 수로 초기화, Integer.MAX_VALUE로 하면 안됨, 오버플로우 발생
			memo[0][2] = 987654321;	// 실제 가능한 값 보다 큰 값으로 초기화 하면됨, 50*50 = 2500 보다 큰 값
			for (int i = 1; i < N; i++) {
				memo[i][0] = memo[i-1][0] + map[i][1] + map[i][2]; // i-1행에 W칠한것에 i행에 W칠할 경우 바꿔야하는 칸의 개수
				memo[i][1] = Math.min(memo[i-1][0], memo[i-1][1]) + map[i][0] + map[i][2]; // i-1행 W,B 칠할 경우 바꿔야하는 칸중 최소값에 i행에 B칠할 경우 바꿔야하는 칸의 개수
				memo[i][2] = Math.min(memo[i-1][1], memo[i-1][2]) + map[i][0] + map[i][1]; // i-1행 B,R 칠할 경우 바꿔야하는 칸중 최소값에 i행에 R칠할 경우 바꿔야하는 칸의 개수
			}
			sb.append("#").append(testCase).append(" ").append(memo[N-1][2]).append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
} // end of class