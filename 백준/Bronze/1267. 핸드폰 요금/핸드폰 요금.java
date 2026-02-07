import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] time = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		int yCharge = y(time);
		int mCharge = m(time);
		
		if(yCharge == mCharge) System.out.println("Y M " + yCharge);
		else {
			int min = Math.min(yCharge, mCharge);
			
			if(min == yCharge) System.out.println("Y " + yCharge);
			else System.out.println("M " + mCharge);
		}
	}

	private static int y(int[] time) {
		int temp = 0;
		
		for (int i : time) {
			temp += 10 * ((i / 30) + 1);
		}
		
		return temp;
	}
	
	private static int m(int[] time) {
		int temp = 0;
		
		for (int i : time) {
			temp += 15 * ((i / 60) + 1);
		}
		
		return temp;
	}
}