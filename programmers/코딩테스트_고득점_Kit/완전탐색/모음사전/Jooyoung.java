class Solution {
    public int solution(String word) {
        int[] x = {781, 156, 31, 6, 1};
        String str = "AEIOU";
        
        int result = word.length();

        for (int i = 0; i < word.length(); i++){
            result += x[i] * str.indexOf(word.charAt(i));
        }

        return result;
    }
}
