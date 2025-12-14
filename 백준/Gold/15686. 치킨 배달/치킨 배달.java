import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int answer = Integer.MAX_VALUE;

	private static List<int[]> home;
	private static List<int[]> originalChicken;
	private static int[] chooseChicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 고를 수 있는 치킨집의 최대 개수
		
		home = new ArrayList<>(); // 집 위치 저장용 리스트
		originalChicken = new ArrayList<>(); // 원래 치킨집 위치 저장용 리스트
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1) {
					home.add(new int[] {i, j});
				}
				if(num == 2) {
					originalChicken.add(new int[] {i, j});
				}
			}
		}
		
		chooseChicken = new int[M]; // 선택된 치킨집의 인덱스를 저장하는 배열 (originalChicken의 인덱스)
		comb(0, 0);
		
		System.out.println(answer);
	}

	public static void comb(int start, int depth) {
		if(depth == M) {
			calculateDistance();
			return;
		}
		
		// 조합으로 M개 뽑기
		for (int i = start; i < originalChicken.size(); i++) {
			chooseChicken[depth] = i;
			comb(i + 1, depth + 1);
		}
	}

	public static void calculateDistance() {
		int tempDistance = 0;
		
		// 치킨집 M개 다 뽑았으면 치킨 거리 계산
		for (int i = 0; i < home.size(); i++) {
			int distance = Integer.MAX_VALUE;
			int[] homeLocation = home.get(i);
			
			for (int j = 0; j < chooseChicken.length; j++) {
				int idx = chooseChicken[j];
				int[] chickenLocation = originalChicken.get(idx);
				
				int temp = Math.abs(homeLocation[0] - chickenLocation[0]) + Math.abs(homeLocation[1] - chickenLocation[1]);
				distance = Math.min(distance, temp);
			}
			
			tempDistance += distance;
		}
		
		answer = Math.min(answer, tempDistance);
	}
}