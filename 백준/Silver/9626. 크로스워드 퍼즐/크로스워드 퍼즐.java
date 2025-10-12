import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); // M개의 줄
		int N = Integer.parseInt(st.nextToken()); // N개의 글자
		
		st = new StringTokenizer(br.readLine(), " ");
		int U = Integer.parseInt(st.nextToken()); // 위
		int L = Integer.parseInt(st.nextToken()); // 왼쪽
		int R = Integer.parseInt(st.nextToken()); // 오른쪽
		int D = Integer.parseInt(st.nextToken()); // 아래
		
		// 위쪽 영역
		for (int i = -U; i < 0; i++) {
			for (int j = -L; j < N + R; j++) {
				if((i + j + U + L) % 2 == 0) {
					sb.append("#");
				}
				else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		
		// 중간 영역
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			if(L != 0) {
				for(int j = -L; j < 0; j++) {
					if((i + j + U + L) % 2 == 0) {
						sb.append("#");
					}
					else {
						sb.append(".");
					}
				}
			}
			
			sb.append(st.nextToken());
			
			if(R != 0) {
				for(int j = N; j < N + R; j++) {
					if((i + j + U + L) % 2 == 0) {
						sb.append("#");
					}
					else {
						sb.append(".");
					}
				}
			}
			
			sb.append("\n");
		}
		
		// 아래쪽 영역
		for (int i = M; i < M + D; i++) {
			for (int j = -L; j < N + R; j++) {
				if((i + j + U + L) % 2 == 0) {
					sb.append("#");
				}
				else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}