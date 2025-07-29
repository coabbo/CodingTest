import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 병사 수
		int K = Integer.parseInt(st.nextToken()); // 이겨야 할 병사 수
		
		int[][] arr = new int[N][3];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int strength = arr[i][0];
					int agility = arr[j][1];
					int intelligence = arr[k][2];
					
					int count = 0;
					for (int x = 0; x < N; x++) {
						if(strength >= arr[x][0] && agility >= arr[x][1] && intelligence >= arr[x][2]) {
							count++;
						}
					}
					
					if(count >= K) {
						answer = Math.min(answer, strength + agility + intelligence);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}