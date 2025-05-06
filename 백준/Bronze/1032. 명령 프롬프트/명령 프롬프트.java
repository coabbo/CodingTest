import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 파일 이름의 개수
		
		char[] answer = br.readLine().toCharArray(); // 첫번째 문자열을 char 배열로 받아놓음
		
		for (int i = 1; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < answer.length; j++) {
				if(answer[j] != temp.charAt(j)) {
					answer[j] = '?';
				}
			}
		}
		
		for (char c : answer) {
			System.out.print(c);
		}
	}
}