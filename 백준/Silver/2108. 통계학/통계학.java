import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		
		int[] arr = new int[N];
		int[] freq = new int[8001]; // 빈도수 배열
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			freq[arr[i] + 4000]++;
		}
		
		Arrays.sort(arr);
		
		/** 산술평균 */
		double mean = 0;
		for (int i = 0; i < arr.length; i++) {
			mean += arr[i];
		}
		mean /= N;
		mean = Math.round(mean);
		
		sb.append((int) mean).append("\n");
		
		/** 중앙값 */
		int median = arr[N/2];
		sb.append(median).append("\n");
		
		/** 최빈값 */
		int mode = 0;
		
		// 최대 카운트 횟수 찾기
		int maxCount = 0;
		for (int count : freq) {
			maxCount = Math.max(maxCount, count);
		}

		// 최빈값 후보 리스트
		ArrayList<Integer> modeList = new ArrayList<Integer>();
		for (int i = 0; i < freq.length; i++) {
			if(freq[i] == maxCount) {
				modeList.add(i - 4000);
			}
		}
		
		// 최빈값 후보가 두 개 이상이라면 두 번째로 작은 값 찾기
		if(modeList.size() >= 2) {
			Collections.sort(modeList);
			mode = modeList.get(1);
		}
		else {
			mode = modeList.get(0);
		}
		
		sb.append(mode).append("\n");
		
		/** 범위 */
		int range = arr[N-1] - arr[0];
		sb.append(range).append("\n");
		
		System.out.println(sb.toString());
	}
}