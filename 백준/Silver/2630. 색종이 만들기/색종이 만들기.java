import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] paper;
	private static int whitePaper;
	private static int bluePaper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		whitePaper = 0;
		bluePaper = 0;
		
		StringTokenizer st;
		for (int i = 0; i < paper.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < paper.length; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		part(0, 0, N);
		
		System.out.println(whitePaper);
		System.out.println(bluePaper);
	}

	public static void part(int r, int c, int N) {
		if(check(r, c, N)) {
			if(paper[r][c] == 0) {
				whitePaper++;
			}
			else {
				bluePaper++;
			}
			return;
		}
		
		int half = N / 2;
		part(r, c, half);
		part(r, c + half, half);
		part(r + half, c, half);
		part(r + half, c + half, half);
	}

	public static boolean check(int r, int c, int N) {

		int color = paper[r][c];
		
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if(paper[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
}