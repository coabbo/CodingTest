import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 강의의 수
		int M = Integer.parseInt(st.nextToken()); // 블루레이의 수
		
		int[] lecture = new int[N];
		int lectureSum = 0;
		int maxLength = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < lecture.length; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			lectureSum += lecture[i];
			
			if(maxLength < lecture[i]) {
				maxLength = lecture[i];
			}
		}
		
		long low = maxLength;
		long high = lectureSum;
		long answer = 0;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			int count = 1;
			long sum = 0;
			
			for (int x : lecture) {
				if(sum + x > mid) {
					count++; // 새 블루레이 하나 추가
					sum = x; // x부터 다시 시작
				}
				else {
					sum += x;
				}
			}
			
			if(count <= M) {
				answer = mid;
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}