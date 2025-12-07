import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		
		int[] potato = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < potato.length; i++) {
			potato[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(potato);
		
		int left = 0;
		int right = N - 1;
		
		int pPotato = 0;
		int sPotato = 0;
		
		boolean pTurn = true;
		while(left <= right) {
			if(pTurn) {
				pPotato += potato[right--];
			}
			else {
				sPotato += potato[left++];
			}
			
			pTurn = !pTurn;
		}
		
		System.out.println(sPotato + " " + pPotato);
	}
}