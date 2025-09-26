import java.util.*;

class Solution {
    static List<Integer>[] wins;
    static List<Integer>[] loses;
    static boolean[] visited;
    
    public int solution(int n, int[][] results) {
        wins = new ArrayList[n+1];
        loses = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            wins[i] = new ArrayList<>();
            loses[i] = new ArrayList<>();
        }
        
        // 1. 그래프 초기화
        for(int[] r : results) {
            int win = r[0];
            int lose = r[1];
            wins[win].add(lose); // win이 이긴 사람 기록
            loses[lose].add(win); // lose가 진 사람 기록
        }
        
        int answer = 0;
        
        // 2. 각 선수마다 탐색
        for(int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            
            // i가 이긴 사람 수
            int winCount = bfs(i, wins);
            
            // i가 진 사람 수
            int loseCount = bfs(i, loses);
            
            // 모든 상대와 승패 관계가 정해졌으면 순위 확정
            if(winCount + loseCount == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // BFS 탐색
    private int bfs(int start, List<Integer>[] graph) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        int count = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}