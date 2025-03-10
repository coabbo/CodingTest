
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
		
		int needMinute = Integer.parseInt(br.readLine());
		int needHour = needMinute / 60;
		needMinute = needMinute % 60;
		
		hour += needHour;
		minute += needMinute;
		
		if(minute >= 60) {
			hour += 1;
			minute -= 60;
		}
		
		if(hour >= 24) {
			hour -= 24;
		}
		
		System.out.println(hour + " " + minute);
	}
}