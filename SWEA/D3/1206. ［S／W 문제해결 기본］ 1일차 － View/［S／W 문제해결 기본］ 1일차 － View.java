import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        ArrayList<Integer> arrList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        int answer = 0;
 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            arrList.clear();
            T=sc.nextInt();
            for(int i = 0; i < T; i++){
                arrList.add(sc.nextInt());
            }
            int secondMax = 0;
            answer = 0;
            for(int i = 2; i <= T - 2 - 1; i++){
                if(arrList.get(i - 2) < arrList.get(i) && arrList.get(i - 1) < arrList.get(i) && arrList.get(i + 1) < arrList.get(i) && arrList.get(i + 2) < arrList.get(i)){
                    tempList.clear();
                    tempList.add(arrList.get(i - 2));
                    tempList.add(arrList.get(i - 1));
                    tempList.add(arrList.get(i + 1));
                    tempList.add(arrList.get(i + 2));
                    Collections.sort(tempList);
                    secondMax = tempList.get(3);
                    answer += arrList.get(i) -  secondMax;
                }       
            }
            System.out.println("#" + test_case + " " + answer);
        }
    }
}