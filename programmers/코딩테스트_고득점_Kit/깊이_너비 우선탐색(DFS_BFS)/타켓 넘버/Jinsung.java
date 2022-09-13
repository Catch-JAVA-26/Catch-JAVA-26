import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        // 입력받은 정수를 정수값과 음수값을 저장할 수 있는 2차원 배열 선언
        int[][] numBox = new int[numbers.length][2];
        
        // numbers를 순회하며 정수값과 음수값을 저장
        for(int i=0;i<numbers.length;i++){
            numBox[i][0] = numbers[i];
            numBox[i][1] = numbers[i]*-1;
        }
        
        // 정수,음수값의 조합을 구하고 그 합이 target과 같은지 찾는 로직
        dfs(numBox,0,new int[numbers.length],target);
        
        return answer;
    }
    
    public void dfs(int[][] numBox,int depth,int[] box,int target){
        
        // depth가 numBox와 같다면(모든 숫자를 다 사용했다면)
        if(depth==numBox.length){
            // box에 채워진 숫자들의 합을 계산하여 target과 같으면 answer를 증감
            int sum = Arrays.stream(box).sum();
            if(sum == target){
                answer+=1;
            }
            return;
        }
        
        // box에 정수값을 저장하고 다음 depth로 이동
        box[depth] = numBox[depth][0];
        dfs(numBox,depth+1,box,target);
        // box에 음수값을 저장하고 다음 depth로 이동
        box[depth] = numBox[depth][1];
        dfs(numBox,depth+1,box,target);
        
        return;
    }
    
}