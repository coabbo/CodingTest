import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] first = {1, 2, 3, 4, 5};
        int temp1 = 0;
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int temp2 = 0;
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int temp3 = 0;
        
        // 정답일 경우 값을 더함
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i % 5]){
                temp1 += 1;
            }
            
            if(answers[i] == second[i % 8]){
                temp2 += 1;
            }
            
            if(answers[i] == third[i % 10]){
                temp3 += 1;
            }
        }
        
        int[] temp = {temp1, temp2, temp3};
        
        int max = 0;
        
        // 정답 개수가 가장 많은 값을 구함
        for(int i = 0 ; i < temp.length; i++){
            if(max < temp[i]){
                max = temp[i];
            } 
        }
        
        ArrayList<Integer> tempList = new ArrayList<>();
        // max의 값만큼 맞은 수포자를 리스트에 저장(인덱스는 0부터 시작하므로 + 1)
        for(int i = 0; i < temp.length; i++){
            if(max == temp[i]){
                tempList.add(i + 1);
            }
        }
        
        return tempList.stream().mapToInt(Integer::intValue).toArray();
    }
}