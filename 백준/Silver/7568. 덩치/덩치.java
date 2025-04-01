import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); //전체 사람의 수
		
		int[][] xy = new int[N][2]; //몸무게랑 키 담을 배열
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int rank = 1;
			for (int j = 0; j < N; j++) {
				
				if(i == j) {
					continue;
				}
				
				if(xy[i][0] < xy[j][0] && xy[i][1] < xy[j][1]) {
					rank++;
				}
				
			}
			System.out.print(rank + " ");
		}
	}
}