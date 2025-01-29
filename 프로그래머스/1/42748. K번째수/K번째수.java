import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();
        int[] tempArray = new int[array.length];
        
        for(int i = 0; i < commands.length; i++){    
            int first = commands[i][0] - 1;
            int second = commands[i][1];
            int index = commands[i][2] - 1; 
            
            tempArray = Arrays.copyOfRange(array, first, second);
            
            Arrays.sort(tempArray);
            
            answerList.add(tempArray[index]);
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}