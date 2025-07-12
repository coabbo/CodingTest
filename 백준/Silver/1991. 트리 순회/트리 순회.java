import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		char data;
		Node left;
		Node right;
		
		public Node(char data) {
			this.data = data;
		}
	}

	private static Map<Character, Node> nodes = new HashMap<>();
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 이진 트리 노드의 개수
		
		// 노드 객체 생성
		for (char c = 'A'; c < 'A' + N; c++) {
			nodes.put(c, new Node(c));
		}
		
		// 트리 연결
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char parentNode = st.nextToken().charAt(0);
			char leftNode = st.nextToken().charAt(0);
			char rightNode = st.nextToken().charAt(0);
			
			Node parent = nodes.get(parentNode);
			if (leftNode != '.') parent.left = nodes.get(leftNode);
			if (rightNode != '.') parent.right = nodes.get(rightNode);
		}
		
		preOrder(nodes.get('A')); // 전위 순회
		sb.append("\n");
		
		inOrder(nodes.get('A')); // 중위 순회
		sb.append("\n");
		
		postOrder(nodes.get('A')); //후위 순회
		sb.append("\n");
		
		System.out.println(sb.toString());
	}

	public static void preOrder(Node curr) {
		if(curr == null) return;
		
		sb.append(curr.data);
		preOrder(curr.left);
		preOrder(curr.right);
	}
	
	public static void inOrder(Node curr) {
		if(curr == null) return;
		
		inOrder(curr.left);
		sb.append(curr.data);
		inOrder(curr.right);
	}
	
	public static void postOrder(Node curr) {
		if(curr == null) return;
		
		postOrder(curr.left);
		postOrder(curr.right);
		sb.append(curr.data);
	}
}