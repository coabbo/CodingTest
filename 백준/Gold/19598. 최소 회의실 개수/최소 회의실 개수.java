import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Meeting implements Comparable<Meeting> {
		int startTime, endTime;
		
		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Meeting o) {
			if(this.startTime == o.startTime) {
				return Integer.compare(this.endTime, o.endTime);
			}
			
			return Integer.compare(this.startTime, o.startTime);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			
			pq.add(new Meeting(startTime, endTime));
		}
		
		PriorityQueue<Integer> meetingEndTime = new PriorityQueue<>(); // 회의실 별 종료 시간 관리
		while(!pq.isEmpty()) {
			Meeting curr = pq.poll();
			
			if(!meetingEndTime.isEmpty() && meetingEndTime.peek() <= curr.startTime) {
				meetingEndTime.poll();
			}
			
			meetingEndTime.add(curr.endTime); // 현재 회의 종료 시간 등록
		}
		
		System.out.println(meetingEndTime.size());
	}
}