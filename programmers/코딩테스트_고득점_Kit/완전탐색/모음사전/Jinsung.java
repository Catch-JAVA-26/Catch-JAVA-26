import java.util.*;
class Solution {
    
    public static ArrayList<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        
        int answer = 0;
        // 알파벳 모음 AEIOU 정의
        String alphabet = "AEIOU";
        
        // AEIOU의 모음을 charBox에 하나씩 저장
        char[] charBox = new char[alphabet.length()];
        for(int i=0;i<alphabet.length();i++){
            charBox[i] = alphabet.charAt(i);
        }
        // AEIOU를 1자리부터 5자리까지 중복 순열을 생성
        LinkedList<Character> rePerArr = new LinkedList<>();
        for(int i=1;i<=alphabet.length();i++){
            rePermutation(alphabet.length(),i,charBox,rePerArr);
        }
        // 사전순서대로 정렬
        dictionary.sort(null);
        
        // 순서는 1부터 시작이므로 찾은 순서에 1을 더한다.
        return dictionary.indexOf(word)+1;
    }
    
    // 알파벳들이 중복으로 선택되어 배치될 수 있으므로 중복순열을 구하는 method 구현
    private static void rePermutation(int n, int r,char[] charBox, LinkedList<Character> rePerArr) {
		
        if(rePerArr.size() == r){
			String result = "";
            for(char i : rePerArr){
                result += i;
			}
         
            dictionary.add(result);
			return;
		}
		for(int i=0; i<charBox.length; i++){	
			rePerArr.add(charBox[i]);
			rePermutation(n, r,charBox, rePerArr);
			rePerArr.removeLast();
		}	
	}
    
}