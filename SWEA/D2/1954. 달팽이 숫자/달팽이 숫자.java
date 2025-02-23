import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    static int[] dr = {0, 1, 0, -1}; //우하좌상
    static int[] dc = {1, 0, -1, 0};
     
    public static void main(String args[]) throws Exception
    {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine()); // 10개 테스트케이스
        for(int testCase = 1; testCase <= TC; testCase++) {
            int N = Integer.parseInt(br.readLine()); // 달팽이크기 1~10
            int[][] m = new int[N][N];
             
            int r = 0; // 행
            int c = 0; // 열
            int dir = 0; //우0 하1 좌2 상3
            int num = 1;
            int target = N * N;
            while(num <= target) { // 현재 방향으로 전진, 꺾는 조건 : 배열의 범위를 벗어나거나 다음 칸에 값이 있는 경우
                m[r][c] = num++;
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if(0 <= nr && nr < N && 0 <= nc && nc < N && m[nr][nc]==0) { // 전진 가능?
                    r = nr;
                    c = nc;
                } else { //갈 수 없음, 꺾어!
//                  dir = (dir + 1) % dr.length;
                    dir++;
                    if(dir == 4) dir = 0;
                     
                    r += dr[dir];
                    c += dc[dir];
                }
            }
            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    sb.append(m[i][j]).append(" ");
                }
                sb.append("\n");
            }
        } // end of for testCase
        System.out.println(sb.toString());
         
         
    } // end of main
} // end of class