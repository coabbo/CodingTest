import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String s1 = st.nextToken();
			if(s1.equals("#")) break;
			
			String s2 = "";
			while(st.hasMoreTokens()) {
				s2 += st.nextToken().toLowerCase();
			}
			
			int count = 0;
			for (int i = 0; i < s2.length(); i++) {
				char c = s2.charAt(i);
				
				if(s1.equals(c + "")) count++;
			}
			
			sb.append(s1).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}