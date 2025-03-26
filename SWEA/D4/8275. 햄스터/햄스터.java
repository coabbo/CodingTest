import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 완전탐색, 백트래킹
 * 11^6 1초내에 가능
 */
public class Solution {
	private static class Note {
		int l;
		int r;
		int s;
		public Note(int l, int r, int s) {
			this.l = l;
			this.r = r;
			this.s = s;
		}
	}
	private static int N;
	private static int X;
	private static int M;
	private static Note[] notes;
	private static int[] result;
	private static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 46개 테스트케이스
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 우리의 개수 N, 1 ≤ N ≤ 6
			X = Integer.parseInt(st.nextToken()); // 각 우리 최대 햄스터수 제한 X, 1 ≤ X ≤ 10
			M = Integer.parseInt(st.nextToken()); // 기록의 개수 M, 1 ≤ M ≤ 10
			
			notes = new Note[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int l = Integer.parseInt(st.nextToken()); // 1 ≤ l ≤ r ≤ N  
				int r = Integer.parseInt(st.nextToken()); // 1 ≤ l ≤ r ≤ N
				int s = Integer.parseInt(st.nextToken()); // 0 ≤ s ≤ 60
				notes[i] = new Note(l,r,s);
			}
			result = new int[N+1]; // 0번방 안씀 
			max = -1;
			perm(1, 0, new int[N+1]); // 중복 순열
			sb.append('#').append(testCase);
			if (max == -1) {
				sb.append(" -1");
			} else {
				for (int i = 1; i < result.length; i++) {
					sb.append(" ").append(result[i]);
				}
			}
			sb.append("\n");
		} // end of for testCase
		System.out.print(sb.toString());
	} // end of main
	/** 중복순열(사전순 역순) 만드는 재귀함수, index :1~N 우리를 채울 작업, sum : 확정된 원소들의 합, arr[]:임시로 작업결정한 배열 */
	public static void perm(int index, int sum, int[] arr) {
		if (index > N) { // 종료파트
			// M개의 조건에 맞는지
			for (Note ni : notes) {
				int temp = 0;
				for (int i = ni.l; i <= ni.r; i++) {
					temp += arr[i];
				}
				if (temp != ni.s) return;
			}
			// max 업데이트
			if (max <= sum) {
				max = sum;
				// result 에 저장해두자
				System.arraycopy(arr, 0, result, 0, arr.length);
			}
			return;
		} // 재귀파트
//		중복순열(사전순 역순)
		for (int i = X; i >= 0; i--) {
			arr[index] = i;
			perm(index+1, sum+i, arr);
		}
    }
} // end of class