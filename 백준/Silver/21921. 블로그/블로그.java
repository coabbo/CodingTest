import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 블로그를 시작하고 지난 일수
		int X = Integer.parseInt(st.nextToken()); // X일
		int[] visitor = new int[N]; // 방문자 수 배열  
		Map<Integer, Integer> map = new HashMap<>(); // 구간별 합과 카운트를 구할 Map
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			visitor[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += visitor[i]; // 첫번째 구간의 합
		}
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		
		int maxSum = sum;
		int start = 0;
		for (int end = X; end < N; end++) {
			sum -= visitor[start++];
			sum += visitor[end];
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			maxSum = Math.max(maxSum, sum);
		}
		
		if(maxSum != 0) {
			System.out.println(maxSum);
			System.out.println(map.get(maxSum));
		} else {
			System.out.println("SAD");
		}
	}
}