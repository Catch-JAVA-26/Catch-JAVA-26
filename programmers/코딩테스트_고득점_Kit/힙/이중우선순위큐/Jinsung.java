import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int min = 0;
        int max = 0;
        PriorityQueue<Integer> numQueue = new PriorityQueue<>();
        
        // operations를 순회하며 명령어를 읽는다.
        for(String s : operations){
            // 만일 'I'로 명령어가 시작한다면 " " 뒤에 나오는 숫자들을 numQueue에 집어 넣는다.
            if(s.charAt(0) == 'I'){
                String num = s.substring(s.indexOf(" ")+1);
                // 슷자가 음수일 경우 숫자부분만 따로 구한 후 -1을 곱해서 numQueue에 삽입한다.
                if(num.contains("-")){
                    numQueue.add(Integer.parseInt(num.substring(1))*-1);
                }else{
                    // 슷자가 양수일일 경우 숫자부분만 numQueue에 삽입한다.
                    numQueue.add(Integer.parseInt(num));    
                }
            }else if(s.charAt(0) == 'D'){   // 'D'로 명령어가 시작할 경우, numqueue에 요소가 존재하면 명령에 따라 요소를 제거 없다면 명령어를 무시한다.
                if(!numQueue.isEmpty()){
                    // 명령어에 '-'가 포함되어 있다면, 최솟값을 제거
                    if(s.indexOf("-")>=0){
                        min = Collections.min(numQueue);
                        numQueue.remove(min);
                        System.out.println(min);
                        
                    }else{  // 명령어가 '-'를 포함하고 있지 않다면, 최댓값을 제거
                        max = Collections.max(numQueue);
                        numQueue.remove(max);
                    }    
                }
            }
        }
        // numQueue에 값이 없다면 [0,0]을 answer에 저장
        if(numQueue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{  // numQueue에 값이 있다면 [최댓값,최솟값]을 answer에 저장.
            min = Collections.min(numQueue);
            max = Collections.max(numQueue);
            answer[0] = max;
            answer[1] = min;
        }
        
        return answer;
    }
}