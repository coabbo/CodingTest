import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//              Main_백준_2000_제목_실버3_정민주_100ms
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력을 모아서 한번에 출력하기 위한 객체
         
        int TC = Integer.parseInt(br.readLine()); // 10개 테스트케이스
        for(int testCase = 1; testCase <= TC; testCase++) {
             
//      입력/출력 최적화
//          BufferedReader InputStreamReader
//          StringBuilder   /   BufferedWriter  OutputStreamWriter
             
//      쪼개기
//          String split(); 느려 : 정규화 표현식 해석
//          StringTokenizer 로 쪼갠다, 생성자는 " " 델리미터 넣어준다
            int[] num = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(st.nextToken()); // 0 이상 10000 이하의 정수
            }
             
            Arrays.sort(num); // 정렬 O[N log N], 최대값 O[N], 최소값 O[N]
            // 누적합
            int sum = 0;
            for(int i = 1; i <= 8; i++) {
                sum += num[i];
            }
            sb.append("#").append(testCase).append(" ")
                .append(String.format("%.0f", sum/8.)).append("\n");
        } //end of for testCase
        System.out.println(sb.toString());
    } // end of main
} // end of class