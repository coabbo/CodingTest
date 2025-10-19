import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String s = br.readLine();
		
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'A']++;
		}
		
		int odd = 0;
		char middleChar = ' '; // 가운데 문자 저장
		for (int i = 0; i < alphabet.length; i++) {
			if(alphabet[i] % 2 == 1) {
				odd++;
				middleChar = (char)('A' + i);
			}
		}
		
		// 팰린드롬이 가능하지 않은 경우 출력 후 종료
		if(odd > 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 팰린드롬 전반부 만들기
		for (int i = 0; i < alphabet.length; i++) {
			int charCount = alphabet[i];
			
			for (int j = 0; j < charCount / 2; j++) {
				sb.append((char)('A' + i));
			}
		}
		
		String prefix = sb.toString();
		String reverse = sb.reverse().toString(); // 팰린드롬 후반부
		
		StringBuilder answer = new StringBuilder();
		answer.append(prefix);
		if(odd == 1) {
			answer.append(middleChar);
		}
		answer.append(reverse);
		
		System.out.println(answer.toString());
	}
}