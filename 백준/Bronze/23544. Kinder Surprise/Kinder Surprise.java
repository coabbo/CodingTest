import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			set.add(s);
		}
		
		System.out.println(N - set.size());
	}
}