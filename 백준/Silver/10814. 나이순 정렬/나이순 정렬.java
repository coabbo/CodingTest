import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[][] people = new String[N][2];
		
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			people[i][0] = st.nextToken();
			people[i][1] = st.nextToken();
		}
		
		Arrays.sort(people, new Comparator<String[]>() {

			@Override
			public int compare(String[] s1, String[] s2) {
				if(Integer.parseInt(s1[0]) != Integer.parseInt(s2[0])) { // 나이가 다르면 나이 오름차순
					return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
				} else { // 나이가 같으면 먼저 가입하는 사람이 앞
					return s1[0].compareTo(s2[0]);
				}
			}
		});
		
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i][0] + " " + people[i][1]);
		}
	}
}