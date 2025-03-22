import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] clothes = new int[6];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < clothes.length; i++) {
			clothes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int clothesCount = 0;
		
		for (int i = 0; i < clothes.length; i++) {
			int temp = 0;
			
			while(clothes[i] > temp) {
				temp += T;
				clothesCount++;
			}
		}
		
		int penSet = 0;
		int penCount = 0;
		
		penSet = N / P;
		penCount = N % P;
		
		System.out.println(clothesCount);
		System.out.println(penSet + " " + penCount);
	}
}