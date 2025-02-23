import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        for (int testCase = 1; testCase <= 10; testCase++) {
            int T = Integer.parseInt(br.readLine());
            char[][] matrix = new char[100][100];
 
            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
 
            int maxLen = 1;
 
            for (int i = 0; i < 100; i++) {
                char[] row = new char[100];
                char[] col = new char[100];
                for (int j = 0; j < 100; j++) {
                    row[j] = matrix[i][j];
                    col[j] = matrix[j][i]; 
                }
 
                // 행 검사
                for (int len = 100; len > 1; len--) {
                    for (int start = 0; start + len <= 100; start++) {
                        boolean isPalin = true;
                        int left = start;
                        int right = start + len - 1;
                        while (left < right) {
                            if (row[left] != row[right]) {
                                isPalin = false;
                                break;
                            }
                            left += 1;
                            right -= 1;
                        }
                        if (isPalin) {
                            maxLen = Math.max(maxLen, len);
                        }
                    }
                }
 
                // 열 검사
                for (int len = 100; len > 1; len--) {
                    for (int start = 0; start + len <= 100; start++) {
                        boolean isPalin = true;
                        int left = start;
                        int right = start + len - 1;
                        while (left < right) {
                            if (col[left] != col[right]) {
                                isPalin = false;
                                break;
                            }
                            left += 1;
                            right -= 1;
                        }
                        if (isPalin) {
                            maxLen = Math.max(maxLen, len);
                        }
                    }
                }
            }
 
            System.out.println("#" + T + " " + maxLen);
        }
    }
}