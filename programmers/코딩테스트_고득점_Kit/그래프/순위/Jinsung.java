class Solution {
    public int solution(int n, int[][] results) {
        
        int answer = 0;
        
        int[][] result = new int[n+1][n+1];
        
        // 시합 결과를 순회하며, 이기고 진 결과를 2차원 배열에 저장한다.
        for(int[] r : results){
            result[r[0]][r[1]] = 1;
            result[r[1]][r[0]] = -1;
        }
        
        // 정상적으로 2차원 배열을 순회하기 위한 r 반복문과 c 반복문
        for(int r=1;r<=n;r++){
            for(int c=1;c<=n;c++){
                // 나랑 상대한 상대방의 결과를 확인하기 위한 반복문
                for(int l=1;l<=n;l++){
                    // 내가 진 선수가 진 선수는 나보다 실력이 좋아서 나도 질것이므로 진다고 판단
                    if(result[r][c] == -1 && result[c][l] == -1){
                        result[r][l] = -1;
                        result[l][r] = 1;
                    }
                    // 내가 이긴 선수가 이긴 선수는 나보다 실력이 좋지 못해서 나도 이길것이라고 판단
                    if(result[r][c] == 1 && result[c][l] == 1){
                        result[r][l] = 1;
                        result[l][r] = -1;
                    }
                }
            }
        }
        
        // 2차원 배열을 순회하며, 자신 이외에 상대방의 선수와의 예상 결과가 모두 입력되었다면, 결과를 알 수 있다고 판단.
        for(int r=1;r<=n;r++){
            int countZero = 0;
            for(int c=1;c<=n;c++){
                if(result[r][c]==0){
                    countZero+=1;
                }
            }
            if(countZero==1){
                answer+=1;
            }
        }
        
        return answer;
    }
}