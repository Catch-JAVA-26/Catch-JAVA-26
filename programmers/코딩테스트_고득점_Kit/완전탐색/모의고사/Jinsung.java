import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        ArrayList<Integer> winner = new ArrayList<>();
        int[] stu1 = {1,2,3,4,5};
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 문제의 답과 학생의 답을 비교하며, 동일할 경우 각 학생의 맞은 개수를 증가시킨다.
        for(int loop=0;loop<answers.length;loop++){
            
            if(answers[loop] == stu1[loop%stu1.length]){
                s1++;
            }
            if(answers[loop] == stu2[loop%stu2.length]){
                s2++;
            }
            if(answers[loop] == stu3[loop%stu3.length]){
                s3++;
            }
            
        }
        
        // 최댓값을 max에 저장한다.
        int max = Math.max(s1,s2);
        max = Math.max(max,s3);
        // 학생1,2,3이 맞은 개수를 최댓값과 비교하며, 최댓값과 동일 할 경우 winner에 학생의 번호를 추가한다.
        if(s1==max){
            winner.add(1);
        }
        if(s2==max){
            winner.add(2);
        }
        if(s3==max){
            winner.add(3);
        }
        
        int[] answer = new int[winner.size()];
        for(int i=0;i<winner.size();i++){
            answer[i] = winner.get(i);
        }
        return answer;
    }
}
