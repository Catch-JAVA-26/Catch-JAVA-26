import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    public static ArrayList<String> box = new ArrayList<>();
    
    public int solution(String numbers) {
        int answer = 0;
        // numbers에 있는 숫자들을 numChar에 담아서 낱개로 만들기
        char[] numChar = new char[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            numChar[i] = numbers.charAt(i);
        }
        
        // numChar의 숫자들로 만들 수 있는 모든 조합의 숫자들을 만든다.
        LinkedList<Character> charBox = new LinkedList<>();
        int[] visitCheck = new int[numbers.length()];
        for(int loop=1;loop<=numbers.length();loop++){
            permutation(numbers.length(),loop,numChar,charBox,visitCheck);    
        }
        
        // 생성된 모든 조합들을 숫자형태로 변형시켜 numBox에 담는다.
        List<Integer> numBox =  box.stream().map(Integer::parseInt).collect(Collectors.toList());
        
        // 조합의 최대 숫자까지 에라토스테네스의 체 배열을 만들어서 반환한다.
        int[] frame = createPrimeArr(Collections.max(numBox));
        
        // 만일 생성된 숫자가 소수일 경우 answer의 숫자를 증감시킨다(단, 한번 체크한 숫자는 증감에 반영시키지 않는다.)
        for(Integer n : numBox){
            if(n!=0 && n!= 1 && frame[n]==0){
                answer++;
                frame[n] = -1;
            }
        }
        
        return answer;
    }
        
    public static void permutation(int n, int r,char[] charArr, LinkedList<Character> perArr, int[] perCheck) {    
		// 구해야하는 r의 숫자와 perArr의 크기가 동일하다면, 해당 순열을 box에 추가한 후 return
        if(perArr.size() == r){
			String result = "";
            for(char i : perArr){
                result += i;
			}
            box.add(result);
			return;
		}
		
        //charArr의 길이까지 순회하면서, 한개씩 추가하며 순열을 만든다.
		for(int i=0; i< charArr.length; i++){
			if(perCheck[i] == 0){
				perArr.add(charArr[i]);
				perCheck[i] = 1;
				permutation(n, r, charArr, perArr, perCheck);
				perCheck[i] = 0;
				perArr.removeLast();
			}
		}
	}
    
    // 에라토스테네스의 체 공식으로 limit까지 소수의 틀을 만든다.
    public static int[] createPrimeArr(int limit){
        int[] frame = new int[limit+1];
        
        for(int i=2;i<=limit;i++){
            // 소수인 숫자는 건너뛴다.
            if(frame[i]!=0) continue;
            
            // 순회할 숫자의 배수를 순회하며, 숫자를 frame에 저장한다.
            for(int loop=i+i;loop<=limit;loop+=i){
                if(frame[loop]==0)
                    frame[loop] = loop;
            }
        }
        return frame;
    }
    
}
