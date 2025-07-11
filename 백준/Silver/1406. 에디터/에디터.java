import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        LinkedList<Character> list = new LinkedList<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        ListIterator<Character> it = list.listIterator(list.size());

        int M = Integer.parseInt(br.readLine()); // 명령어의 개수
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "L":
                    if(it.hasPrevious()) it.previous();
                    break;
                case "D":
                    if(it.hasNext()) it.next();
                    break;
                case "B":
                    if(it.hasPrevious()) {
                        it.previous();
                        it.remove();
                    }
                    break;
                case "P":
                    String x = st.nextToken();
                    it.add(x.charAt(0));
                    break;
            }
        }

        for(Character c : list){
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}