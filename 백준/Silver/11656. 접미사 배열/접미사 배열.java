import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		String[] arr = new String[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.substring(i);
		}
		
		Arrays.sort(arr);
		
		for (String string : arr) {
			sb.append(string).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}