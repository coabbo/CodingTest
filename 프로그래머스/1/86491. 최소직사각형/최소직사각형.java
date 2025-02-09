class Solution {
    public int solution(int[][] sizes) {
        
        int width = 0;
        int height = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > width){
                width = sizes[i][0];
            }
            if(sizes[i][1] > height){
                height = sizes[i][1];
            }
        }
        
        return width * height;
    }
}