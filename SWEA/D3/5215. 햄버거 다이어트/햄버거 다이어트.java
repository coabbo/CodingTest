import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			int[] tasteScore = new int[N]; // 맛 점수
			int[] calorie = new int[N]; // 칼로리
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				tasteScore[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int totalCase = 1 << N; // 2^N, 모든 재료 선택 경우의 수			
			
			for(int i=0; i < totalCase; i++) {
				
				int tasteScoreSum = 0;
				int calorieSum = 0;
				
				for (int j = 0; j < N; j++) {
					// j번째 재료 선택
					if ((i & (1 << j)) != 0) {
						tasteScoreSum += tasteScore[j];
						calorieSum += calorie[j];
					}
				}
				
				if (calorieSum <= L) { // 제한 칼로리 안 넘으면 최댓값 갱신
					max = Math.max(max, tasteScoreSum);
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(max).append("\n");
		}
    	System.out.print(sb.toString());
    }
}