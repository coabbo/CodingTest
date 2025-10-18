import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Set<Character> shortcutkeys = new HashSet<>(); // 대문자로 통일하여 저장
		
		for (int testCase = 0; testCase < N; testCase++) {
			String[] words = br.readLine().split(" ");
			boolean check = false; // 단축키 지정 성공 여부 확인
			
			// 1. 단어의 첫 글자를 확인 후, 단축키 지정
			for (int i = 0; i < words.length; i++) {
				char firstChar = Character.toUpperCase(words[i].charAt(0));
				
				if(!shortcutkeys.contains(firstChar)) {
					shortcutkeys.add(firstChar); // 단축키 지정 성공
					check = true;
					
					// 출력 문자열 만들기
					StringBuilder temp = new StringBuilder();
					for (int j = 0; j < words.length; j++) {
						if(j > 0) temp.append(" "); // 단어 사이에 공백 추가
						
						if(i == j) { // 단축키를 지정한 단어일 경우
							temp.append("[" + words[i].charAt(0) + "]" + words[i].substring(1));
						}
						else {
							temp.append(words[j]);
						}
					}
					
					sb.append(temp.toString()).append("\n");
					
					break;
				}
			}
			
			// 2. 1에서 단축키를 지정하지 못한 경우, 공백을 포함한 전체 문자열에서 왼쪽부터 탐색
			if(!check) {
				String s = String.join(" ", words);
				
				for (int i = 0; i < s.length(); i++) {
					char currentChar = s.charAt(i);
					
					if(currentChar == ' ') continue; // 공백은 건너뛰기
					
					char upperChar = Character.toUpperCase(currentChar);
					
					if(!shortcutkeys.contains(upperChar)) {
						shortcutkeys.add(upperChar); // 단축키 지정 성공
						check = true;
						
						// 출력 문자열 만들기
						sb.append(s.substring(0, i) + "[" + currentChar + "]" + s.substring(i+1)).append("\n");
					
						break;
					}
				}
			}
			
			// 3. 1, 2에서 모두 단축키를 지정하지 못한 경우 그대로 출력
			if(!check) {
				sb.append(String.join(" ", words)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}