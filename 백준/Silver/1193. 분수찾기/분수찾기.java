import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int count = 1;
        int crossLine = 0;
        
        
        int X = Integer.parseInt(br.readLine());
        
        while(true) {
        	if(X <= crossLine + count) {
        		if(count % 2 == 1) {
        			System.out.println(count-(X-crossLine-1) + "/" + (X-crossLine));
        			break;
        		}
        		else {
        			System.out.println((X-crossLine) + "/" + (count-(X-crossLine-1)));
        			break;
        		}
        	} else {
        		crossLine += count;
        		count++;
        	}
        }
    }
}