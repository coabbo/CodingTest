import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] hiTeam = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			hiTeam[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arcTeam = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			arcTeam[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(hiTeam);
		Arrays.sort(arcTeam);

		long hiWin = 0;
		long arcWin = 0;
		long draw = 0;
		
		for (int x : hiTeam) {
			hiWin += lowerBound(arcTeam, x); // x보다 작은 원소의 개수
			arcWin += arcTeam.length - upperBound(arcTeam, x); // x보다 큰 원소의 개수
			draw += upperBound(arcTeam, x) - lowerBound(arcTeam, x); // x와 같은 원소의 개수
		}
		
		System.out.println(hiWin + " " + arcWin + " " + draw);
	}
	
	// lower_bound : key 이상 첫 위치
	public static int lowerBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(arr[mid] < key) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		
		return left; // key 이상이 처음 나오는 위치
	}
	
	// upper_bound : key 초과 첫 위치
	public static int upperBound(int[] arr, int key) {
		int left = 0;
		int right = arr.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(arr[mid] <= key) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		
		return left; // key 초과가 처음 나오는 위치
	}
}