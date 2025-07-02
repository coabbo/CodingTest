import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;
		
		@Override
		public int compareTo(Meeting o) {
			if(this.end != o.end) {
				return Integer.compare(this.end, o.end); // 종료 시간이 빠른 순
			}
			return Integer.compare(this.start, o.start); // 종료 시간이 같으면, 시작 시간이 빠른 순
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 회의 개수
		
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			meetings[i] = new Meeting();
			meetings[i].start = Integer.parseInt(st.nextToken());
			meetings[i].end = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings);
		
		int count = 0;
		int lastEnd = 0;
		for (Meeting m : meetings) {
			if(m.start >= lastEnd) {
				count++;
				lastEnd = m.end;
			}
		}
		
		System.out.println(count);
	}
}