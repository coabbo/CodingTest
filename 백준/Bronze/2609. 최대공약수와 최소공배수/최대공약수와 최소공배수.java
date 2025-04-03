import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		
		int maxNum = Math.max(num1, num2);
		
		int GCD = 0; //최대공약수
		int LCM = 0; //최소공배수
		
		for (int i = 1; i <= maxNum; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				GCD = i;
			}
		}
		
		LCM = GCD * (num1 / GCD) * (num2 / GCD);
		
		System.out.println(GCD);
		System.out.println(LCM);
	}
}