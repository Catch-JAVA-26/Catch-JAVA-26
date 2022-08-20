class Solution {
    public int solution(String name) {
        int length = name.length();
        int upDown = 0, leftRight = length - 1;

        for (int i=0; i<name.length(); i++) {
            upDown += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int idx = i + 1;
            while (idx < length && name.charAt(idx) == 'A') {
                idx++;
            }

            leftRight = Math.min(leftRight, i * 2 + length - idx);
            leftRight = Math.min(leftRight, i + (length - idx) * 2);
        }

        return upDown + leftRight;
    }
}