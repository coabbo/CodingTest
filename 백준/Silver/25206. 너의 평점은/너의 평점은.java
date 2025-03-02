import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Double> gradeMap = new LinkedHashMap<>();
		gradeMap.put("A+", 4.5);
		gradeMap.put("A0", 4.0);
		gradeMap.put("B+", 3.5);
		gradeMap.put("B0", 3.0);
		gradeMap.put("C+", 2.5);
		gradeMap.put("C0", 2.0);
		gradeMap.put("D+", 1.5);
		gradeMap.put("D0", 1.0);
		gradeMap.put("F", 0.0);
		
		Double creditSum = 0.0;
		Double allSum = 0.0;
		Double answer = 0.0;
		
		for (int testCase = 0; testCase < 20; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String subject = st.nextToken(); //과목명
			Double credit = Double.valueOf(st.nextToken()); //학점 단위
			String grade = st.nextToken(); //등급
			
			Double score = gradeMap.get(grade);
			
			if(score == null) {
				continue;
			}
			
			allSum += credit * score;
			creditSum += credit;
		}
		
		answer = allSum / creditSum;
		System.out.println(answer);
	}
}