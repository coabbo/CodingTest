import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] arr = new String[5][15];
		
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], "-1");
		}
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = String.valueOf(s.charAt(j));
				if(j == s.length()-1) {
					break;
				}
			}
		} //배열에 값 입력		
		
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[j][i] == "-1") {
					continue;
				}
				System.out.print(arr[j][i]);
			}
		}
	}
}