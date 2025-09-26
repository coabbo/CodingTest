import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int m = edge.length;
        
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] dist = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        // 간선 입력
        for(int i = 0; i < m; i++) {
            int A = edge[i][0];
            int B = edge[i][1];
            graph[A].add(B);
            graph[B].add(A);
        }
        
        // BFS 시작
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1); // 1번 노드에서 시작
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next : graph[curr]) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    dist[next] = dist[curr] + 1;
                }
            }
        }
        
        // 최댓값 거리 찾기
        int maxDist = 0;
        for(int d : dist) {
            maxDist = Math.max(maxDist, d);
        }
        
        // 가장 먼 노드 개수 세기
        int answer = 0;
        for(int d : dist) {
            if(d == maxDist) answer++;
        }
        
        return answer;
    }
}