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
		
		int groupSize = 0;
		switch (G) {
			case "Y":
				groupSize = 1;
				break;
			case "F":
				groupSize = 2;
				break;
			case "O":
				groupSize = 3;
				break;
			}

		Set<String> participant = new HashSet<>();
		int play = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if(participant.add(name)) {
				count++;
				if(count == groupSize) {
					play++;
					count = 0;
				}
			}
		}
		
		System.out.println(play);
	}
}