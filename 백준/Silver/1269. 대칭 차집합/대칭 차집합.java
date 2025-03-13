import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //집합 A의 원소의 개수
		int M = Integer.parseInt(st.nextToken()); //집합 B의 원소의 개수
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		Set<Integer> A2 = new HashSet<>();
		Set<Integer> B2 = new HashSet<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			A.add(temp);
			A2.add(temp);
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			B.add(temp);
			B2.add(temp);
		}
		
		//A - B	차집합
		A.removeAll(B);
	
		//B - A 차집합
		B2.removeAll(A2);
		
		//합집합
		A.addAll(B2);
		
		sb.append(A.size());
		
		System.out.println(sb.toString());
	}
}