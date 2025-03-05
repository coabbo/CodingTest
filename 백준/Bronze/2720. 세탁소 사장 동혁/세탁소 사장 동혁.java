import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int Dollar = Integer.parseInt(br.readLine());
			
			int Quarter = 25;
			int Dime = 10;
			int Nickel = 5;
			int Penny = 1;
			
			int countQuarter = 0;
			int countDime = 0;
			int countNickel = 0;
			int countPenny = 0;
			
			while(Dollar != 0) {
				if(Dollar >= Quarter) {
					Dollar = Dollar-Quarter;
					countQuarter++;
				} else if(Dollar >= Dime) {
					Dollar = Dollar-Dime;
					countDime++;
				} else if(Dollar >= Nickel) {
					Dollar = Dollar-Nickel;
					countNickel++;
				} else if(Dollar >= Penny) {
					Dollar = Dollar-Penny;
					countPenny++;
				}
			}
			
			System.out.println(countQuarter + " " + countDime + " " + countNickel + " " + countPenny);
		}
	}
}