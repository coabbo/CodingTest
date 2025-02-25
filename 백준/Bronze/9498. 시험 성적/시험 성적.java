
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num = Integer.parseInt(st.nextToken());
		
		if(num >= 90 && 100 >= num) {
			System.out.println("A");
		} else if(num >= 80 && 89 >= num){
			System.out.println("B");
		} else if(num >= 70 && 79 >= num){
			System.out.println("C");
		} else if(num >= 60 && 69 >= num){
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
}