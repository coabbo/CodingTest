import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 빌딩의 수

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] height = new int[N]; // 빌딩의 높이
		for (int i = 0; i < height.length; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		
		for (int curr = 0; curr < height.length; curr++) {
			int count = 0;
			
			// 왼쪽
			double maxSlopeLeft = Integer.MAX_VALUE;
			for (int left = curr - 1; left >= 0; left--) {
				double slope = (height[curr] - height[left]) / (double)(curr - left);
				
				if(slope < maxSlopeLeft) {
					count++;
					maxSlopeLeft = slope;
				}
			}
			
			// 오른쪽
			double maxSlopeRight = -Integer.MAX_VALUE;
			for (int right = curr + 1; right < height.length; right++) {
				double slope = (height[curr] - height[right]) / (double)(curr - right);
				
				if(slope > maxSlopeRight) {
					count++;
					maxSlopeRight = slope;
				}
			}
			
			answer = Math.max(answer, count); // 최댓값 교체
		}
		
		System.out.println(answer);
	}
}