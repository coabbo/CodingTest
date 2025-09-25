import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 1. 여분 있는 사람이 자기 체육복을 잃어버린 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        int answer = n;
        
        // 2. 여분 빌려주기
        for(int i = 0; i < lost.length; i++) {
            if(lost[i] == -1) continue;
            
            for(int j = 0; j < reserve.length; j++) {
                if(reserve[j] == -1) continue;
                
                if(reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        // 3. 최종 answer 계산
        for(int l : lost) {
            if(l != -1) answer--;
        }
        
        return answer;
    }
}