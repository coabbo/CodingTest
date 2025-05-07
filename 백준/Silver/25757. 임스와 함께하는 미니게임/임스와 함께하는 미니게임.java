import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 임스와 같이 플레이하기를 신청한 횟수
		String G = st.nextToken(); // 플레이할 게임의 종류
		Set<String> participant = new HashSet<>();

		int play = 0;

		switch (G) {
		case "Y":
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				if (participant.contains(s))
					continue;

				participant.add(s);
				play++;
			}
			break;
			
		case "F":
			int temp = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				if (participant.contains(s))
					continue;
				participant.add(s);
				temp++;
				
				if(temp == 2) {
					temp = 0;
					play++;
				}
			}
			break;
		
		case "O":
			temp = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				if (participant.contains(s))
					continue;
				participant.add(s);
				temp++;
				
				if(temp == 3) {
					temp = 0;
					play++;
				}
			}
			break;
		}

		System.out.println(play);
	}
}