import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = 0;
		
		boolean flag = false; // 숫자를 찾았는지 여부를 체크
		
		for (int i = 0; i < 3; i++) {
			String s = br.readLine();
			
			// 입력받은 문자열의 앞 문자만 따로 뽑아서 확인
			char c = s.charAt(0);
			
			// 만약에 입력받은 문자열이 숫자면 플래그 변경
			if(c != 'F' && c != 'B') {
				num = Integer.parseInt(s);
				flag = true;
			}
			
			// 숫자를 찾은 상태면 다음에 오는 값과 상관 없이 +1 하여 다음 수를 추측
			if(flag) {
				num++;
			}
		}
		
		if(num % 3 == 0) {
			if(num % 5 == 0) {
				System.out.println("FizzBuzz");
			}
			else {
				System.out.println("Fizz");
			}
		}
		else {
			if(num % 5 == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(num);
			}
		}
	}
}