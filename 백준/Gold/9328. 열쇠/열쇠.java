import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int H;
    private static int W;
    private static char[][] map;
    private static boolean[][] visited;
    private static Set<Character> haveAlphabetList;
    private static Map<Character, List<int[]>> doors; // 보류된 대문자 알파벳을 저장하기 위한 맵
    private static int count;

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스의 개수

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H+2][W+2];

            // 가장자리를 '.'으로 감싸기
            for(int j = 0; j < W+2; j++){
                map[0][j] = '.';
            }

            for (int i = 1; i < H+1; i++) {
                String s = br.readLine();
                for (int j = 0; j < W+2; j++) {
                    if(j == 0 || j == W+1){
                        map[i][j] = '.';
                    }
                    else{
                        map[i][j] = s.charAt(j-1);
                    }
                }
            }

            for(int j = 0; j < W+2; j++){
                map[H+1][j] = '.';
            }

            haveAlphabetList = new HashSet<>(); // 소문자 알파벳을 저장할 리스트
            String haveAlphabet = br.readLine();
            if(!haveAlphabet.equals("0")) {
                for (int i = 0; i < haveAlphabet.length(); i++) {
                    haveAlphabetList.add(haveAlphabet.charAt(i));
                }
            }

            count = 0;
            doors = new HashMap<>();
            visited = new boolean[H+2][W+2];
            bfs(0, 0);
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nc < 0 || nr >= H+2 || nc >= W+2) continue;
                if(visited[nr][nc]) continue;

                if(map[nr][nc] >= 97 && map[nr][nc] <= 122) { // 알파벳 소문자(열쇠)일 경우
                    char key = map[nr][nc];
                    char door = (char)(map[nr][nc] - 32);

                    haveAlphabetList.add(key);
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = '.';

                    if(doors.containsKey(door)){ // 알파벳 대문자(문) 체크
                        for(int[] doorList : doors.get(door)){
                            int doorR = doorList[0];
                            int doorC = doorList[1];
                            q.add(new int[] {doorR, doorC});
                            visited[doorR][doorC] = true;
                            map[doorR][doorC] = '.';
                        }
                        doors.remove(door); // 연 문은 제거
                    }
                }

                if(map[nr][nc] >= 65 && map[nr][nc] <= 90) { // 알파벳 대문자(문)일 경우
                    char key = (char)(map[nr][nc] + 32);
                    char door = map[nr][nc];

                    if(haveAlphabetList.contains(key)){ // 해당하는 알파벳 소문자가 있을 경우
                        q.add(new int[] {nr, nc});
                        visited[nr][nc] = true;
                        map[nr][nc] = '.';
                    }
                    else{ // 해당하는 알파벳 소문자가 없는 경우
                        if(!doors.containsKey(door)) { // 기존에 저장되어 있는 알파벳 대문자가 없는 경우
                            doors.put(door, new ArrayList<>());
                        }
                        doors.get(door).add(new int[] {nr, nc});
                    }
                }

                if(map[nr][nc] == '.'){ // 갈 수 있는 길인 경우
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }

                if(map[nr][nc] == '$'){ // 문서인 경우
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                    map[nr][nc] = '.';
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}