import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> speedList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        
        int temp = 0;
        
        // Queue에 작업 진도 값 넣기
        for(int work : progresses){
            queue.offer(work);
        }
        
        // speed를 List로 바꾸기
        for(int speed : speeds){
            speedList.add(speed);
        }
        
        // 임시로 Queue값을 저장할 리스트 생성
        List<Integer> tempList = new ArrayList<>(queue);
        
        while(!queue.isEmpty()){
            
            // tempList에 작업 진도에 작업 속도를 더한 값을 저장 
            for(int t = 0; t < tempList.size(); t++){
                tempList.set(t, tempList.get(t) + speedList.get(t));
            }
            
            // 인덱스가 0인 값이 100이 넘을 경우
            if(tempList.get(0) >= 100){
                temp += 1;
                tempList.remove(0); // tempList에서 해당 인덱스 값 제거
                speedList.remove(0); // speedList에서 해당 인덱스 값 제거
                queue.poll(); // queue에서 제거
             
                // 기존 리스트에서 인덱스 0인 것 바로 뒤에 있던 것이 100이 넘는 값 있는지 확인
                for(int j = 0; j < tempList.size(); j++){
                    if(tempList.get(j) >= 100){
                        temp += 1;
                        tempList.remove(j); // tempList에서 값 제거
                        speedList.remove(j); // speedList에서 값 제거
                        queue.poll(); // queue에서 제거
                        j = j - 1; // j값이 0을 유지할 수 있게 조정
                    }
                    else{ // 바로 뒤에 100 넘는 값이 없을 경우
                        break; // for문 빠져나감
                    }
                }
            }   
                
            if(temp != 0){ // temp가 0이 아닐 때만 answerList에 저장
                answerList.add(temp);
            }
            
            temp = 0; // temp를 0으로 바꿈
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}