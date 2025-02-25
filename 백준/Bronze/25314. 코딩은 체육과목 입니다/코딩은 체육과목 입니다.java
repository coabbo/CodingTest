
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp = (N - 4) / 4;
		
		for (int i = 0; i < temp; i++) {
			System.out.print("long ");
		}
		
		System.out.println("long int");
	}
}