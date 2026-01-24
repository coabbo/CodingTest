import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Set<Character> vowel = new HashSet<>();
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			int count = 0;
			for (int j = 0; j < s.length(); j++) {
				if(vowel.contains(s.charAt(j))) count++;
			}
			
			sb.append("The number of vowels in ").append(s).append(" is ").append(count).append(".\n");
		}
		
		System.out.println(sb.toString());
	}
}