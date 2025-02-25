
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		if(minute < 45) {
			hour -= 1;
			if(hour < 0) {
				hour = 23;
			}
			minute = minute + 60 - 45;
			System.out.println(hour + " " + minute);
		} else {
			minute = minute - 45;
			System.out.println(hour + " " + minute);
		}
	}
}