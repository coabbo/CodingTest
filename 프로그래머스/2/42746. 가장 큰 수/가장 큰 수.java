import java.util.*;

class Number implements Comparable<Number> {
    String value;
    
    Number(int num) {
        this.value = String.valueOf(num);
    }
    
    @Override
    public int compareTo(Number other) {
        String s1 = this.value + other.value;
        String s2 = other.value + this.value;
        return s2.compareTo(s1);
    }
}

class Solution {
    public String solution(int[] numbers) {
        Number[] arr = new Number[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = new Number(numbers[i]);
        }
        
        Arrays.sort(arr); // compareTo 기준 사용
        
        StringBuilder sb = new StringBuilder();
        for(Number num : arr) {
            sb.append(num.value);
        }
        
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }
}