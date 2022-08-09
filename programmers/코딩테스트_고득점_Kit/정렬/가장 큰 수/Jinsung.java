import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 숫자를 문자로 변환하여 num에 저장한다.
        String[] num = new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            num[i] = String.valueOf(numbers[i]);
        }
        // 2개의 문자를 합쳤을때 큰 숫자가 오도록 내림차순 정렬
        Arrays.sort(num,(o1, o2) -> {return (o1+o2).compareTo(o2+o1) * -1; });
        
        // 가장 큰 숫자가 0인 경우 문자열 0을 반환한다.
        if(num[0].equals("0")) return "0";
        
        // 모든 문자열을 다 연결해 준다.
        for(String s : num){
            answer+=s;
        }
        return answer;
    }
}