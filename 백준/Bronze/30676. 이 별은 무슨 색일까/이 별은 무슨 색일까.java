import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		
		if(x >= 620 && x <= 780) System.out.println("Red");
		else if(x >= 590 && x < 620) System.out.println("Orange");
		else if(x >= 570 && x < 590) System.out.println("Yellow");
		else if(x >= 495 && x < 570) System.out.println("Green");
		else if(x >= 450 && x < 495) System.out.println("Blue");
		else if(x >= 425 && x < 450) System.out.println("Indigo");
		else if(x >= 380 && x < 425) System.out.println("Violet");
	}
}