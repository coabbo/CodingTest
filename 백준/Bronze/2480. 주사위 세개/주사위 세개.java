
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		int third = Integer.parseInt(st.nextToken());
		
		if(first == second && second == third) {
			System.out.println(10000 + (first  * 1000));
		} else if(first == second && second != third) {
			System.out.println(1000 + (first * 100));
		} else if(first != second && second == third) {
			System.out.println(1000 + (second * 100));
		} else if(first == third && second != third) {
			System.out.println(1000 + (first * 100));
		} else if(first != second && second != third) {
			int[] temp = new int[3];
			temp[0] = first;
			temp[1] = second;
			temp[2] = third;
			Arrays.sort(temp);
			System.out.println(temp[2] * 100);
		}
	}
}