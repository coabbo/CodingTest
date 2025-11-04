import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        // 숫자를 String 형태로 저장해서 int 오버플로우 방지
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            String temp = "";
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);

                if(ch >= '0' && ch <= '9') {
                    temp += ch; // 숫자인 경우 temp에 추가
                }
                else {
                    if (temp.length() > 0) {
                        // 앞에 있는 0들을 제거
                        int zeroIndex = 0;

                        // temp가 "007"이면 zeroIndex는 2. "0"이면 0.
                        while (zeroIndex < temp.length() - 1 && temp.charAt(zeroIndex) == '0') {
                            zeroIndex++;
                        }

                        // 선행하는 0이 제거된 문자열을 list에 추가
                        list.add(temp.substring(zeroIndex));

                        temp = "";
                    }
                }
            }
            
            // 문장 마지막에 숫자가 남아있을 경우 처리
            if(temp.length() > 0) {
                // 앞에 있는 0들을 제거
                int zeroIndex = 0;

                // temp가 "007"이면 zeroIndex는 2. "0"이면 0.
                while(zeroIndex < temp.length() - 1 && temp.charAt(zeroIndex) == '0') {
                    zeroIndex++;
                }

                // 선행하는 0이 제거된 문자열을 list에 추가
                list.add(temp.substring(zeroIndex));
            }
        }

        // 커스텀 문자열 정렬 (길이 우선 -> 사전순)
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 길이가 다르면 짧은 것 먼저
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                }

                // 길이가 같으면 사전 순서
                return s1.compareTo(s2);
            }
        });

        for (String x : list) {
            sb.append(x).append("\n");
        }
        System.out.println(sb.toString());
    }
}