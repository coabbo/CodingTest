import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		
		int[] arr = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}
		
		Arrays.sort(arr);
		
		for (int i = arr.length-1; i >= 0 ; i--) {
			System.out.print(arr[i]);
		}
	}

}
