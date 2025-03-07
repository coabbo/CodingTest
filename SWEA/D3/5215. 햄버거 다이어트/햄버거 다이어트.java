import java.util.Scanner;

public class Solution {

	static int N, L; //N : 재료의 수, L : 제한 칼로리
	static int[] cals;
	static int[] scores;
	static int ans;
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			cals = new int[N];
			
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}//input 끝
			
			ans = 0;
			
			make(0, 0, 0);
			System.out.println("#" + tc + " " + ans);
		}//tc
    }//main
    
    //1. 비트마스킹
    //2. 재귀함수 부분집합
    //3. 백트래킹
    
    static void make(int idx, int sumCal, int sumScore) {
    	if(sumCal > L) return; //idx-1번까지의 재료를 이용하여 만들었는데....
    	
    	if(idx == N) {
    		//베스트인지는 모르겠지만 일단 햄버거는 만들어졌다!
    		if(ans < sumScore)
    			ans = sumScore; //갱신
    		return;
    	}
    	//뽑는 경우
    	make(idx+1, sumCal + cals[idx], sumScore + scores[idx]);
    	//안뽑는 경우
    	make(idx+1, sumCal, sumScore);
    }   
}