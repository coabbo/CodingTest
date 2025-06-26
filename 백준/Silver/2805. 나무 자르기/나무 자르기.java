import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 집으로 가져가려고 하는 나무의 길이
		
		int[] tree = new int[N];
		int maxTree = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if(maxTree < tree[i]) {
				maxTree = tree[i];
			}
		}
		
		long low = 0;
		long high = maxTree;
		long answer = 0;
		while(low <= high) {
			long mid = (low + high) / 2;
			long length = 0;
			
			for (int i = 0; i < tree.length; i++) {
				if(tree[i] > mid) {
					length += tree[i] - mid;
				}
			}
			
			if(length >= M) {
				answer = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}