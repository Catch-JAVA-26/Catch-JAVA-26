class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n+1][m+1];
        
        // puddles가 있는 곳은 미리 -1로 표시를 해둔다.
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        // 시작점에서 시작하는 경우의 수는 1가지 이므로 1을 저장한다.
        map[1][1] = 1;
        
        for(int r=1;r<=n;r++){
            for(int c=1;c<=m;c++){
                // puddles로 표시한 곳을 다시 0으로 변경한다.(어차피 해당 위치를 지나가는 경우의 수는 0이므로)
                if(map[r][c]==-1){
                    map[r][c] = 0;
                }
                else if(r==1 && c ==1){ // 첫번째 줄은 어떻게 가든 1가지 방법밖에 갈 수 있는 방법이 없으므로 1을 저장
                    map[r][c] = 1;
                }else{  // 위에서 오는 경우의 수와 왼쪽에서 오는 경우의 수를 합하여 현재 위치의 경우의 수를 구한다.
                    map[r][c] = (map[r-1][c] + map[r][c-1])%1000000007;
                }
            }
        }
        // 도착지의 경우의 수를 구한다.
        return map[n][m];
    }
}
