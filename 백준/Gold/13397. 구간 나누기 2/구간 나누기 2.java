import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 수의 개수
		M = Integer.parseInt(st.nextToken()); // M개 이하의 구간
		
		arr = new int[N];
		
		int max = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		parametricSearch(0, max);
	}

	public static void parametricSearch(int left, int right) {
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(check(mid)) { // mid의 차이로 M개 이하 구간이 가능하다면
				answer = mid; // 정답 후보
				right = mid - 1; // 더 줄일 수 있는지 탐색
			}
			else {
				left = mid + 1; // 불가능하므로 더 크게 잡아서 탐색
			}
		}
		
		System.out.println(answer);
	}

	// mid일 때 M개 이하 구간으로 나눌 수 있는지 체크
	public static boolean check(int mid) {
		int count = 1; // 최소 1개 구간
		int min = arr[0], max = arr[0];
		
		for (int i = 1; i < N; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			
			if(max - min > mid) { // 구간 제한 초과 -> 새로운 구간 시작
				count++;
				min = arr[i];
				max = arr[i];
			}
		}
		
		return count <= M;
	}
}