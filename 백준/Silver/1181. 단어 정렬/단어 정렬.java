import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> arr = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			arr.add(br.readLine());
		}
		
		String[] stringArr = arr.toArray(new String[0]);
		
		Arrays.sort(stringArr); // 길이가 같으면 사전 순으로
		
		Arrays.sort(stringArr, new Comparator<String>() { // 길이가 짧은 것부터

			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		for (String s : stringArr) {
			System.out.println(s);
		}
	}
}