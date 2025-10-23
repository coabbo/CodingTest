import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Word implements Comparable<Word> {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Word o) {
            // 1. 빈도 내림차순
            if(o.count != this.count) {
                return o.count - this.count;
            }

            // 2. 길이 내림차순
            if(o.word.length() != this.word.length()) {
                return o.word.length() - this.word.length();
            }

            // 3. 사전순 오름차순
            return this.word.compareTo(o.word);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 단어 빈도 계산
        Map<String, Integer> wordMap = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String temp = br.readLine();

            if(temp.length() >= M) {
                wordMap.put(temp, wordMap.getOrDefault(temp, 0) + 1);
            }
        }

        // 2. 정렬을 위해 List 생성
        List<Word> wordList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            wordList.add(new Word(entry.getKey(), entry.getValue()));
        }

        // Word 클래스에 구현된 compareTo 기준에 따라 정렬
        Collections.sort(wordList);

        StringBuilder sb = new StringBuilder();
        for(Word word : wordList) {
            sb.append(word.word).append("\n");
        }

        System.out.println(sb.toString());
    }
}