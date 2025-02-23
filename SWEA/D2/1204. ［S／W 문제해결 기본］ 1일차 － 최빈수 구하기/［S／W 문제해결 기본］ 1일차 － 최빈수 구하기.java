import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] studentGradeArr = new int[1000];
 
        for(int test_case = 1; test_case <= T; test_case++)
        {   
            int[] scoreCount = new int[100+1];
            int test_num = Integer.parseInt(br.readLine());
             
            String[] grades = br.readLine().split(" ");
            for(int i = 0; i < grades.length; i++) {
                studentGradeArr[i] = Integer.parseInt(grades[i]);
            }
             
            for(int i = 0; i < studentGradeArr.length; i++) {
                scoreCount[studentGradeArr[i]]++;
            }
 
            int max = scoreCount[0];
            int idx = 0;
            for(int i = 1; i < scoreCount.length; i++) {
                if(max <= scoreCount[i]) {
                    max = scoreCount[i];
                    idx = i;
                }
            }
            System.out.println("#" + test_num + " " + idx);
        }
    }
}