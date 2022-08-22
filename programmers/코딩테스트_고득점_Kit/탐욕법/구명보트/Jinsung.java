import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left=0,right = people.length-1;
        // 가벼운 사람 무거운 사람의 무게를 계산해 보면서 보트에 같이 탈 수 있으면 같이 태운다.
        while(left<right){
            if(people[left]+people[right]<=limit){
                people[left] = 500;
                people[right] = 500;
                left+=1;
                right-=1;
                answer++;
            }else{
                right-=1;
            }
        }
        // 같이 못 타는 사람들은 한명씩 보트에 태운다.
        for(int i=0;i<people.length;i++){
            if(people[i]!=500){
                answer++;
            }
        }
        return answer;
    }
}