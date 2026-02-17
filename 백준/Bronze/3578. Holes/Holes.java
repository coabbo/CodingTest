import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int h = Integer.parseInt(br.readLine());

		if (h == 0) sb.append(1);
		else if(h == 1) sb.append(0);
		else {
			if (h % 2 == 0) {
				for (int i = 0; i < h / 2; i++) {
					sb.append(8);
				}
			}
			else {
				sb.append(4);
				
				for (int i = 0; i < h / 2; i++) {
					sb.append(8);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}