import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine()); // 방학 일 수
		int A = Integer.parseInt(br.readLine()); // 국어 총 페이지
		int B = Integer.parseInt(br.readLine()); // 수학 총 페이지
		int C = Integer.parseInt(br.readLine()); // 하루에 풀 수 있는 국어 최대 페이지
		int D = Integer.parseInt(br.readLine()); // 하루에 풀 수 있는 수학 최대 페이지
		
		int maxNeedDay = 0;
		int koreanNeedDay = 0;
		int mathNeedDay = 0;
		
		// 국어
		if(A % C == 0) {
			koreanNeedDay = A / C;
		}
		else {
			koreanNeedDay = (A / C) + 1;
		}
		
		// 수학
		if(B % D == 0) {
			mathNeedDay = B / D;
		}
		else {
			mathNeedDay = (B / D) + 1;
		}
		
		maxNeedDay = Math.max(koreanNeedDay, mathNeedDay);
		System.out.println(L - maxNeedDay);
	}
}