import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[5];
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());
		arr[3] = Integer.parseInt(st.nextToken());
		arr[4] = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (arr[i] == T) count++;
		}
		
		System.out.println(count);
	}
}