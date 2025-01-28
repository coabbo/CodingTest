import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<>();
        q.offer(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            if(arr[i-1] != arr[i]){
                q.offer(arr[i]);
            }
        }
        
        // Integer 자료형의 collection을 int 배열로 변환
        answer = q.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}