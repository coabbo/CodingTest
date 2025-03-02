import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> alreadyWordSet = new LinkedHashSet<>();
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for (int testCase = 1; testCase <= N; testCase++) {
			
			alreadyWordSet.clear();
			
			String input = br.readLine();
			
			for (int i = 0; i < input.length(); i++) {
				alreadyWordSet.add(String.valueOf(input.charAt(i)));
			}
			
			for (String s : alreadyWordSet) {
				for (int i = 0; i < input.length();) {
					if(String.valueOf(input.charAt(i)).equals(s)) {
						input = input.replaceFirst(input.charAt(i)+"", "");
						continue;
					}
					else {
						break;
					}
				}
			}
			
			if(input.length() == 0) {
				answer += 1;
			}
		}
		
		System.out.println(answer);
	}
}