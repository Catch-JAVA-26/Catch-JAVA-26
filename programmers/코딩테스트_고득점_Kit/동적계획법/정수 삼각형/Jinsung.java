class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int index = 0;
        int[] box = new int[triangle.length*triangle.length];
        for(int o=0;o<triangle.length;o++){
            for(int i=0;i<triangle[o].length;i++){
                
                if(o==0){
                    // 어차피 자신이 최댓값 이므로 자신의 값을 box에 집어 넣는다.
                    box[index] = triangle[o][index]; 
                }else{
                    if( i == 0 ){
                        // 자신의 숫자와 자신의 오른쪽 위 숫자의 누적합을 box에 저장한다.
                        box[index] = box[index - triangle[o-1].length] + triangle[o][i];
                    }else if(i == triangle[o].length-1){
                        // 자신의 숫자와 자신의 왼쪽 위 숫자의 누적합을 box에 저장한다.
                        box[index] = box[index - triangle[o].length] + triangle[o][i];
                    }else{
                        // 자신과 왼쪽 위의 합산과 자신과 오른쪽 위의 합산 값을 더한 값 중 큰 값을 box에 저장한다.
                        int l = box[index - triangle[o].length] + + triangle[o][i];
                        int r = box[1 + index - triangle[o].length] + + triangle[o][i];
                        box[index] = Math.max(l,r);
                    }
                }
                index += 1;   
            }
        }
        
        // box의 숫자들 중 밑볕의 숫자들을 고려한 숫자의 최댓값만 고려하면 되므로, 밑변의 숫자에서 시작해서 마지막 index 직전의 숫자들 중 최대값을 고른다.
        for(int i=index-triangle[triangle.length-1].length;i<index;i++){
            answer = answer < box[i] ? box[i] : answer;
        }
        
        return answer;
    }
}