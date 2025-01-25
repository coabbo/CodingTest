import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> setList = new HashSet<>();
                
        int canHavePoketmonNum = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++){
            setList.add(nums[0]);
            if(nums[0] != nums[i]){
                setList.add(nums[i]);
            }
        }
        
        if(setList.size() >= canHavePoketmonNum){
            answer = canHavePoketmonNum;
        } else{
            answer = setList.size();
        }
        
        return answer;
    }
}