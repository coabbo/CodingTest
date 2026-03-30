import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int syear = Integer.parseInt(st.nextToken());
		int smonth = Integer.parseInt(st.nextToken());
		int sday = Integer.parseInt(st.nextToken());
		
		int man = syear - year;
		if (smonth < month || (smonth == month && sday < day)) man--;
		System.out.println(man);
		
		System.out.println(syear - year + 1);
		
		System.out.println(syear - year);
	}
}