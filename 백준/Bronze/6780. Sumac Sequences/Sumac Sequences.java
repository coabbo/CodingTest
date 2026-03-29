import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t1 = Integer.parseInt(br.readLine());
		int t2 = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		list.add(t1);
		list.add(t2);
		
		int index = 1;
		while(true) {
			int t = list.get(index - 1) - list.get(index);
			
			if(t >= 0) {
				list.add(t);
				index++;
			}
			else {
				break;
			}
		}
		
		System.out.println(list.size());
	}
}