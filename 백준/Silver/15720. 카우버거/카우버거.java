import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		Integer[] burgers = new Integer[B];
		Integer[] sides = new Integer[C];
		Integer[] drinks = new Integer[D];
		
		int totalBefore = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < burgers.length; i++) {
			burgers[i] = Integer.parseInt(st.nextToken());
			totalBefore += burgers[i];
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < sides.length; i++) {
			sides[i] = Integer.parseInt(st.nextToken());
			totalBefore += sides[i];
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < drinks.length; i++) {
			drinks[i] = Integer.parseInt(st.nextToken());
			totalBefore += drinks[i];
		}
		
		Arrays.sort(burgers, Collections.reverseOrder());
        Arrays.sort(sides, Collections.reverseOrder());
        Arrays.sort(drinks, Collections.reverseOrder());
        
        int setMenu = Math.min(B, Math.min(C, D));
        
        int totalAfter = 0; 
		
		for (int i = 0; i < setMenu; i++) {
			totalAfter += (burgers[i] + sides[i] + drinks[i]) * 0.9;
		}
		
		for (int i = setMenu; i < B; i++) totalAfter += burgers[i];
        for (int i = setMenu; i < C; i++) totalAfter += sides[i];
        for (int i = setMenu; i < D; i++) totalAfter += drinks[i];

        System.out.println(totalBefore);
        System.out.println(totalAfter);
	}
}