class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n+1][n+1];
        
        // 1. 그래프 초기화
        for(int[] result : results) {
            int win = result[0];
            int lose = result[1];
            
            graph[win][lose] = 1; // win이 lose를 이김
            graph[lose][win] = -1; // lose는 win에게 짐
        }
        
        // 2. 플로이드 워셜로 승패 관계 전파
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    
                    if(graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        // 3. 순위 확정 가능한 선수 세기
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int count = 0;
            
            for(int j = 1; j <= n; j++) {
                if(graph[i][j] != 0) count++;
            }
            
            if(count == n-1) answer++;
        }
        
        return answer;
    }
}