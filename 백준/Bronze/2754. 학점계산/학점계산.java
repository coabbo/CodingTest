import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String grade = br.readLine();
		
		Map<String, Double> gradeMap = new HashMap<String, Double>();
		gradeMap.put("A+", 4.3);
		gradeMap.put("A0", 4.0);
		gradeMap.put("A-", 3.7);
		gradeMap.put("B+", 3.3);
		gradeMap.put("B0", 3.0);
		gradeMap.put("B-", 2.7);
		gradeMap.put("C+", 2.3);
		gradeMap.put("C0", 2.0);
		gradeMap.put("C-", 1.7);
		gradeMap.put("D+", 1.3);
		gradeMap.put("D0", 1.0);
		gradeMap.put("D-", 0.7);
		gradeMap.put("F", 0.0);

		System.out.println(gradeMap.get(grade));
	}
}