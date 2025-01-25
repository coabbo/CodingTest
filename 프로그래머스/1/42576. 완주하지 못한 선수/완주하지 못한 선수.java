import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();
        
        // 참가자 배열을 HashMap에 저장
        for(String p : participant){
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }
        
        // 완주자 배열을 HashMap에서 차감
        for(String c : completion){
            participantMap.put(c, participantMap.get(c) - 1);
        }
        
        // HashMap에서 값이 0이 아닌 참가자를 찾기
        for(Map.Entry<String, Integer> entry : participantMap.entrySet()){
            if(entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}