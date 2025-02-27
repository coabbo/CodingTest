import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		double[] originNumArr = new double[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < originNumArr.length; i++) {
			originNumArr[i] = Double.parseDouble(st.nextToken());
		}
				
		Arrays.sort(originNumArr);
		
		double max = originNumArr[N-1];
		double newMean = 0;
		
		for (int i = 0; i < originNumArr.length; i++) {
			double newNum = (originNumArr[i] / max) * 100;
			newMean = newMean + newNum;
		}
		
		double answer = newMean / N;
		
		System.out.println(answer);
	}
}