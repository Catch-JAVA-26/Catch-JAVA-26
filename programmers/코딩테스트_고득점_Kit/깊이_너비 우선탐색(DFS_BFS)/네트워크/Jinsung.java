import java.util.*;

class Solution {
    static int[] ball;
    
    public int solution(int n, int[][] computers) {
        int answer = 1;
        ball = new int[n];
        
        // computers를 순회하며, 하나씩 연결을 확인한다.
        for(int g=0;g<computers.length;g++){
            for(int i=0;i<computers[g].length;i++){
                // 한번도 체크하지 않은 computer라면
                // network 하나를 생성하고, 현 컴퓨터와 연결된 컴퓨터를 찾아본다.
                if( ball[i] == 0 ){
                    ball[i] = answer;
                    connectComputer(computers,i,answer);
                    answer+=1;
                }
            }
        }
        // network 중 가장 순번이 큰 숫자를 맨 뒤로 가도록 오름차순 정렬을 한다.
        Arrays.sort(ball);
        
        return ball[n-1];
    }
    
    public static void connectComputer(int[][] com,int seq,int count){
        
        for(int i=0;i<com[seq].length;i++){
            // 자기 자신이 아니면서, 연결된 컴퓨터가 있고, 한번도 체크하지 않은 computer라면
            if(i != seq && com[seq][i] == 1 && ball[i] == 0 ){
                ball[i] = count;
                connectComputer(com,i,count);
            }
        }
        
        return;
    }
    
}