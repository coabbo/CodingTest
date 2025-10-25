import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> tree = new HashMap<>();
		
		int count = 0;
		while(true) {
			String s = br.readLine();
			if(s == null) break;
			
			tree.put(s, tree.getOrDefault(s, 0) + 1);
			count++;
		}
		
		List<String> treeList = new ArrayList<>(tree.keySet());
		Collections.sort(treeList);
		
		for (String t : treeList) {
			double percent = ((double) tree.get(t) / count) * 100;
			sb.append(t).append(" ").append(String.format("%.4f", percent)).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}