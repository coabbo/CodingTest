import java.util.Scanner;

public class Solution {
	static int[] smallLengthArr;
	static int[] longLengthArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] Arr1 = new int[N];
			int[] Arr2 = new int[M];
			
			for (int i = 0; i < N; i++) {
				Arr1[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				Arr2[i] = sc.nextInt();
			}
			
			int max = Math.max(Arr1.length, Arr2.length);
			int min = Math.min(Arr1.length, Arr2.length);
			
			if(Arr1.length == min) {
				smallLengthArr = Arr1;
				longLengthArr = Arr2;
			}
			else {
				smallLengthArr = Arr2;
				longLengthArr = Arr1;
			}
			
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < max - min + 1; i++) {
				int sum = 0;
				for (int j = 0; j < min; j++) {
					
					sum += smallLengthArr[j] * longLengthArr[j + i];
				}
				result = Math.max(result, sum);
			}
			
			System.out.println("#" + testCase + " " + result);
		}
	}
}