import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final int N = 9;
	static int[] kyuyoungCard;
	static int[] inyoungCard;
	static int kyuyoungWin;
	static int kyuyoungLose;
	static boolean[] visited; //방문 여부
	static int[] perm; //현재 순열
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for (int testCase = 1; testCase <= T; testCase++) {
			kyuyoungCard = new int[N];
			inyoungCard = new int[N];
	
			StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
			for (int i = 0; i < kyuyoungCard.length; i++) {
				kyuyoungCard[i] = Integer.parseInt(st.nextToken());
			} //규영이 카드 입력
			
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				boolean check = true;
				for (int kyuyoungHaveCard : kyuyoungCard) {
					if(i == kyuyoungHaveCard) {
						check = false;
					}
				}
				if(check) {
					inyoungCard[idx++] = i;
				}
			} //인영이 카드 입력
			
			visited = new boolean[N];
			perm = new int[N];
			kyuyoungWin = 0;
			kyuyoungLose = 0;
			
			perm(0);
			
			System.out.println("#" + testCase + " " + kyuyoungWin + " " + kyuyoungLose);
		}	
 	}

	
	static void perm(int idx) {
		if(idx == N) {	
			int kyuyoungScore = 0;
			int inyoungScore = 0;
			
			for(int i = 0; i < N; i++) {
				int kyCard = kyuyoungCard[i];
				int iyCard = perm[i];
				
				if(kyCard > iyCard) {
					kyuyoungScore += kyCard + iyCard;
				} else if(kyCard < iyCard) {
					inyoungScore += kyCard + iyCard;							
				}
			}
			
			if(kyuyoungScore > inyoungScore) {
				kyuyoungWin++;
			} else if(kyuyoungScore < inyoungScore) {
				kyuyoungLose++;
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			perm[idx] = inyoungCard[i];
			perm(idx+1);
			visited[i] = false;
		}
	}	
}