import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String s = br.readLine();
		
		String[] sArr = s.split("\\.", -1);
		String[] replaceArr = new String[sArr.length];
		
		for (int i = 0; i < sArr.length; i++) {
			int length = sArr[i].length();
			
			// 빈 문자일 경우 다음으로 넘김
			if(length == 0) {
				replaceArr[i] = "";
				continue;
			}
			
			// 치환이 불가능한 경우 -1 출력 후 종료
			if(length % 2 != 0) {
				System.out.println("-1");
				return;
			}
			
			StringBuilder temp = new StringBuilder();
			
			// 가능한 경우 "AAAA"로 먼저 치환
			if(length / 4 > 0) {
				for (int j = 0; j < length / 4; j++) {
					temp.append("AAAA");
				}
			}
			
			// 가능한 경우 "BB"로 치환
			if(length % 4 == 2) {
				temp.append("BB");
			}
			
			replaceArr[i] = temp.toString();
		}
		
		String answer = String.join(".", replaceArr);
		System.out.println(answer);
	}
}