import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] xy = new int[N][2];
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			xy[idx][0] = Integer.parseInt(st.nextToken());
			xy[idx][1] = Integer.parseInt(st.nextToken());
			
			idx++;
		}
		
		Arrays.sort(xy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]!=o2[1] ? o1[1]-o2[1] : o1[0]-o2[0]; // 두번째 기준 오름차순 > 첫번째 기준 오름차순
			}
		});
		
		for (int i = 0; i < xy.length; i++) {
			System.out.println(xy[i][0] + " " + xy[i][1]);
		}
	}
}