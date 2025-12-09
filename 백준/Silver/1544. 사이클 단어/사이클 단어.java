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
		set.add(br.readLine());
		
		for (int i = 1; i < N; i++) {
			String s = br.readLine();
			String connectingS = s + s;
			
			boolean check = false;
			for (String word : set) {
				if(s.length() != word.length()) continue;
				
				if(connectingS.contains(word)) {
					check = true;
					break;
				}
			}
			
			if(!check) set.add(s);
		}
		
		System.out.println(set.size());
	}
}