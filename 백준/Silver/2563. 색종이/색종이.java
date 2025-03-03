import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//넓이를 저장하는 변수
		int area = 0;
		
		//색종이의 수
		int N = Integer.parseInt(br.readLine());

		//색종이가 있는지를 확인할 boolean 배열
		boolean[][] isExist = new boolean[100][100];
		
		//x좌표를 모아놓을 리스트
		ArrayList<Integer> xList = new ArrayList<>();
		
		//y좌표를 모아놓을 리스트
		ArrayList<Integer> yList = new ArrayList<>();
		
		//색종이의 수만큼 반복
		for (int i = 0; i < N; i++) {
			//각각의 x좌표, y좌표를 입력받음
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//입력받은 x좌표, y좌표를 리스트에 넣음
			xList.add(x);
			yList.add(y);
		}
		
		//색종이의 수만큼 반복
		for (int i = 0; i < N; i++) {
			int startX = xList.get(i);
			int startY = yList.get(i);
			
			for (int j = startX; j < startX + 10; j++) {
				for (int k = startY; k < startY + 10; k++) {
					if(j >= 100 || k >= 100) continue;
					isExist[j][k] = true;
				}
			}
		}
		
		//true인 부분을 면적에 더함
		for (int i = 0; i < isExist.length; i++) {
			for (int j = 0; j < isExist[i].length; j++) {
				if(isExist[i][j]) {
					area += 1;
				}
			}
		}
		
		System.out.println(area);
	}
}