import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int numA = Integer.parseInt(st.nextToken());
		int numB = Integer.parseInt(st.nextToken());
		
		Set<Integer> A = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < numA; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		Set<Integer> B = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < numB; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		Set<Integer> C = new TreeSet<Integer>();
		for (Integer num : A) {
			if(!B.contains(num)) {
				C.add(num);
			}
		}
		
		sb.append(C.size()).append("\n");
		
		if(C.size() != 0) {
			for (Integer num : C) {
				sb.append(num).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}