import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 전화번호부를 사전순으로 정렬
        Arrays.sort(phone_book);
        // 전화번호부 하나 앞과 현재를 비교하며, 접두사 일경우 false를 return
        // 자신의 앞과 현재를 비교하는건 "123","1234"일 경우 자신의 접두사가 앞에 있을때를 고려한 경우
        for(int loop=1;loop<phone_book.length;loop++){
            String shortStr = phone_book[loop-1].length() > phone_book[loop].length() ? phone_book[loop] : phone_book[loop-1];
            String longStr = phone_book[loop-1].length() > phone_book[loop].length() ? phone_book[loop-1] : phone_book[loop];
            if(longStr.indexOf(shortStr)==0){
                return false;
            } 
        }
        return answer;
    }
}