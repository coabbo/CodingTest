import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();
		
		Map<String, Integer> inputMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			String key = "" + input.charAt(i);
			if(!inputMap.containsKey(key)) {
				inputMap.put(key, 1);
			}
			else {
				inputMap.put(key, inputMap.get(key)+1);
			}
		}
		
		int max = 0;
		for (String key : inputMap.keySet()) {
			int num = inputMap.get(key);
			max = Math.max(num, max);
		}
		
		String answer = "";
		int count = 0;
		for (String key : inputMap.keySet()) {
			int num = inputMap.get(key);
			if(num == max) {
				answer = key;
				count += 1;
			}
		}
		
		if(count > 1) {
			System.out.println("?");
		} else {
			System.out.println(answer);
		}
	}
}