import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<String> sList = new ArrayList<>();
		
		while(st.hasMoreTokens()) {
			sList.add(st.nextToken());
		}
		
		System.out.println(sList.size());
	}
}