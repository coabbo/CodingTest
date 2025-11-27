import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int index, cost;

        Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // 비용이 작은 것이 우선순위를 가짐
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static List<Node>[] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        visited = new boolean[N + 1];

        System.out.println(prim(1));
    }

    private static int prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int totalCost = 0;

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int nowIndex = curr.index;

            // 이미 방문한 곳이면 스킵
            if(visited[nowIndex]) continue;

            visited[nowIndex] = true;
            totalCost += curr.cost;

            for(Node next : graph[nowIndex]) {
                if(!visited[next.index]) {
                    pq.offer(next);
                }
            }
        }

        return totalCost;
    }
}