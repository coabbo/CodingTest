import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		ArrayList<Integer> numList = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			numList.add((int) s.charAt(i) - '0');
		}
		
		int sum = 0;
		
		for (int i = 0; i < numList.size(); i++) {
			sum += numList.get(i);
		}
		
		System.out.println(sum);
	}
}