import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		ArrayList<String> calculationList = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '-') {
				temp += s.charAt(i);
			}
			else {
				calculationList.add(temp);
				temp = "";
			}
		}
		calculationList.add(temp);
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (String c : calculationList) {
			if(c.contains("+")) {
				String[] plusArr = c.split("\\+");
				
				int sum = 0;
				for (int i = 0; i < plusArr.length; i++) {
					sum += Integer.parseInt(plusArr[i]);
				}
				numList.add(sum);
			}
			else {
				numList.add(Integer.parseInt(c));
			}
		}
		
		int answer = numList.get(0);
		for (int i = 1; i < numList.size(); i++) {
			answer -= numList.get(i);
		}
		
		System.out.println(answer);
	}
}