import java.util.Scanner;

public class Solution {
	static int answer = 1;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			answer = pow(N, M);
			
			System.out.println("#" + T + " " + answer);
		}
	}

	private static int pow(int N, int M) {
		
		if(M == 1) {
			return N;
		}
		else {
			return N * pow(N, M-1);
		}
	}
}