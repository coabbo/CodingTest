import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		int N = Integer.parseInt(br.readLine()); //상근이가 가지고 있는 숫자 카드 개수
		int[] haveCard = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < haveCard.length; i++) {
			haveCard[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine()); //체크해야 할 숫자 개수
		int[] checkCard = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < checkCard.length; i++) {
			checkCard[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int card : haveCard) {
			countMap.put(card, countMap.getOrDefault(card, 0) + 1);
		}
		
		for (int i = 0; i < checkCard.length; i++) {
			if(countMap.containsKey(checkCard[i])) {
				sb.append(countMap.get(checkCard[i])).append(" ");
			}
			else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb.toString());
	}
}
