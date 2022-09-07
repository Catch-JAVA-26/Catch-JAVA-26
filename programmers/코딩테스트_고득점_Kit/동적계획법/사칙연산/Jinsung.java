import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int answer = 0;
        
        // 첫번째 값은 answer에 더한다.
        answer += Integer.parseInt(arr[0]);
        for(int i=1;i<arr.length;i+=2){
            // - 기호가 나오면 뒤의 사칙연산을 최소로 만드는 값과 원래 값을 비교하여 
            if("-".equals(arr[i])){
                String[] sub = Arrays.copyOfRange(arr, i+1, arr.length);
                int min = makeMinSum(sub);
                System.out.printf("original:"+arr[i+1]+"\tminSum:"+min+"\n");
                // 최소로 만든 연산결과 현재 값이 보다 작으면 최소로 만든 값을 answer 누적값에서 감하여 반환
                if(Integer.parseInt(arr[i+1])>min){
                    return answer + (min * -1);
                }else{  // 최소로 만든 값이 원래값보다 크거나 같으면 answer에서 원래값을 감하여 누적한다.
                    answer -= Integer.parseInt(arr[i+1]);
                }
            }else{  // + 기호가 나오면 answer에 누적하여 합한다.
                answer += Integer.parseInt(arr[i+1]);
            }
        }
        
        return answer;
    }
    
    public static int makeMinSum(String[] arr){
        
        int sum = 0;        
        
        // 사칙연산에서 가장 최솟값을 만드는 방법은 처음에 더하기 연산을 모두 더하고, 그리고 남은 음수연산을 하여
        // 모든 값들이 음수계산이 되도록 만들면 된다.
        for(int i=0;i<arr.length;i+=2){
            // 현재 위치가 arr의 범위를 벗어나지 않았다면
            if(i+2<arr.length){
                // 뒤에 있는 연산기호가 +라면 현재값과 뒤의 값을 더해서 뒤에값에 누적하고, 현재값은 0으로 변경한다.
                if("+".equals(arr[i+1])){
                    arr[i] = String.valueOf(Integer.parseInt(arr[i]) + Integer.parseInt(arr[i+2]));
                    arr[i+2] = "0";
                }
                // else{
                //     // 뒤의 연산기호가 -라면 뒤의 연산기호를 -를 곱해서 저장한다.
                //     arr[i+2] = String.valueOf(Integer.parseInt(arr[i+2])*-1);
                // }
            }
        }
        
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        
        sum = Integer.parseInt(arr[0]);
        
        // 남은 숫자들을 모두 더한다.
        for(int i=2;i<arr.length;i+=2){
            if("+".equals(arr[i-1])){
                sum += Integer.parseInt(arr[i]);
            }else{
                sum -= Integer.parseInt(arr[i]);
            }
        }
        
        return sum;
        
    }
}