import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int minDiff;
	private static int N;
	private static int halfN;
	private static boolean[] select;
	private static int[][] S;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int TC = Integer.parseInt(br.readLine());
    	for (int testCase = 1; testCase <= TC; testCase++) { //최대 50개 테스트 케이스
			N = Integer.parseInt(br.readLine()); //식재료의 수 N, (4 <= N <= 16), 짝수
			halfN = N/2;
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken()); //시너지 Sij, (1 <= Sij <= 20,000, i != j)
				}
			}
			select = new boolean[N];
			minDiff = Integer.MAX_VALUE;
			
			subset(0, 0, 0);
			sb.append("#").append(testCase).append(" ").append(minDiff).append("\n");
		}
    	System.out.println(sb.toString());
    }

    /** step : 현재 단계, selCnt, unselCnt */
	private static void subset(int step, int selCnt, int unselCnt) {
		if (selCnt > halfN || unselCnt > halfN) return;
		if (step == N) {
			check();
			return;
		}
		select[step] = true;
		subset(step + 1, selCnt + 1, unselCnt);
		select[step] = false;
		subset(step + 1, selCnt, unselCnt + 1);
	}

	public static void check() {
		int diff = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(select[i] && select[j]) {
					diff += S[i][j] + S[j][i];
				} else if (!select[i] && !select[j]) {
					diff -= S[i][j] + S[j][i];
				}
			}
		}
		diff = diff < 0 ? -diff : diff;
		if (minDiff > diff) minDiff = diff;
	}
}