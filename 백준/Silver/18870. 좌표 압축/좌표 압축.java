import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] inputArr = new int[N];
		Set<Integer> setList = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
			setList.add(inputArr[i]);
		}
		
		Integer[] arr = setList.toArray(new Integer[0]);
		
		Arrays.sort(arr);
		
		//이분탐색
		for (int i = 0; i < inputArr.length; i++) {
			int findNum = inputArr[i];
			
			int start = 0;
			int end = arr.length - 1;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(findNum < arr[mid]) {
					end = mid - 1;
				}
				else if(findNum > arr[mid]) {
					start = mid + 1;
				}
				else {
					bw.write(mid+" ");
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
	}
}