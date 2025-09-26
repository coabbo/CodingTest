class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow; 
        
        int width = 0;
        int height = 0;
        
        for(int i = 1; i <= sum; i++) {
            if(sum % i == 0) {
                height = i;
                width = sum / i;
                
                if(height > width) break;
            }
            
            // 안쪽이 yellow인지 확인
            if((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;   
            }
        }
        
        return answer;
    }
}