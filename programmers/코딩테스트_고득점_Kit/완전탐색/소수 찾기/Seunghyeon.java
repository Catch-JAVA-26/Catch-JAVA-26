import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        char[] nums = new char[numbers.length()];
        for (int i=0; i<numbers.length(); i++) {
            nums[i] = numbers.charAt(i);
        }

        for (int i=1; i<=numbers.length(); i++) {
            permutation(nums, 0, nums.length, i);
        }

        for (int num: set) {
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    public void permutation(char[] arr, int depth, int n, int r) {
        if (depth == r) {
            add(arr, r);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public void swap(char[] arr, int depth, int i) {
        char tmp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = tmp;
    }

    public void add(char[] arr, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<r; i++) {
            sb.append(arr[i]);
        }
        set.add(Integer.parseInt(sb.toString()));
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i=3; i<=Math.sqrt(n); i+=2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}