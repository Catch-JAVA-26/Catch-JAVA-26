class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int index, int number) {
        if (index == numbers.length) {
            if (number == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, index+1, number+numbers[index]);
        dfs(numbers, target, index+1, number-numbers[index]);
    }
}