import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int answer = 0;
		int count = 0;
		int i = 1; // 'O'의 인덱스 위치
		
		while(i < M - 1) {
			if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
				count++; // IOI 블록 하나 추가
				if(count >= N) answer++; // N개 이상 연속되면 P 패턴 완성
				
				i += 2;
			}
			else {
				count = 0; // 패턴 끊기면 카운트 초기화
				i++;
			}
		}
		
		System.out.println(answer);
	}
}