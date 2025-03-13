import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Set<String> strSet = new HashSet<>();
		
		//(0,1) (1,2) (2,3) (3,4) (4,5)
		//(0,2) (1,3) (2,4) (3,5)
		//(0,3) (1,4) (2,5)
		//(0,4) (1,5)
		//(0,5)
		
		for (int i = 0; i < S.length(); i++) {
			for (int j = i+1; j <= S.length(); j++) {
				strSet.add(S.substring(i, j));
			}
		}

		System.out.println(strSet.size());
	}
}