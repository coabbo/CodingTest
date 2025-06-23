import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[K]);
		arr[K] = 0;
		int count = 0;
		int curr = K;
		
		while(true) {
			if(list.size() == arr.length - 1) {
				break;
			}
			
			curr = (curr + 1) % (N + 1);
			if(arr[curr] != 0) {
				count++;
				
				if(count == K) {
					list.add(arr[curr]);
					arr[curr] = 0;
					count = 0;
				}
			}
		}
		
		sb.append("<");
		for (int i = 0; i < list.size(); i++) {
			if(i != list.size() - 1) {
				sb.append(list.get(i)).append(", ");
			}
			else {
				sb.append(list.get(i)).append(">");
			}
		}
		
		System.out.println(sb.toString());
	}
}