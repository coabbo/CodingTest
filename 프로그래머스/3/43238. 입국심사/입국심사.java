class Solution {
    public long solution(int n, int[] times) {
        long start = 1; // 최소 시간
        long end = 0; // 최악의 시간
        
        for(int time : times) {
            end = Math.max(end, (long) time * n);
        }
        
        long answer = end;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long people = 0;
            for(int time : times) {
                people += mid / time; // mid 시간 동안 심사관이 처리할 수 있는 사람의 수
            }
            
            if(people >= n) { // 충분히 처리 가능하면 시간을 줄여서 최소 시간 탐색
                answer = mid;
                end = mid - 1;
            }
            else { // 부족하면 시간을 늘림
                start = mid + 1;
            }
        }
        
        return answer;
    }
}