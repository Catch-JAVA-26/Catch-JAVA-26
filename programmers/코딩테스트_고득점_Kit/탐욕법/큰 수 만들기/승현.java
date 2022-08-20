class Solution {
    public String solution(String number, int k) {
        StringBuilder num = new StringBuilder(number);

        for (int i=0; i<num.length() && k > 0; i++) {
            char pivot = num.charAt(i);
            if (pivot == '9') continue;
            for (int j=i+1; j<num.length() && j-i <= k; j++) {
                if (pivot < num.charAt(j)) {
                    num.deleteCharAt(i);
                    k--;
                    i--;
                    break;
                }
            }
        }

        if (k > 0) {
            num.delete(num.length() - k, num.length());
        }

        return num.toString();
    }
}