import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Student implements Comparable<Student> {
		int number, count, time;
		
		public Student(int number, int count, int time) {
			this.number = number;
			this.count = count;
			this.time = time;
		}

		@Override
		public int compareTo(Student o) {
			if(this.count == o.count) {
				return Integer.compare(this.time, o.time);
			}
			return Integer.compare(this.count, o.count);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 사진틀의 개수
		int recommend = Integer.parseInt(br.readLine()); // 전체 학생의 총 추천 횟수
		
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		PriorityQueue<Student> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < recommend; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(x)) {
				Student s = map.get(x);
				s.count++;
				pq.remove(s);
				pq.add(s);
			}
			else {
				if(pq.size() == N) {
					Student remove = pq.poll();
					map.remove(remove.number);
				}
				
				Student s = new Student(x, 1, i);
				pq.add(s);
				map.put(x, s);
			}
		}
		
		int[] candidate = new int[N];
		int index = 0;
		for (int num : map.keySet()) {
			candidate[index++] = num;
		}
		Arrays.sort(candidate);
		
		for (int i = 0; i < candidate.length; i++) {
			if(i == candidate.length - 1 && candidate[i] != 0) sb.append(candidate[i]);
			else if(candidate[i] != 0) sb.append(candidate[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}