class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] stu = new int[n + 2];

        for (int l: lost) {
            stu[l]--;
        }

        for (int r: reserve) {
            stu[r]++;
        }

        for (int i=1; i<=n; i++) {
            if (stu[i] < 0) {
                if (stu[i-1] > 0) {
                    stu[i-1]--;
                    stu[i]++;
                } else if (stu[i+1] > 0) {
                    stu[i+1]--;
                    stu[i]++;
                }
            }
        }

        for (int i=1; i<=n; i++) {
            if (stu[i] >= 0) answer++;
        }

        return answer;
    }
}