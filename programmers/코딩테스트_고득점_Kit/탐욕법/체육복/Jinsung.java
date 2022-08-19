class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int left=0,right=0;
        int[] stu = new int[n];
        // 모든 학생들에게 체육복 할당
        for(int i=0;i<n;i++){
            stu[i]=1;
        }
        // 체육복을 잃어버린 학생은 체육복의 개수를 0으로 만든다.
        for(int l : lost){
            stu[l-1] = 0;
        }
        // 여벌의 체육복을 가진 사람은 한개씩 더 추가해준다.
        for(int r : reserve){
            stu[r-1]++;
        }
        // 양옆의 친구를 보면서 있으면 빌려입기
        for(int i=0;i<n;i++){
            left = i-1>=0 ? i-1 : left;
            right = i+1<n ? i+1 : right;
            // 체육복을 도둑 맞았다면..... 양옆의 친구 물어보며 빌려입기
            if(stu[i]==0){
                if(stu[left]>1){    // 왼쪽 친구가 여벌의 옷을 가지고 있다면 빌려입기
                    stu[left]--;
                    stu[i]++;
                }else if(stu[right]>1){ // 오른쪽 친구가 여벌의 옷을 가지고 있다면 빌려입기
                    stu[right]--;
                    stu[i]++;
                }
            }
            // 체육복이 있다면 answer 증가
            if(stu[i]>=1)
                answer++;
        }
        return answer;
    }
}